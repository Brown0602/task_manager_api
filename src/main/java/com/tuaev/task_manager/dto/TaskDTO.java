package com.tuaev.task_manager.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO {

    private String heading;
    private String description;
    private Date dateOfCreation;
    private boolean status;
    private Date completionDate;
}
