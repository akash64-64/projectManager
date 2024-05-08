package com.HomeChallenge.ProjectManager.Model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="Todos")
public class todoModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long todoId;
	
	private String description;
	
	private String status;

	private String creationDate;
	
	private String updatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private projectModel project;

	public Long getTodoId() {
		return todoId;
	}

	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public projectModel getProject() {
		return project;
	}

	public void setProject(projectModel project) {
		this.project = project;
	}

	public todoModel() {
	}

	
}
