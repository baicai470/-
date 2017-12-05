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
import com.entity.Teacher;
import com.entity.TeacherTest;
import com.service.TeacherService;

@Controller
public class AdminController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/admin_button")
	public ModelAndView button(){
		return new ModelAndView("admin/button");
	}

	@GetMapping("/admin_teacher")
	public ModelAndView teacher(Model model){
		
		List<TeacherTest> teacherTests = new ArrayList<>();	
		teacherTests.add(new TeacherTest(11,"11hao","4545448756",2012,4125555));
		teacherTests.add(new TeacherTest(12,"11hao","4525448756",2013,5125555));
		teacherTests.add(new TeacherTest(13,"11hao","4525448756",2013,5125555));
		
		
		model.addAttribute("teacherTest", teacherTests);
		return new ModelAndView("admin/teacher_info_list","teacherModel",model);
	}
//	@PostMapping("/findTeacher")
//	public ModelAndView findTeacher(HttpServletRequest request,Model model){
//		//return  teacherService.getTeacher(request.getParameter("TeacherId"));
//		List<TeacherTest> teacherTests = new ArrayList<>();	
//		TeacherTest teacherTest=new TeacherTest(11,"11hao","4545448756",2012,4125555);
//		teacherTests.add(teacherTest);
//		model.addAttribute("teacherfind", teacherTests);
//		System.out.println(teacherService.getTeacher(request.getParameter("TeacherId")));
//		return new ModelAndView("admin/teacher_info_list","teacherModel1",model);
//	}

	
	@GetMapping("/admin_student")
	public ModelAndView student(Model model){
		
		List<TeacherTest> teacherTests = new ArrayList<>();	
		teacherTests.add(new TeacherTest(11,"11hao","4545448756",2012,4125555));
		teacherTests.add(new TeacherTest(12,"11hao","4525448756",2013,5125555));
		teacherTests.add(new TeacherTest(13,"11hao","4525448756",2013,5125555));
		
		
		model.addAttribute("studentTest", teacherTests);
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
