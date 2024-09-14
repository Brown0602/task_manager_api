package com.tuaev.task_manager.entity;

import com.tuaev.task_manager.Status;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate dateCreation;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "completionDate")
    private LocalDate completionDate;
}
