package com.taskmanager.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.taskmanager.entity.Task;
import com.taskmanager.service.TaskService;

@Controller
public class TaskController {
	// Model - to connect UI

	@Autowired
	TaskService service; 

	//main page

	@RequestMapping("/")
	public String DefaultPage(Model model)
	{
		return showTable(model);
	}

	@RequestMapping("/main")
	public String showTable (Model model) {

		List<Task> list;

		try {
			list = (List<Task>) service.getAll();
			Collections.sort(list);//sort
			model.addAttribute("tasks",list);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("exeption",e);
			return "ErorrScreen";
		}
		return "TaskManager_mainPage";
	}

	//show
	@RequestMapping("/show")
	public String showTask(HttpServletRequest request,Model model) 
	{
		List<Task> list;
		//return string from server to controller 
		String choose=request.getParameter("button");
		int i;
		boolean flag=false;

		try
		{
			list=(List<Task>) service.getAll();

			//find the task
			for(i=0; i<list.size() && !flag; i++)
			{	
				if(list.get(i).getTaskName().equals(choose) )
				{
					flag=true;
					model.addAttribute("task",list.get(i) );
				}
			}

			if (choose.equals(null)) 
			{
				System.out.println("please select a task");
				model.addAttribute("exeption","please select a task");
				return "ErorrScreen"; 
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("exeption","please select a task");
			return "ErorrScreen"; 
		}
		return "TaskManager_show";
	}
	// Add 
	@RequestMapping("/add")
	public String addTask () {

		return "taskManeger_addPage";
	}

	@RequestMapping("/cancel")
	public String addCancel(Model model) 
	{
		return DefaultPage(model);
	}

	@RequestMapping("/addSubmit")
	public String submitAddTask (HttpServletRequest request,Model model) {
		
		String name,description,priority;
		int numPriority = 0;
		Task task;
		try {
			name=request.getParameter("name");
			description=request.getParameter("description");
			priority=request.getParameter("priority");

			switch (priority) {

			case "Very High":
				numPriority=1;
				break;
			case "High":
				numPriority=2;
				break;
			case "Medium":
				numPriority=3;
				break;
			case "Low":
				numPriority=4;
				break;
			case "Very Low":
				numPriority=5;
				break;

			}// end of switch

			task = new Task(name,description,numPriority);

			int x = service.save(task);	
			switch (x) {
			case 1:
				System.out.println("Cannot save more then 100 tasks");
				model.addAttribute("exeption","Cannot save more then 100 tasks");
				return "ErorrScreen";
			case 2: 
				System.out.println("Cannot add new task with priority " + task.getPriority());
				model.addAttribute("exeption","Cannot add new task with priority " + task.getPriority());
				return "ErorrScreen";
			default:
				return  showTable(model);
			}
		}
		// end of try
		catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("exeption",e);
			return "ErorrScreen";
		}// end of catch
	}

	//Edit
	@RequestMapping("/edit")
	public String editTask(HttpServletRequest request,Model model)
	{
		List<Task> list;
		String choose=request.getParameter("button");
		int i;
		boolean flag=false;

		try
		{
			list=(List<Task>) service.getAll();

			//find the task
			for(i=0;i<list.size() && !flag;i++)
			{
				if(list.get(i).getTaskName().equals(choose) )
				{
					flag=true;
				}
			}

			model.addAttribute("taskId",list.get(i-1).getTaskId() );
			model.addAttribute("taskName",list.get(i-1).getTaskName());
			model.addAttribute("taskDescription",list.get(i-1).getTaskDescribe());

			//check which priority chose and send to table
			switch (list.get(i-1).getPriority()) {
			case 1:
				model.addAttribute("priority","Very High");
				break;
			case 2: 
				model.addAttribute("priority","High");
				break;
			case 3:
				model.addAttribute("priority","Medium");
				break;
			case 4:
				model.addAttribute("priority","Low");
				break;
			case 5:
				model.addAttribute("priority","Very Low");
				break;

			}//end of switch
		}// end of try
		catch (Exception e) {
			e.printStackTrace();

		}
		return "TaskManager_edit";
	}

	@RequestMapping("/afterEditTask")
	public String afterEditTask(HttpServletRequest request,Model model)
	{
		String name,description,priority;
		int numPriority=0;
		int id;
		Task task;

		try {
			name=request.getParameter("name");
			description=request.getParameter("description");
			id=Integer.parseInt(request.getParameter("id"));
			priority=request.getParameter("priority");

			switch (priority) {

			case "Very High":
				numPriority=1;
				break;
			case "High":
				numPriority=2;
				break;
			case "Medium":
				numPriority=3;
				break;
			case "Low":
				numPriority=4;
				break;
			case "Very Low":
				numPriority=5;
				break;
			}
			task=new Task(id,name,description,numPriority);
			int x = service.update(task);
		
			switch (x) {
			case 1:
				System.out.println("Cannot save more then 100 tasks");
				model.addAttribute("exeption","Cannot save more then 100 tasks");
				return "ErorrScreen";
			case 2:
				System.out.println("Cannot add new task with priority " + task.getPriority());
				model.addAttribute("exeption","Cannot add new task with priority " + task.getPriority());
				return "ErorrScreen";
			default:
				break;
			}

			return  showTable(model);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("exeption",e);
			return "ErorrScreen";
		}
	}

	//Delete
	@RequestMapping("/delete")
	public String deletePage(HttpServletRequest request,Model model)
	{
		ArrayList<Task> list;
		String choose=request.getParameter("button");
		int i;
		boolean flag=false;

		try
		{
			list=(ArrayList<Task>) service.getAll();
			//find the task
			for(i=0;i<list.size() && !flag;i++)
			{
				if(list.get(i).getTaskName().equals(choose) )
				{
					flag=true;
					model.addAttribute("Task",list.get(i));
				}
			}
			service.delete(list.get(i-1).getTaskId());
			list = (ArrayList<Task>) service.getAll();
			model.addAttribute("tasks", list);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			model.addAttribute("exeption","Could not delete      "+e);
			return "ErorrScreen";
		}
		return  showTable(model);
	}

	@RequestMapping("/erorr")
	public String erorrPage (Model model) {

		return "ErorrScreen";
	}

}

