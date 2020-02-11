package com.impl.todoList.model;

import org.springframework.data.repository.CrudRepository;

public interface TaskItemRepository extends CrudRepository<TaskItem, Long> {

}
