package com.tuaev.task_manager.controllers;

import com.tuaev.task_manager.RequestDaysOff;
import com.tuaev.task_manager.Status;
import com.tuaev.task_manager.dto.TaskDTO;
import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.json.DaysOffJson;
import com.tuaev.task_manager.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/")
public class TaskManagerCreateTaskController {

    private final TaskService taskService;
    private final List<DaysOffJson> daysOffJsonList;

    public TaskManagerCreateTaskController(TaskService taskService) throws IOException, InterruptedException {
        this.taskService = taskService;
        this.daysOffJsonList = RequestDaysOff.getDaysOff();
    }

    @PostMapping("create")
    public String createTask(@RequestBody TaskDTO taskDTO){

        for (int i = 0; i < daysOffJsonList.size(); i++){
            if (daysOffJsonList.get(i).getDate().equals(taskDTO.getCompletionDate())){
                LocalDate localDate = new java.sql.Date(daysOffJsonList.get(i).getDate().getTime()).toLocalDate();
                System.out.println(localDate.plusDays(1));

                return "Ошибка! Дата завершения задачи не может попадать на праздник. Выберите другой день - " +
                        "ближайшая дата " + localDate.plusDays(1);
            }
        }

        Task task = new Task();
        task.setHeading(taskDTO.getHeading());
        task.setDescription(taskDTO.getDescription());
        task.setDateCreation(taskDTO.getDateCreation());
        task.setCompletionDate(taskDTO.getCompletionDate());
        task.setStatus(Status.notCompleted);
        taskService.save(task);
        return "";
    }

    @PostMapping("delete/{id}")
    public void deleteTaskById(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }

    @PostMapping("update/{id}")
    public String updateTaskById(@PathVariable("id") Long id){
        Optional<Task> taskOptional = taskService.findById(id);
        if (taskOptional.isPresent()){
            Task task = taskOptional.get();
            task.setHeading("Работа");
            task.setDescription("Собирать заказы");
            task.setStatus(Status.notCompleted);
            taskService.save(task);
        }else {
            return "Такая задача не найдена";
        }
        return null;
    }

    @GetMapping("task/{id}")
    public @ResponseBody Task getTaskById(@PathVariable("id") Long id){
        Optional<Task> taskOptional = taskService.findById(id);
        return taskOptional.orElseGet(taskOptional::get);
    }

    @GetMapping(value = "tasks")
    public Iterable<Task> getTask(){
        return taskService.findAll();
    }
}
