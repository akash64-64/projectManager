package com.HomeChallenge.ProjectManager.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class userModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	private String username;
	
	private String password;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public userModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public userModel() {
	}
	
	

}
