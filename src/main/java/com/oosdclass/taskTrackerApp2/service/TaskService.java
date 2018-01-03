package  com.oosdclass.taskTrackerApp2.service;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {
	
	
	public List<Task> getAllTask();

	void saveTask(Task task);

	public Task getTaskById(int taskId);

	public void updateTaskAssignedTo(int taskID, String username);

	void updateTaskStatus(int taskID, String status, String username);

	void deleteTask(int taskID);
}