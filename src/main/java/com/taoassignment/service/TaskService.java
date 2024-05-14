package com.taoassignment.service;

import com.taoassignment.model.Task;
import com.taoassignment.model.TaskStatistics;
import com.taoassignment.model.TaskStatus;
import com.taoassignment.repository.TaskRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public TaskService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task task) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        existingTask.updateTaskDetails(task);

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void assignTask(Long taskId, Long userId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        task.assignToUser(userId);

        taskRepository.save(task);
    }

    public void setTaskProgress(Long taskId, int progress) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        task.setProgress(progress);

        taskRepository.save(task);
    }

    public List<Task> getOverdueTasks() {
        LocalDate currentDate = LocalDate.now();
        return taskRepository.findByDueDateBeforeAndStatusNot(currentDate, TaskStatus.COMPLETED);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(TaskStatus.valueOf(status.toUpperCase()));
    }

    public List<Task> getCompletedTasksByDateRange(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return taskRepository.findByCompletedDateBetween(start, end);
    }

    public TaskStatistics getTasksStatistics() {
        long totalTasks = taskRepository.count();
        long completedTasks = taskRepository.countByStatus(TaskStatus.COMPLETED);
        double percentageCompleted = (double) completedTasks / totalTasks * 100;

        return new TaskStatistics(totalTasks, completedTasks, percentageCompleted);
    }
}