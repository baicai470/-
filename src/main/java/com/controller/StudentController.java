package com.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entity.ChoiceQuestion;
import com.entity.Student;
import com.model.Choose;
import com.model.SelfTestESet;
import com.model.User;
import com.service.ExamScoresService;
import com.service.ExamService;
import com.service.StudentService;




@RestController
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ExamService examService;
	
	@Autowired
	ExamScoresService examScoresService;

	
	@GetMapping("/student_StudentInfo")
	public ModelAndView student_StudentInfo(HttpServletRequest request,Model model){
		//String id = request.getParameter("id");
		User user= (User) request.getSession().getAttribute("user");  
		Student student = studentService.getStudent(user.getAccount());
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
	public ModelAndView student_SelfTest(HttpServletRequest request,Model model){
		List<ChoiceQuestion> choiceQuestions=examService.CQtest("数据库");
		model.addAttribute("CQList", choiceQuestions);
		request.getSession(true).setAttribute("CQs", choiceQuestions);
		return new ModelAndView("student/SelfTest","CQs",model);
	}
	
	@PostMapping("/student_SelfTest")
	public ModelAndView student_SelfTest2(HttpServletRequest request,Choose choose,Model model ){
		@SuppressWarnings("unchecked")
		List<ChoiceQuestion> choiceQuestions=(List<ChoiceQuestion>) request.getSession(true).getAttribute("CQs");
		SelfTestESet errorSet=examScoresService.getErrorSet(choiceQuestions, choose);
		model.addAttribute("errorSet", errorSet);
		return new ModelAndView("/student/SelfTestScore","ESet",model);
	}
	
	@GetMapping("/student_demo_iframe")
	public ModelAndView student_demo_iframe(){
		return new ModelAndView("student/demo_iframe");
	}
	@GetMapping("/student_index5")
	public ModelAndView student_index5(HttpServletRequest request){
		return new ModelAndView("student/index5");
	}

}






