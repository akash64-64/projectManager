package com.HomeChallenge.ProjectManager.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HomeChallenge.ProjectManager.Model.projectModel;
import com.HomeChallenge.ProjectManager.Model.todoModel;
import com.HomeChallenge.ProjectManager.Model.userModel;
import com.HomeChallenge.ProjectManager.Repository.ProjectRepository;
import com.HomeChallenge.ProjectManager.Repository.TodoRepository;
import com.HomeChallenge.ProjectManager.Repository.userRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ProjectManagerService {
	
	@Autowired
	private ProjectRepository Prepo;
	
//	@Autowired
//	private TodoRepository Trepo;
	
	@Autowired
	private userRepository Urepo;
	
	public String createProject(projectModel project,String title,userModel user) {
		Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String createdate = formatter.format(date);
		project.setCreatedDate(createdate);
		project.setProjectTitle(title);
		project.setUserid(user.getUserId());
		
		Prepo.save(project);
		return "Project Created";
	}
	
	public String signinUser(userModel user) {
	
		Urepo.save(user);
		return"user saved";
	}
	
	public List<projectModel> getAllProject() {
		return Prepo.findAll();
	}
	
	
	public List<projectModel> getProjectofUser(Long userid){
		
		return Prepo.findByuserid(userid);
	}
	public projectModel getProject(Long Pid) {
		
		return Prepo.findById(Pid).get();
	}
	
//	public String addTodos(todoModel todo) {
//		
//		Trepo.save(todo);
//		return"Todo saved";
//	}
	
//	public String updateTodos(todoModel todo) {
//		Trepo.save(todo);
//		return"todo Updated";
//	}
//	
	public projectModel updateTitle(String title,Long id) {
		projectModel existProject = Prepo.findByprojectId(id);
			existProject.setProjectTitle(title);
			return Prepo.save(existProject);
		
	}

}
