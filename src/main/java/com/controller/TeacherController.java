package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherController {
	
	@RequestMapping(value="/index1",method=RequestMethod.GET)
	public String index1(){
		
		return "teacher/index1";
	}

	@RequestMapping(value="/index2",method=RequestMethod.GET)
	public String index2(){
		
		return "teacher/index2";
	}
	
	@RequestMapping(value="/index3",method=RequestMethod.GET)
	public String index3(){
		
		return "teacher/index3";
	}
	
	@RequestMapping(value="/index4",method=RequestMethod.GET)
	public String index4(){
		
		return "teacher/index4";
	}
	
	@RequestMapping(value="/index5",method=RequestMethod.GET)
	public String index5(){
		
		return "teacher/index5";
	}
	
	@RequestMapping(value="/top",method=RequestMethod.GET)
	public String top(){
		
		return "teacher/top";
	}
	
	@RequestMapping(value="/button",method=RequestMethod.GET)
	public String button(){
		
		return "teacher/button";
	}
	
	@RequestMapping(value="/footer",method=RequestMethod.GET)
	public String footer(){
		
		return "teacher/footer";
	}
	
}
