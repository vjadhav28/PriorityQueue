package main.java.com.taoassignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Long taskId;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
    private LocalDate completedDate;
}
