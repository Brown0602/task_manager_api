package com.tuaev.task_manager.services;

import com.tuaev.task_manager.RequestDaysOff;
import com.tuaev.task_manager.Status;
import com.tuaev.task_manager.dto.DaysOffDTO;
import com.tuaev.task_manager.dto.TaskDTO;
import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.repositories.TaskRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;
@Getter
@Setter
@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public String saveTask(TaskDTO taskDTO) throws IOException, InterruptedException {
        List<DaysOffDTO> daysOffDTOList = RequestDaysOff.getDaysOff();
        for (DaysOffDTO dto : daysOffDTOList) {
            if (dto.getLocalDate().equals(taskDTO.getCompletionDate())) {
                return "Ошибка! Дата завершения задачи не может попадать на праздник. " +
                        "Выбери другой день. Ближайший доступный день: " + dto.getLocalDate().plusDays(1);
            }
        }
        Task task = new Task();
        task.setHeading(taskDTO.getHeading());
        task.setDescription(taskDTO.getDescription());
        task.setDateCreation(taskDTO.getDateCreation());
        task.setCompletionDate(taskDTO.getCompletionDate());
        task.setStatus(Status.notCompleted);
        taskRepository.save(task);
        return "";
    }

    public String deleteTask(Long id){
        taskRepository.deleteById(id);
        return "Задача удалена";
    }

    public Iterable<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElseGet(taskOptional::get);

    }

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

    public Iterable<Task> getTaskStatus(int PageNumber, String status){
        Pageable pageable = PageRequest.of(PageNumber, 5);
        Page<Task> page = taskRepository.listTasks(status, pageable);;
        return page.getContent();
    }
}
