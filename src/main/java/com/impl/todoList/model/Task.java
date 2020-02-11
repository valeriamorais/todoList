package com.impl.todoList.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Task{
	private @Id @GeneratedValue Long id;
	private String taskName;
	
	public Task() {}

	public Task(Long id, String taskName) {
		this.id = id;
		this.taskName = taskName;
	}
	
	
	
}
