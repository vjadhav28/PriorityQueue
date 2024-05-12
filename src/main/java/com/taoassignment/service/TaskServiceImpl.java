package com.taoassignment.service;

import com.taoassignment.repository.TaskRepository;
import main.java.com.taoassignment.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        // Implement logic to create task and save in repository
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task task) {
        // Implement logic to update task and save in repository
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        // Implement logic to delete task from repository
        taskRepository.deleteById(taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        // Implement logic to get all tasks from repository
        return taskRepository.findAll();
    }

    // Implement other service methods...
}