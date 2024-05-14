package com.taoassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taoassignment.model.TaskAssignment;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {
    }
