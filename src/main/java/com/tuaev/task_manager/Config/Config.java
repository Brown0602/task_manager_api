package com.tuaev.task_manager.Config;

import com.tuaev.task_manager.entity.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Task task(){
        Task task = new Task();
        return task;
    }
}
