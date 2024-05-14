package com.taoassignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
    private LocalDate completedDate;
    private Integer progress;
    private String priority;

    public void updateTaskDetails(Task updatedTask) {
        this.setTitle(updatedTask.getTitle());
        this.setDescription(updatedTask.getDescription());
        this.setDueDate(updatedTask.getDueDate());
        this.setStatus(updatedTask.getStatus());

        if (updatedTask.getStatus().equals(TaskStatus.COMPLETED)) {
            this.setCompletedDate(LocalDate.now());
        }
    }

    public void assignToUser(Long userId) {
        this.setId(userId);
    }

}