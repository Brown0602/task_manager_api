package com.tuaev.task_manager.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Tasks")
public class Task implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "heading")
    private String heading;
    @Column(name = "description")
    private String description;
    @Column(name = "dateOfCreation")
    private Date dateOfCreation;
    @Column(name = "status")
    private boolean status;
    @Column(name = "completionDate")
    private Date completionDate;
}
