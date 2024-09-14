package com.tuaev.task_manager.services;

import com.tuaev.task_manager.Status;
import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class TaskServiceUpdateById {

    TaskRepository taskRepository;

    public String updateTask(Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            return "Такая задача не найдена";
        }
        Task task = taskOptional.get();
        task.setHeading("Работа");
        task.setDescription("Собирать заказы");
        task.setStatus(Status.notCompleted);
        taskRepository.save(task);
        return "Ваша задача обновлена";
    }
}
