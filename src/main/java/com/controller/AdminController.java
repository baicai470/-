package com.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Student;
import com.entity.Teacher;
import com.service.StudentService;
import com.service.TeacherService;
import com.util.toJsonObject;

@Controller
public class AdminController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/admin_button")
	public ModelAndView button(){
		return new ModelAndView("admin/button");
	}

	@GetMapping("/admin_teacher")
	public ModelAndView teacher(Model model) throws IOException{
		List<Teacher> teachers= teacherService.findAll();
		
		model.addAttribute("teachers", toJsonObject.JsonObject(teachers));
		return new ModelAndView("admin/teacher_info_list","teacherModel",model);
	}
	
	@GetMapping("/admin_student")
	public ModelAndView student(Model model) throws IOException{
		
	  List<Student> students= studentService.findAll();
		
		model.addAttribute("students", toJsonObject.JsonObject(students));
		return new ModelAndView("admin/students_info_list","studentModel",model);
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
