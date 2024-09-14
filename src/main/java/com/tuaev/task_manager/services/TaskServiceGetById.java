package com.tuaev.task_manager.services;

import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class TaskServiceGetById {

    TaskRepository taskRepository;

    public Task getTaskById(Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElseGet(taskOptional::get);

    }
}
