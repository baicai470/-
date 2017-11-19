package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer>,JpaSpecificationExecutor<Teacher>{
		
	Teacher findByTeacherId(int id);
	
}
