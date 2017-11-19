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
	
	public String getPassword(String id) {
		Student s=studentDao.getOne(Integer.valueOf(id));
		
		return s.getPassword();
	}
	
	

}
