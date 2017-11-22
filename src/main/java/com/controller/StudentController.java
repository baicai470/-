package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StudentController {

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
	public String student_StudentInfo(){
		
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






