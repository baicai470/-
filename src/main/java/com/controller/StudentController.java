package com.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Student;
import com.model.User;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;




@RestController
public class StudentController {

	
	@Autowired
	StudentService studentService;

	@Autowired
	StudentServiceImpl studentserviceimpl;
	
	@GetMapping("/student_StudentInfo")
	public ModelAndView student_StudentInfo(HttpServletRequest request,Model model){
		//String id = request.getParameter("id");
		User user= (User) request.getSession().getAttribute("user");  
		Student student = studentserviceimpl.getStudent(user.getAccount());
		model.addAttribute("student", student);
		return new ModelAndView("student/StudentInfo","studentModel",model);
	}
	
	@GetMapping("/student_button")
	public ModelAndView student_button(){
		return new ModelAndView("student/button");
	}

	@GetMapping("/student_top")
	public ModelAndView student_top(){
		return new ModelAndView("student/top");
	}
	@GetMapping("/student_footer")
	public ModelAndView student_footer(){
		return new ModelAndView("student/footer");
	}
	@GetMapping("/student_ChoosedCourse")
	public ModelAndView student_ChoosedCourse(){
		return new ModelAndView("student/ChoosedCourse");
	}
	@GetMapping("/student_SelfTest")
	public ModelAndView student_SelfTest(){
		return new ModelAndView("student/SelfTest");
	}
	@GetMapping("/student_demo_iframe")
	public ModelAndView student_demo_iframe(){
		return new ModelAndView("student/demo_iframe");
	}
	@GetMapping("/student_index5")
	public ModelAndView student_index5(){
		return new ModelAndView("student/index5");
	}

}






