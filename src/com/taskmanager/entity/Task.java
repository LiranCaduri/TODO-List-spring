package com.taskmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taskmanager")
@SuppressWarnings("serial")
public class Task implements Comparable<Task>,Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int taskId;
	
	@Column(name = "name")
	private String taskName;
	
	@Column(name = "description")
	private String taskDescribe;
	
	@Column(name = "priority")
	private int priority;
	
	public Task(int taskId, String taskName, String taskDescribe, int priority) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescribe = taskDescribe;
		this.priority = priority;
	}

	public Task(String taskName, String taskDescribe, int priority) {
		super();
		this.taskName = taskName;
		this.taskDescribe = taskDescribe;
		this.priority = priority;
	}

	public Task() {
		
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescribe() {
		return taskDescribe;
	}

	public void setTaskDescribe(String taskDescribe) {
		this.taskDescribe = taskDescribe;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + taskId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (taskId != other.taskId)
			return false;
		return true;
	}

	@Override
	public int compareTo(Task t) {
		return this.priority- t.priority;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDescribe=" + taskDescribe + ", priority=" + priority + "]";
	}
	
}
