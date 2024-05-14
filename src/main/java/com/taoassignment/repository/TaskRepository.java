package com.taoassignment.repository;

import com.taoassignment.model.Task;
import com.taoassignment.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDueDateBeforeAndStatusNot(LocalDate currentDate, TaskStatus status);

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByCompletedDateBetween(LocalDate startDate, LocalDate endDate);

    long countByStatus(TaskStatus status);
}