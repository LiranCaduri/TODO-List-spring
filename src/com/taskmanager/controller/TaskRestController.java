package com.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.entity.Task;
import com.taskmanager.entity.TaskErrorResponse;
import com.taskmanager.entity.TaskNotFoundException;
import com.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskRestController {

	@Autowired
	TaskService service;

	@RequestMapping("/tasks")
	public List<Task> getAllTasks () {

		List<Task> list = null ;

		try {
			list = service.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping("tasks/{taskid}")
	public Task getTask (@PathVariable int taskid) {
		Task task = null;
		try {
			task = service.get(taskid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new TaskNotFoundException("Task ID not found -"+ taskid);
		}
		return task;
	}

	@ExceptionHandler
	public ResponseEntity<TaskErrorResponse> handleNotFoundException (TaskNotFoundException exception){
		
		TaskErrorResponse error = new TaskErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<TaskErrorResponse> handleBadRequestException (Exception e){
		
		TaskErrorResponse error = new TaskErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
}
