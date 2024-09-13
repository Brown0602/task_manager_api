package com.tuaev.task_manager.dto;

import com.tuaev.task_manager.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class TaskDTO {

    private String heading;
    private String description;
    private Date dateCreation;
    private Status status;
    private Date completionDate;
}
