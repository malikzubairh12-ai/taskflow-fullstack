package com.hasan.taskflow.config;

import com.hasan.taskflow.model.*;
import com.hasan.taskflow.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seedTasks(TaskRepository repo){ return args -> { if(repo.count()==0){ repo.save(new Task("Finish Spring Boot project", "Prepare project for GitHub portfolio", TaskStatus.IN_PROGRESS, Priority.HIGH, LocalDate.now().plusDays(5))); repo.save(new Task("Apply for Werkstudent jobs", "Send applications with GitHub link", TaskStatus.TODO, Priority.HIGH, LocalDate.now().plusDays(10))); repo.save(new Task("Practice SQL joins", "Revise joins and group by", TaskStatus.TODO, Priority.MEDIUM, LocalDate.now().plusDays(14))); } }; }
}
