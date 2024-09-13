package com.tuaev.task_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TaskManagerApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(TaskManagerApplication.class, args);
		RequestDaysOff.getDaysOff();
	}

}
