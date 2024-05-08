package com.HomeChallenge.ProjectManager.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HomeChallenge.ProjectManager.Model.projectModel;
import com.HomeChallenge.ProjectManager.Model.todoModel;

@Repository
public interface TodoRepository extends JpaRepository<todoModel,Long>{
	
//	public List<todoModel> findByproject(Optional<projectModel> project);
	public List<todoModel> findByproject(projectModel project);
	public todoModel findBytodoId(Long id);
	public List<todoModel> findBystatus(String status);

}
