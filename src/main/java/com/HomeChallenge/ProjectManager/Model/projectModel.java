package com.HomeChallenge.ProjectManager.Model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="ProjectList")
public class projectModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projectId;
	
	private  String projectTitle;
	
	private String createdDate;
	
//	@Column(unique=true)
	
	@OneToMany(mappedBy="project")
	private List<todoModel> todoList;
	
	private Long userid;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<todoModel> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<todoModel> todoList) {
		this.todoList = todoList;
	}
	


	public projectModel() {
	}

	
	
	
}
