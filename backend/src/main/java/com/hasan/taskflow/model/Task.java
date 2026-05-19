package com.hasan.taskflow.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private LocalDate dueDate;
    private LocalDateTime createdAt;

    public Task() {}
    public Task(String title, String description, TaskStatus status, Priority priority, LocalDate dueDate) {
        this.title = title; this.description = description; this.status = status; this.priority = priority; this.dueDate = dueDate; this.createdAt = LocalDateTime.now();
    }
    @PrePersist public void prePersist(){ if(createdAt==null) createdAt=LocalDateTime.now(); if(status==null) status=TaskStatus.TODO; if(priority==null) priority=Priority.MEDIUM; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
    public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
    public TaskStatus getStatus(){return status;} public void setStatus(TaskStatus status){this.status=status;}
    public Priority getPriority(){return priority;} public void setPriority(Priority priority){this.priority=priority;}
    public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate dueDate){this.dueDate=dueDate;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
}
