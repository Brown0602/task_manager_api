package com.tuaev.task_manager.services;

import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class TaskServiceGetAll {

    TaskRepository taskRepository;

    public Iterable<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}
