package com.hasan.taskflow.service;

import com.hasan.taskflow.dto.TaskRequest;
import com.hasan.taskflow.dto.TaskStatsResponse;
import com.hasan.taskflow.model.Task;
import com.hasan.taskflow.model.TaskStatus;
import com.hasan.taskflow.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) { this.taskRepository = taskRepository; }
    public List<Task> getAllTasks(){ return taskRepository.findAll(); }
    public Task getTaskById(Long id){ return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with id: " + id)); }
    public Task createTask(TaskRequest request){ Task task = new Task(request.getTitle(), request.getDescription(), request.getStatus(), request.getPriority(), request.getDueDate()); return taskRepository.save(task); }
    public Task updateTask(Long id, TaskRequest request){ Task task = getTaskById(id); task.setTitle(request.getTitle()); task.setDescription(request.getDescription()); task.setStatus(request.getStatus()); task.setPriority(request.getPriority()); task.setDueDate(request.getDueDate()); return taskRepository.save(task); }
    public void deleteTask(Long id){ if(!taskRepository.existsById(id)) throw new RuntimeException("Task not found with id: " + id); taskRepository.deleteById(id); }
    public List<Task> searchByTitle(String title){ return taskRepository.findByTitleContainingIgnoreCase(title); }
    public List<Task> filterByStatus(TaskStatus status){ return taskRepository.findByStatus(status); }
    public TaskStatsResponse getStats(){ return new TaskStatsResponse(taskRepository.count(), taskRepository.countByStatus(TaskStatus.TODO), taskRepository.countByStatus(TaskStatus.IN_PROGRESS), taskRepository.countByStatus(TaskStatus.DONE)); }
}
