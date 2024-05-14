package com.taoassignment.controller;

import com.taoassignment.model.Task;
import com.taoassignment.repository.TaskRepository;
import com.taoassignment.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTask() {
        Task task = new Task();
        when(taskRepository.save(task)).thenReturn(task);

        Task createdTask = taskService.createTask(task);

        assertEquals(task, createdTask);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    public void testUpdateTask() {
        Long taskId = 1L;
        Task task = new Task();
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        Task updatedTask = taskService.updateTask(taskId, task);

        assertEquals(task, updatedTask);
        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, times(1)).save(task);
    }

}