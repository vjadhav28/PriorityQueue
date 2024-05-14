package com.taoassignment.controller;

import com.taoassignment.model.Task;
import com.taoassignment.model.TaskStatistics;
import com.taoassignment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok().body(createdTask);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(taskId, task);
        return ResponseEntity.ok().body(updatedTask);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().body("Task deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping("/{taskId}/assign")
    public ResponseEntity<String> assignTask(@PathVariable Long taskId, @RequestBody Long userId) {
        taskService.assignTask(taskId, userId);
        return ResponseEntity.ok().body("Task assigned successfully");
    }

    @PutMapping("/{taskId}/progress")
    public ResponseEntity<String> setTaskProgress(@PathVariable Long taskId, @RequestBody int progress) {
        taskService.setTaskProgress(taskId, progress);
        return ResponseEntity.ok().body("Task progress updated successfully");
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Task>> getOverdueTasks() {
        List<Task> overdueTasks = taskService.getOverdueTasks();
        return ResponseEntity.ok().body(overdueTasks);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getCompletedTasksByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        List<Task> completedTasks = taskService.getCompletedTasksByDateRange(startDate, endDate);
        return ResponseEntity.ok().body(completedTasks);
    }

    @GetMapping("/statistics")
    public ResponseEntity<TaskStatistics> getTasksStatistics() {
        TaskStatistics statistics = taskService.getTasksStatistics();
        return ResponseEntity.ok().body(statistics);
    }
}