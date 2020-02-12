package com.impl.todoList.model;

import javax.persistence.*;

import lombok.Data;

import java.util.Set;

@Data
@Entity

public class TaskItem{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String taskItemName;

	@ManyToOne
	@JoinColumn(name = "taskId")
	private Task task;
	
	public TaskItem() {}

	public TaskItem(Long id, String taskItemName, Task task) {
		this.id = id;
		this.taskItemName = taskItemName;
		this.task = task;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskItemName() {
		return taskItemName;
	}

	public void setTaskItemName(String taskItemName) {
		this.taskItemName = taskItemName;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
