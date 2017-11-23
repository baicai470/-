package com.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.entity.Student;
import com.service.StudentService;


@Controller
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value="/student_button")
	public String student_button(){
		
		return "student/button";
	}
	
	@GetMapping(value="/student_top")
	public String student_top(){
		return "student/top";
	}
	
	@GetMapping(value="/student_footer")
	public String student_footer(){
		return "student/footer";
	}
	
	@GetMapping(value="/student_StudentInfo")
	public String student_StudentInfo(HttpServletRequest request){
		String id=(String) request.getParameter("id");
		Student s=studentService.getStudent(id);
		request.setAttribute("student", s);
		return "student/StudentInfo";
	}
	
	@GetMapping(value="/student_ChoosedCourse")
	public String student_ChoosedCourse(){
		return "student/ChoosedCourse";
	}
	
	@GetMapping(value="/student_SelfTest")
	public String student_SelfTest(){
		return "student/SelfTest";
	}
	
	@GetMapping(value="/student_demo_iframe")
	public String student_demo_iframe(){
		return "student/demo_iframe";
	}
	
	@GetMapping(value="/student_index5")
	public String student_index5(){
		return "student/index5";
	}
}






