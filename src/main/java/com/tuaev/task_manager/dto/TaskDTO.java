package com.tuaev.task_manager.dto;

import com.tuaev.task_manager.Status;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TaskDTO {
    String heading;
    String description;
    LocalDate dateCreation;
    Status status;
    LocalDate completionDate;
}
