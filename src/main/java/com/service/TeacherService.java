
package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.entity.Student;
import com.entity.Teacher;

public interface TeacherService {

	/*
	 * 
	 */
	public Page<Teacher> pageTeacher(Pageable pageable);
	
	//通过教师id验证登录密码
	public String getPassword(String id) throws Exception;
	
	//通过教师id查找课程string集合
	public List<String> getCourse(int id);
	
	/**
	 * select teacher by id
	 * @param id
	 * @return
	 */
	public Teacher getTeacher(String id);
	/**
	 * insert & update 教师表
	 * @param teacher insert时不需要id ,update时需要id
	 */
	public void saveTeacher(Teacher teacher);
	/**
	 * 根据教师id 删除教师
	 * @param id
	 */
	public void deleteTeacher(String id);
	/**
	 * 获得全部教师
	 * @return
	 */
	public List<Teacher> findAll();
}

