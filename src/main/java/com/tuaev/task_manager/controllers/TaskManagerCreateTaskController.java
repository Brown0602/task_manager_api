package com.tuaev.task_manager.controllers;

import com.tuaev.task_manager.dto.TaskDTO;
import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.services.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Setter
@Getter
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/")
public class TaskManagerCreateTaskController {

    TaskService taskService;

    @PostMapping("create")
    public String createTask(@RequestBody TaskDTO taskDTO) throws IOException, InterruptedException {
        return taskService.saveTask(taskDTO);
    }

    @DeleteMapping("delete/{id}")
    public String deleteTaskById(@PathVariable("id") Long id) {
        return taskService.deleteTask(id);
    }

    @PutMapping("update/{id}")
    public String updateTaskById(@PathVariable("id") Long id) {
        return taskService.updateTask(id);
    }

    @GetMapping("task/{id}")
    public @ResponseBody Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping(value = "tasks")
    public Iterable<Task> getTask() {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "tasks/{pageNumber}/{status}")
    public Iterable<Task> getTaskStatus(@PathVariable("pageNumber") int pageNumber, @PathVariable("status") String status){
        return taskService.getTaskStatus(pageNumber, status);
    }
}
