package com.HomeChallenge.ProjectManager.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HomeChallenge.ProjectManager.Model.projectModel;

@Repository
public interface ProjectRepository extends JpaRepository<projectModel,Long>{
	public List<projectModel> findByuserid(Long userid);
	
	public projectModel findByprojectId(Long projectId);
}
