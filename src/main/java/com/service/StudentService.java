package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.entity.Student;
import com.model.historyModel;

public interface StudentService {
	
	public Page<Student> pageStudent(Pageable pageable);
	
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
	/**
	 * 根据学生id返回所有答题卡
	 * @param id
	 * @return
	 */
	public List<historyModel> findByStudentId(String id);
}
