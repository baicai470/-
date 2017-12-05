package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TeacherCourseDao;
import com.dao.TeacherDao;
import com.entity.Teacher;
import com.entity.TeacherCourse;
import com.service.TeacherService;

@Service("Teacher")
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	TeacherCourseDao tcDao;

	public String getPassword(String id) throws Exception {
		Teacher t=teacherDao.findByTeacherId(Integer.valueOf(id));
		if(t==null) return null;
		else return t.getPassword();
	}
	
	@Override
	public Teacher getTeacher(String id) {
		Teacher t=teacherDao.getOne(Integer.valueOf(id));
		return t;
	}


	@Override
	public List<String> getCourse(int id) {
		List<TeacherCourse> tcAll=tcDao.findAll();
		List<String> courses=new ArrayList<>();
		for (TeacherCourse t : tcAll) {
			if(id==t.getTeacher().getTeacherId()) courses.add(t.getId().getCourseId());
		}
		return courses;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherDao.findAll();
	}





}
