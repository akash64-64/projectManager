package com.HomeChallenge.ProjectManager.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HomeChallenge.ProjectManager.Model.projectModel;
import com.HomeChallenge.ProjectManager.Model.todoModel;
import com.HomeChallenge.ProjectManager.Repository.ProjectRepository;
import com.HomeChallenge.ProjectManager.Repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repo;
	
	@Autowired
	private ProjectRepository prepo;
	
	public String addTodo(String description, String status,Long id) {
		todoModel todo = new todoModel();
		Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String createdate = formatter.format(date);
		projectModel project = prepo.findByprojectId(id);
		todo.setDescription(description);
		todo.setCreationDate(createdate);
		todo.setUpdatedDate(createdate);
		todo.setStatus(status);
		todo.setProject(project);
		repo.save(todo);
		return "todo saved";
		
	}
//	public String getTodoLists(Optional<projectModel> project) {
//		
//		repo.findByproject(project);
//		return "success";
//	}
	public List<todoModel> getTodoLists(projectModel project) {
		
		return repo.findByproject(project);
	}
	
	public String updateTodo(Long id,String description,String status) {
		
		todoModel updatedTodo = repo.findBytodoId(id);
		updatedTodo.setDescription(description);
		updatedTodo.setStatus(status);
		Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String updatedDate = formatter.format(date);
		updatedTodo.setUpdatedDate(updatedDate);
		repo.save(updatedTodo);
		return "updated";
		
	}
	public String deleteTodo(Long id) {
		
		repo.deleteById(id);
		return "deleted todo";
	}

	public List<todoModel> getProjectStatus(String status){
		
		return repo.findBystatus(status);
	}
}
