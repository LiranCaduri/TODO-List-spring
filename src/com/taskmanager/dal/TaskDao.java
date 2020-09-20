package com.taskmanager.dal;

import java.util.List;

import com.taskmanager.entity.Task;

public interface TaskDao {

	public List<Task> getAll() throws Exception;
	public int save(Task task) throws Exception;
	public int saveAll(List<Task> task) throws Exception;
	public int update(Task task) throws Exception;
	public int delete(int id) throws Exception;
	public Task get(long id) throws Exception;
}
