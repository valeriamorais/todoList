package com.impl.todoList.repository;

import com.impl.todoList.model.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {
        List<TaskItem> findByTaskId(Long taskId);
        Optional<TaskItem> findByIdAndTaskId(Long id, Long taskId);
}
