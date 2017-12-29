package com.oosdclass.taskTrackerApp2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oosdclass.taskTrackerApp2.dao.TaskDAO;
import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	//create default properties
	public static final String DEFAULT_STATUS = "OPEN";
	public static final String DEFAULT_ASSIGNED = "UNASSIGNED";
	
	//create updated object using employee input
	public static final String UPDATED_STATUS = "input here";
	public static final String UPDATED_ASSIGNED = "input here";
	
	//Dependency Injection & Inversion Of Control
	@Autowired
	TaskDAO taskdao;
	
	@Override
	public List<Task> getAllTask() {
		return taskdao.retrieveAllTasks();
	}
	//take the task created by admin - description only - 
	//and add the default properties for status and assignedTo
	@Override
	public void saveTask(Task task) {
		task.setStatus(DEFAULT_STATUS);
		task.setAssignedTo(DEFAULT_ASSIGNED);
		taskdao.saveTask(task);
	}
	//update the status and assignedTo from the employee
	@Override
	public void updateTask(Task task) {
		task.setStatus(UPDATED_STATUS);
		task.setAssignedTo(UPDATED_ASSIGNED);
		taskdao.updateTask(task);
	}
	@Override
	public Task getByTaskId(int taskId) {
		return taskdao.retrieveByTaskID(taskId);
	}
}