package com.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;




@RestController
public class StudentController {

	@Autowired
	StudentServiceImpl studentserviceimpl;
	
	@GetMapping("/student_StudentInfo")
	public ModelAndView student_StudentInfo(HttpServletRequest request,Model model){
		String id = request.getParameter("id");
		//System.out.println(id);
		Student student = studentserviceimpl.getStudent(id);
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
//	@GetMapping(value="/student_button")
//	public String student_button(){
//		return "student/button";
//	}
//	
//	@GetMapping(value="/student_top")
//	public String student_top(){
//		return "student/top";
//	}
//	
//	@GetMapping(value="/student_footer")
//	public String student_footer(){
//		return "student/footer";
//	}
//	
//	@GetMapping(value="/student_StudentInfo")
//	public String student_StudentInfo(){
//		
//		return "student/StudentInfo";
//	}
//	
//	@GetMapping(value="/student_ChoosedCourse")
//	public String student_ChoosedCourse(){
//		return "student/ChoosedCourse";
//	}
//	
//	@GetMapping(value="/student_SelfTest")
//	public String student_SelfTest(){
//		return "student/SelfTest";
//	}
//	
//	@GetMapping(value="/student_demo_iframe")
//	public String student_demo_iframe(){
//		return "student/demo_iframe";
//	}
//	
//	@GetMapping(value="/student_index5")
//	public String student_index5(){
//		return "student/index5";
//	}
}






