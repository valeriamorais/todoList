package com.impl.todoList.model;

import java.net.URISyntaxException;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ResponseEntity<Task> createContact(@Valid @RequestBody Task task) throws URISyntaxException {
        Task result = taskRepository.save(task);
        return ResponseEntity.ok().body(result);
    }
}