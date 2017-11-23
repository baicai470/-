package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.Exam;

public interface ExamDao extends JpaRepository<Exam, Integer>,JpaSpecificationExecutor<Exam> {

}
