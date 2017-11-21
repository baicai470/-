package com.service;

public interface StudentService {
	
	//通过学生id验证登录密码
	public String getPassword(String id) throws Exception;

}
