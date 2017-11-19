package com.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.TeacherCourse;


public interface TeacherCourseDao extends JpaRepository<TeacherCourse, Integer>,JpaSpecificationExecutor<TeacherCourse>{
		
}
