package com.tuaev.task_manager.services;

import com.tuaev.task_manager.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class TaskServiceDeleteById {

    TaskRepository taskRepository;

    public String deleteTask(Long id){
        taskRepository.deleteById(id);
        return "Задача удалена";
    }
}
