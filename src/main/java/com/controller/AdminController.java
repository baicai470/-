package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@GetMapping("/admin_button")
	public ModelAndView button(){
		return new ModelAndView("admin/button");
	}

	@GetMapping("/admin_teacher")
	public ModelAndView teacher(){
		return new ModelAndView("admin/teacher_info_list");
	}
	
	@GetMapping("/admin_student")
	public ModelAndView student(){
		return new ModelAndView("admin/students_info_list");
	}
	
	@GetMapping("/admin_top")
	public ModelAndView top(){
		return new ModelAndView("admin/top");
	}
	
	@GetMapping("/admin_SearchCourse")
	public ModelAndView SearchCourse(){
		return new ModelAndView("admin/SearchCourse");
	}
	
	@GetMapping("/admin_footer")
	public ModelAndView footer(){
		return new ModelAndView("admin/footer");
	}
}
