package com.tuaev.task_manager.controllers;

import com.tuaev.task_manager.dto.TaskDTO;
import com.tuaev.task_manager.entity.Task;
import com.tuaev.task_manager.services.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Data
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/")
public class TaskManagerCreateTaskController {

    TaskServiceGetAll taskServiceGetAllTasks;
    TaskServiceGetById taskServiceGetTaskById;
    TaskServiceUpdateById taskServiceUpdateById;
    TaskServiceDeleteById taskServiceDeleteById;
    TaskServiceSave taskServiceSave;

    @PostMapping("create")
    public String createTask(@RequestBody TaskDTO taskDTO) throws IOException, InterruptedException {
        return taskServiceSave.saveTask(taskDTO);
    }

    @DeleteMapping("delete/{id}")
    public String deleteTaskById(@PathVariable("id") Long id) {
        return taskServiceDeleteById.deleteTask(id);
    }

    @PutMapping("update/{id}")
    public String updateTaskById(@PathVariable("id") Long id) {
        return taskServiceUpdateById.updateTask(id);
    }

    @GetMapping("task/{id}")
    public @ResponseBody Task getTaskById(@PathVariable("id") Long id) {
        return taskServiceGetTaskById.getTaskById(id);
    }

    @GetMapping(value = "tasks")
    public Iterable<Task> getTask() {
        return taskServiceGetAllTasks.getAllTasks();
    }
}
