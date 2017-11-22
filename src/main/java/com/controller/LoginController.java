package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Student;
import com.entity.Teacher;
import com.model.User;
import com.nimbusds.oauth2.sdk.Request;
import com.service.StudentService;
import com.service.TeacherService;



@Controller
public class LoginController {
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String login1(User user) throws Exception{
		if(user.getIdentity().equals("Teacher") ){	
			if(user.getPassword().equals(teacherService.getPassword(user.getAccount()))){
				Teacher t=teacherService.getTeacher(user.getAccount());
				if(t.getRole().equals("admin")) {					
					return "manager/admin";//密码正确
				}
				else {
					return "teacher/在线考试1";
				}
			}else{
				
				//账号或者密码不正确
				return "redirect:/";
			}
		}else{
			if(user.getPassword().equals(studentService.getPassword(user.getAccount()))){
				Student s=studentService.getStudent(user.getAccount());
				return "redirect:/"+s.getStudentId();
			}else{
				return "redirect:/";
			}
			
		}
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login1(){		
		return "login";
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public String student(){
		
		return "student/在线考试1";
	}
}
