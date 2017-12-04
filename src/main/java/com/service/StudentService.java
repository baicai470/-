package com.service;

import java.util.List;

import com.entity.Student;

public interface StudentService {
	
	//通过学生id验证登录密码
	public String getPassword(String id) throws Exception;

	/**
	 * select student info by id
	 * @param id
	 * @return
	 */
	public Student getStudent(String id);
	/**
	 * insert & update学生
	 * @param student insert时不需要id,update时需要id
	 */
	public void saveStudent(Student student);
	/**
	 * 根据学生id来删除学生
	 * @param id
	 */
	public void deleteStudent(String id);
	/**
	 * 获得全部学生
	 * @return
	 */
	public List<Student> findAll();
}
