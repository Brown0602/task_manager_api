package com.tuaev.task_manager.services;

import com.tuaev.task_manager.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskService extends CrudRepository<Task, Long> {

}
