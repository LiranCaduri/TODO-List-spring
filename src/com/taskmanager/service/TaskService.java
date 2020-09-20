package com.taskmanager.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskmanager.dal.TaskDao;
import com.taskmanager.entity.Task;

@Component
public class TaskService {
	
	@Autowired
	private TaskDao dao ;

	public List<Task> getAll() throws Exception {
		return dao.getAll();
	}
	
	public int save(Task task) throws Exception {
		List<Task> tasks = getAll();
		int count = 0;
		if (tasks.size() == 100)
			return 1; // full 
		for(int i = 0; i < tasks.size() && count < 20; i++) {
			if (tasks.get(i).getPriority() == task.getPriority())
				count++;
		}
		if (count == 20)
			return 2;// more than 20
		
		return dao.save(task);
	}
	
	public int update (Task task) throws Exception {
		List<Task> tasks = getAll();
		int count = 0;
		if (tasks.size() == 100)
			return 1; // full 
		for(int i = 0; i < tasks.size() && count < 20; i++) {
			if (tasks.get(i).getPriority() == task.getPriority())
				count++;
		}
		if (count == 20)
			return 2;// more than 20
		return dao.update(task);
	
	}
	
	public int delete (int id) throws Exception {
		return dao.delete(id);
	}
	
	public Task get (long id) throws Exception {
		return dao.get(id);
	}
	
	@PostConstruct 
	public void ShowAll() 
	{
		try {
			List<Task> list = getAll();
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i));
			}
		
		} catch (Exception e) {
			e.printStackTrace();		}
	}
	
	@PreDestroy
	public void ShowAllInTheEnd() 
	{
		try {
			List<Task> list = getAll();
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i));
			}
		
		} catch (Exception e) {
			System.out.println("Exception");
		}
		
	}
	
} 
