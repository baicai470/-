package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TeacherTests;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.TeacherTest;
import com.mysql.jdbc.log.Log;
import com.service.StudentService;
import com.service.TeacherService;

import groovy.util.logging.Log4j;

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
	public ModelAndView teacher(Model model){
		
		
//		List<TeacherTest> teacherTests = new ArrayList<>();	
//		teacherTests.add(new TeacherTest(11,"11hao","4545448756",2012,4125555));
//		teacherTests.add(new TeacherTest(12,"11hao","4525448756",2013,5125555));
//		teacherTests.add(new TeacherTest(13,"11hao","4525448756",2013,5125555));
		
		List<Teacher> teachers= teacherService.findAll();
		System.out.println(teachers.size());
		model.addAttribute("teachers", teachers);
		return new ModelAndView("admin/teacher_info_list","teacherModel",model);
	}
	
	@GetMapping("/admin_student")
	public ModelAndView student(Model model){
		
	  List<Student> students= studentService.findAll();
		
		model.addAttribute("students", students);
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
