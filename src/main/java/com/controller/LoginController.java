package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String login1(User user){
		if(user.getIdentity().equals("Teacher") ){
			if(user.getPassword().equals(teacherService.getPassword(user.getAccount()))){
				if(teacherService.getTeacher(user.getAccount()).getRole().equals("admin")) 
					return "admin";//密码正确
				else return "teacher";
			}else{
				//账号或者密码不正确
				return "login";
			}
		}else{
			if(user.getPassword().equals(studentService.getPassword(user.getAccount()))){
				return "student";
			}else{
				return "login";
			}
			
		}
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login1(){		
		return "login";
	}

}
