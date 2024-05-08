package com.HomeChallenge.ProjectManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HomeChallenge.ProjectManager.Model.userModel;

@Repository
public interface userRepository extends JpaRepository<userModel,Long>{
public userModel findByUsername(String name);
}
