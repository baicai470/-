package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.ExamScores;


public interface ExamScoreDao extends JpaRepository<ExamScores, Integer>,JpaSpecificationExecutor<ExamScores> {

	ExamScores findByStudentStudentId(int id);

}
