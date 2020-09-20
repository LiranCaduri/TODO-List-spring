package com.taskmanager.dal;

import java.util.List;

import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.taskmanager.entity.Task;
@Component
public class TaskDBDao implements TaskDao{

	public  SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Task.class)
								.buildSessionFactory();

	

	
	@Override
	public List<Task> getAll() throws Exception {
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		List<Task> tasks = session.createQuery("from Task").getResultList();
		session.getTransaction().commit();
		session.close();
		
		return tasks;
	}

	@Override
	public int save(Task task) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(task);
		System.out.println("Saving Task...");
		session.getTransaction().commit();
		System.out.println("done.");
		session.close();
		return 0;
	}

	@Override
	public int saveAll(List<Task> task) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.save(task);
		
		session.getTransaction().commit();
		session.close();
		return 0;
	}

	@Override
	public int update(Task task) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.update(task);;
		
		session.getTransaction().commit();
		session.close();
		return 0;
		
	}

	@Override
	public int delete(int id) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Task task = (Task) session.createQuery("from Task where id ="+id).getSingleResult();
		
		session.delete(task);
		
		session.getTransaction().commit();
		session.close();
		return 0;
	}

	@Override
	public Task get(long id) throws Exception {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Task task = (Task) session.createQuery("from Task where id ="+id).getSingleResult();
		
		session.getTransaction().commit();
		
		session.close();
		return task;
	}
	
	@PreDestroy
	public void doAtTheEnd() {
		factory.close();
	}
	
}
