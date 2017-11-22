package com.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.entity.Student;
import com.service.StudentService;

@Service("Student")
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	
	public String getPassword(String id) throws Exception {
		Student s=studentDao.findByStudentId(Integer.valueOf(id));
		if(s==null) return null;
		else return s.getPassword();
	}

	public Student getStudent(String id) {
		Student s=studentDao.getOne(Integer.valueOf(id));
		return s;
	}
	
	
	
	

}
