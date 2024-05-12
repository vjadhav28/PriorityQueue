package com.taoassignment.service;

import main.java.com.taoassignment.model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    Task updateTask(Long taskId, Task task);

    void deleteTask(Long taskId);

    List<Task> getAllTasks();

}