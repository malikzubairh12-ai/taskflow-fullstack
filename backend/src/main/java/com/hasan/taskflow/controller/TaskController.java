package com.hasan.taskflow.controller;

import com.hasan.taskflow.dto.TaskRequest;
import com.hasan.taskflow.dto.TaskStatsResponse;
import com.hasan.taskflow.model.Task;
import com.hasan.taskflow.model.TaskStatus;
import com.hasan.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){ this.taskService = taskService; }
    @GetMapping public List<Task> getAllTasks(){ return taskService.getAllTasks(); }
    @GetMapping("/{id}") public Task getTaskById(@PathVariable Long id){ return taskService.getTaskById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Task createTask(@Valid @RequestBody TaskRequest request){ return taskService.createTask(request); }
    @PutMapping("/{id}") public Task updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequest request){ return taskService.updateTask(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void deleteTask(@PathVariable Long id){ taskService.deleteTask(id); }
    @GetMapping("/search") public List<Task> searchTasks(@RequestParam String title){ return taskService.searchByTitle(title); }
    @GetMapping("/status/{status}") public List<Task> filterByStatus(@PathVariable TaskStatus status){ return taskService.filterByStatus(status); }
    @GetMapping("/stats") public TaskStatsResponse getStats(){ return taskService.getStats(); }
}
