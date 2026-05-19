package com.hasan.taskflow.dto;

import com.hasan.taskflow.model.Priority;
import com.hasan.taskflow.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class TaskRequest {
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 80, message = "Title must be between 3 and 80 characters")
    private String title;
    @Size(max = 500, message = "Description must be max 500 characters")
    private String description;
    private TaskStatus status;
    private Priority priority;
    private LocalDate dueDate;
    public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
    public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
    public TaskStatus getStatus(){return status;} public void setStatus(TaskStatus status){this.status=status;}
    public Priority getPriority(){return priority;} public void setPriority(Priority priority){this.priority=priority;}
    public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate dueDate){this.dueDate=dueDate;}
}
