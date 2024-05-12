package com.taoassignment.repository;

import main.java.com.taoassignment.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Define custom query methods if needed
}