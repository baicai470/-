package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.Student;
import com.entity.Teacher;
import com.model.User;
import com.service.StudentService;
import com.service.TeacherService;



@Controller
public class LoginController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login1(User user,RedirectAttributes Ra,HttpServletRequest servletRequest) throws Exception{
		if(user.getIdentity().equals("Teacher") ){	
			if(user.getPassword().equals(teacherService.getPassword(user.getAccount()))){
				Teacher t=teacherService.getTeacher(user.getAccount());
				servletRequest.getSession(true).setAttribute("user", user); 
				//密码正确则判断身份，返回对应页面
				if(t.getRole().equals("admin")) {					
					return "manager/admin";
				}
				else {
					return "teacher/在线考试1";
				}
			}else{
				//账号或者密码不正确
				return "redirect:/login";
			}
		}else{
			if(user.getPassword().equals(studentService.getPassword(user.getAccount()))){
				Student s=studentService.getStudent(user.getAccount());
				Ra.addAttribute("id", s.getStudentId());			
				servletRequest.getSession(true).setAttribute("user", user); 
				return "redirect:/student";
			}else{
				return "redirect:/login";
			}
			
		}
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login2(){		
		return "login";
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login1(){		
		return "login";
	}
	
	@RequestMapping(value="/student",method=RequestMethod.GET)
	public String student(HttpServletRequest request){
		
		System.out.println(request.getParameter("id"));
		return "student/在线考试1";
	}
}
