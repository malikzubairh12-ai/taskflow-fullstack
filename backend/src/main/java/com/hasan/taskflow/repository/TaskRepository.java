package com.hasan.taskflow.repository;

import com.hasan.taskflow.model.Task;
import com.hasan.taskflow.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleContainingIgnoreCase(String title);
    List<Task> findByStatus(TaskStatus status);
    long countByStatus(TaskStatus status);
}
