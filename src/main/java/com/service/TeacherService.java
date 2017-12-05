package com.service;

import java.util.List;

import com.entity.Teacher;

public interface TeacherService {

	//通过教师id验证登录密码
	public String getPassword(String id) throws Exception;
	
	//通过教师id查找课程string集合
	public List<String> getCourse(int id);
	
	//通过教师id获得教师类
	public Teacher getTeacher(String id);
	
	//获得全部教师信息s's
	public List<Teacher> getAllTeachers();
}
