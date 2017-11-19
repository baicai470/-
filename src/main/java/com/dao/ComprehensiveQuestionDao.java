package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.ComprehensiveQuestion;

public interface ComprehensiveQuestionDao extends JpaRepository<ComprehensiveQuestion, Integer>,JpaSpecificationExecutor<ComprehensiveQuestion>{

	public List<ComprehensiveQuestion> findByCourseId(String courseId);

}
