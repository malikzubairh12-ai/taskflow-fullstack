package com.hasan.taskflow.service;

import com.hasan.taskflow.dto.TaskRequest;
import com.hasan.taskflow.model.Priority;
import com.hasan.taskflow.model.Task;
import com.hasan.taskflow.model.TaskStatus;
import com.hasan.taskflow.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {
    @Test
    void createTask_shouldSaveTask() {
        TaskRepository repo = Mockito.mock(TaskRepository.class);
        TaskService service = new TaskService(repo);
        TaskRequest request = new TaskRequest();
        request.setTitle("Test task"); request.setDescription("Description"); request.setStatus(TaskStatus.TODO); request.setPriority(Priority.HIGH); request.setDueDate(LocalDate.now());
        when(repo.save(any(Task.class))).thenAnswer(inv -> inv.getArgument(0));
        Task saved = service.createTask(request);
        assertEquals("Test task", saved.getTitle());
        verify(repo, times(1)).save(any(Task.class));
    }
    @Test
    void getTaskById_shouldThrowWhenMissing() {
        TaskRepository repo = Mockito.mock(TaskRepository.class);
        when(repo.findById(99L)).thenReturn(Optional.empty());
        TaskService service = new TaskService(repo);
        assertThrows(RuntimeException.class, () -> service.getTaskById(99L));
    }
}
