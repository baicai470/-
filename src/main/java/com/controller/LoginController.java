package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.User;
import com.service.StudentService;
import com.service.TeacherService;



@Controller
public class LoginController {
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	
	//@ApiOperation(nickname = "login", value = "登录", notes = "测试swagger")  
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String login1(User user){
		if(user.getIdentity().equals("Teacher") ){
			if(user.getPassword().equals(teacherService.getPassword(user.getAccount()))){
				if(teacherService.getTeacher(user.getAccount()).getRole().equals("admin")) 
					return "manager/admin";//密码正确
				else return "teacher/在线考试1";
			}else{
				//账号或者密码不正确
				return "login";
			}
		}else{
			if(user.getPassword().equals(studentService.getPassword(user.getAccount()))){
				return "student/在线考试1";
			}else{
				return "login";
			}
			
		}
	}
   // @ApiOperation(nickname = "swagger-objectio", value = "Swagger的ObjectIO", notes = "测试对象输入输出")  
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login1(){		
		return "login";
	}

}
