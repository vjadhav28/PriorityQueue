package com.taoassignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TaskAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
