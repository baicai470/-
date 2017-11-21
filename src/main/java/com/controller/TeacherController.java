package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherController {
	
	@RequestMapping(value="/teacher_index1",method=RequestMethod.GET)
	public String teacher_index1(){
		
		return "teacher/index1";
	}

	@RequestMapping(value="/teacher_index2",method=RequestMethod.GET)
	public String teacher_index2(){
		
		return "teacher/index2";
	}
	
	@RequestMapping(value="/teacher_index3",method=RequestMethod.GET)
	public String teacher_index3(){
		
		return "teacher/index3";
	}
	
	@RequestMapping(value="/teacher_index4",method=RequestMethod.GET)
	public String teacher_index4(){
		
		return "teacher/index4";
	}
	
	@RequestMapping(value="/teacher_index5",method=RequestMethod.GET)
	public String teacher_index5(){
		
		return "teacher/index5";
	}
	
	@RequestMapping(value="/teacher_top",method=RequestMethod.GET)
	public String teacher_top(){
		
		return "teacher/top";
	}
	
	@RequestMapping(value="/teacher_button",method=RequestMethod.GET)
	public String teacher_button(){
		
		return "teacher/button";
	}
	
	@RequestMapping(value="/teacher_footer",method=RequestMethod.GET)
	public String teacher_footer(){
		
		return "teacher/footer";
	}
}
