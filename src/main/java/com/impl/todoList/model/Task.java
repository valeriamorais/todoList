package com.impl.todoList.model;



import javax.persistence.*;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity

public class Task{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String taskName;

	@OneToMany(cascade = CascadeType.ALL)
	private List<TaskItem> taskItems;

	public Task() {}

	public Task(Long id, String taskName) {
		this.id = id;
		this.taskName = taskName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public List <TaskItem> getTaskItems() {
		return taskItems;
	}

	public void setTaskItems(List <TaskItem> taskItems) {
		this.taskItems = taskItems;
	}
	
}
