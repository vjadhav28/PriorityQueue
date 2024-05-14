package com.taoassignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TaskStatistics.java
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TaskStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private long totalTasks;
    private long completedTasks;
    private double completionRate;

    public TaskStatistics(long totalTasks, long completedTasks, double percentageCompleted) {
    }

    // Getters and setters
    public long getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(long totalTasks) {
        this.totalTasks = totalTasks;
    }

    public long getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(long completedTasks) {
        this.completedTasks = completedTasks;
    }

    public double getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(double completionRate) {
        this.completionRate = completionRate;
    }
}

