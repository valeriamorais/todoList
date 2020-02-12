package com.impl.todoList.controller;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.impl.todoList.model.Task;
import com.impl.todoList.model.TaskItem;
import com.impl.todoList.repository.TaskItemRepository;
import com.impl.todoList.repository.TaskRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
class TasksItemsController {
    private TaskItemRepository taskItemRepository;

    public TasksItemsController(TaskItemRepository taskItemRepository) {
        this.taskItemRepository = taskItemRepository;
    }

    @GetMapping("/tasksItems")
    Collection<TaskItem> tasksItem() {
        return (Collection<TaskItem>) taskItemRepository.findAll();
    }

    @PostMapping("/tasksItems")
    ResponseEntity<TaskItem> createTaskItem(@Valid @RequestBody TaskItem taskItem) throws URISyntaxException {
        TaskItem result = taskItemRepository.save(taskItem);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/tasksItems/{id}")
    public ResponseEntity < TaskItem > updateTaskItem(
            @PathVariable(value = "id") Long id,
            @Valid @RequestBody TaskItem taskItemDetail) throws ResourceNotFoundException {
        TaskItem taskItem = taskItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task Item not found : " + id));
        taskItem.setTaskItemName(taskItemDetail.getTaskItemName());
        taskItem.setTask(taskItemDetail.getTask());
        final TaskItem updatedTaskItem = taskItemRepository.save(taskItem);
        return ResponseEntity.ok(updatedTaskItem);
    }

    @DeleteMapping("/tasksItems/{id}")
    public Map< String, Boolean > deleteTaskItem(
            @PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        TaskItem taskItem = taskItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task Item not found : " + id));
        taskItemRepository.delete(taskItem);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}