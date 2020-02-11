package com.impl.todoList.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity

public class TaskItem{
	private @Id @GeneratedValue Long id;
	private String taskItemName;
	private Long taskId; 
	
	public TaskItem() {}

	public TaskItem(Long id, String taskItemName, Long taskId) {
		this.id = id;
		this.taskItemName = taskItemName;
		this.taskId = taskId;
	}
	
	
}
