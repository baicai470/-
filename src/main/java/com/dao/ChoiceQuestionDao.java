package com.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.ChoiceQuestion;

public interface ChoiceQuestionDao extends JpaRepository<ChoiceQuestion, Integer>,JpaSpecificationExecutor<ChoiceQuestion> {

	public List<ChoiceQuestion> findByCourseId(String CourseId);
	
	public Page<ChoiceQuestion> findByCourseId(String name,Pageable pageable);  
}
