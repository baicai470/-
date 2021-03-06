package com.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dao.StudentDao;
import com.entity.ChoiceQuestion;
import com.entity.ExamScores;
import com.entity.Student;
import com.entity.Teacher;
import com.model.Choose;
import com.model.SelfTestESet;
import com.model.User;
import com.model.historyModel;
import com.service.ExamScoresService;
import com.service.ExamService;
import com.service.StudentService;
import com.util.toJsonObject;




@RestController
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ExamService examService;
	
	@Autowired
	ExamScoresService examScoresService;

	
	@GetMapping("/student_StudentInfo")
	public ModelAndView student_StudentInfo(HttpServletRequest request,Model model) throws IOException{
		//String id = request.getParameter("id");
		User user= (User) request.getSession().getAttribute("user");  
		Student student = studentService.getStudent(user.getAccount());
    	model.addAttribute("student", toJsonObject.JsonObject(student));
		return new ModelAndView("student/StudentInfo","studentModel",model);
	}
	@PostMapping("/savestudent")
	public ModelAndView savestudent(HttpServletRequest request,Model model) throws IOException{
		User user= (User) request.getSession().getAttribute("user");  
		Student student = studentService.getStudent(user.getAccount());
		String email=request.getParameter("email");
		String identity=request.getParameter("identity");
		String phone=request.getParameter("phone");
		String name=request.getParameter("name");
		student.setIdentityCard(identity);
		student.setMailbox(email);
		student.setName(name);
		student.setPhone(phone);
		studentService.saveStudent(student);
    	model.addAttribute("student", toJsonObject.JsonObject(student));
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
	@GetMapping("/history")
	public ModelAndView history(HttpServletRequest request,Model model){
		String studentId=request.getSession().getAttribute("studentId")+"";
		List<historyModel> histories=studentService.findByStudentId(studentId);
		model.addAttribute("histories", histories);
		return new ModelAndView("student/history");
		
	}
	@PostMapping("/selectpaper")
	public ModelAndView selectpaper(){
		
		return new ModelAndView("student/paper");
		
	}
}






