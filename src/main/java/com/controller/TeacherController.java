package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Teacher;
import com.model.User;
import com.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/teacher_index2")
	public ModelAndView teacher_index2(HttpServletRequest request,Model model){
		
		User user= (User) request.getSession().getAttribute("user");  
		Teacher teacher = teacherService.getTeacher(user.getAccount());
		model.addAttribute("teacher",teacher);
		return new ModelAndView("teacher/index2","teacherModel",model);
	}
	@GetMapping("/teacher_index1")
	public ModelAndView teacher_index1(){
		return new ModelAndView("teacher/index1");
	}
	@GetMapping("/teacher_index3")
	public ModelAndView teacher_index3(){
		return new ModelAndView("teacher/index3");
	}
	@GetMapping("/teacher_index4")
	public ModelAndView teacher_index4(){
		return new ModelAndView("teacher/index4");
	}
	@GetMapping("/teacher_index5")
	public ModelAndView teacher_index5(){
		return new ModelAndView("teacher/index5");
	}
	@GetMapping("/teacher_top")
	public ModelAndView teacher_top(){
		return new ModelAndView("teacher/top");
	}
	@GetMapping("/teacher_button")
	public ModelAndView teacher_button(){
		return new ModelAndView("teacher/button");
	}
	@GetMapping("/teacher_footer")
	public ModelAndView teacher_footer(){
		return new ModelAndView("teacher/footer");
	}


}
