package com.tuaev.task_manager.controllers;

import com.tuaev.task_manager.dto.TaskDTO;
import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/")
public class TaskManagerCreateTaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private Task task;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Task createTask(@RequestBody TaskDTO taskDTO){

        task.setHeading(taskDTO.getHeading());
        task.setDescription(taskDTO.getDescription());
        task.setDateOfCreation(taskDTO.getDateOfCreation());
        task.setCompletionDate(taskDTO.getCompletionDate());
        task.setStatus(false);
        taskService.save(task);
        return task;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public void deleteTaskById(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String updateTaskById(@PathVariable("id") Long id){
        Optional<Task> taskOptional = taskService.findById(id);
        if (taskOptional.isPresent()){
            task = taskOptional.get();
            task.setHeading("Работа");
            task.setDescription("Собирать заказы");
            task.setStatus(false);
            taskService.save(task);
        }else {
            return "Такая задача не найдена";
        }
        return null;
    }

    @RequestMapping(value = "task/{id}", method = RequestMethod.GET)
    public @ResponseBody Task getTaskById(@PathVariable("id") Long id){
        Optional<Task> taskOptional = taskService.findById(id);
        if (taskOptional.isPresent()){
            task = taskOptional.get();
            return task;
        }else {
            return taskOptional.get();
        }
    }

    @RequestMapping(value = "tasks", method = RequestMethod.GET)
    public Iterable<Task> getTask(){
        return taskService.findAll();
    }
}
