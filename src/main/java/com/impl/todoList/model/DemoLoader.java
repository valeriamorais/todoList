package com.impl.todoList.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoLoader implements CommandLineRunner {

    private final TaskRepository repository;

    @Autowired
    public DemoLoader(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Task(1L, "Task Demo 01"));
    }
}
