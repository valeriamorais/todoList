package com.impl.todoList.controller;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.impl.todoList.model.Task;
import com.impl.todoList.repository.TaskRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
class TasksController {
    private TaskRepository taskRepository;

    public TasksController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    Collection<Task> tasks() {
        return (Collection<Task>) taskRepository.findAll();
    }

    @PostMapping("/tasks")
    ResponseEntity<Task> createTask(@Valid @RequestBody Task task) throws URISyntaxException {
        Task result = taskRepository.save(task);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity < Task > updateTask(
            @PathVariable(value = "id") Long id,
            @Valid @RequestBody Task taskDetail) throws ResourceNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found : " + id));
        task.setTaskName(taskDetail.getTaskName());
        final Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public Map< String, Boolean > deleteTask(
            @PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found : " + id));
        taskRepository.delete(task);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}