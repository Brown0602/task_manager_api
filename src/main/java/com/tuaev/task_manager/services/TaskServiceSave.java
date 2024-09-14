package com.tuaev.task_manager.services;

import com.tuaev.task_manager.RequestDaysOff;
import com.tuaev.task_manager.Status;
import com.tuaev.task_manager.dto.DaysOffDTO;
import com.tuaev.task_manager.dto.TaskDTO;
import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Data
@Service
public class TaskServiceSave {

    TaskRepository taskRepository;

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
}
