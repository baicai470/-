package com.service;

import com.entity.Student;

public interface StudentService {
	
	//通过学生id验证登录密码
	public String getPassword(String id) throws Exception;

	//通过教师id获得教师类
	public Student getStudent(String id);
}
