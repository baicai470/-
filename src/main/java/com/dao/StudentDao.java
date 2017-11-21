package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer>,JpaSpecificationExecutor<Student>{

	Student findByStudentId(int id);
}
