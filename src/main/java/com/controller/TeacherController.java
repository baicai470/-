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

import com.entity.ChoiceQuestion;
import com.entity.ComprehensiveQuestion;
import com.entity.Exam;
import com.entity.ShortanswerQuestion;
import com.entity.Teacher;
import com.model.User;
import com.service.ExamService;
import com.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	ExamService examService;
	
	@GetMapping("/check_grade")
	public ModelAndView check_grade(){
		return new ModelAndView("teacher/check_grade");
	}
	@GetMapping("/getpage")
	public ModelAndView getpage(){
		return new ModelAndView("teacher/getpage");
	}
	@GetMapping("/test_library")
	public ModelAndView test_library(){
		return new ModelAndView("teacher/test_library");
	}
	@GetMapping("/teacher_info")
	public ModelAndView teacher_index2(HttpServletRequest request,Model model){	
		User user= (User) request.getSession().getAttribute("user");  
		Teacher teacher = teacherService.getTeacher(user.getAccount());
		model.addAttribute("teacher",teacher);
		return new ModelAndView("teacher/teacher_info","teacherModel",model);
	}
	@GetMapping("/teacher_index1")
	public ModelAndView teacher_index1(){
		return new ModelAndView("teacher/index1");
	}
	@GetMapping("/students_info_list")
	public ModelAndView students_info_list(){
		return new ModelAndView("teacher/students_info_list");
	}
 	@GetMapping("/course_info")
	public ModelAndView teacher_index3(){
		return new ModelAndView("teacher/course_info");
	}

	@GetMapping("/paperManage")
	public ModelAndView teacher_index5(HttpServletRequest request,Model model){
		List<Exam> exams=examService.getAllPaper();
		model.addAttribute("Exams", exams);
		return new ModelAndView("teacher/paperManage");
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
	@GetMapping("/paperCreate")
	public ModelAndView paperCreate(){
		return new ModelAndView("teacher/paperCreate");
	}
	@GetMapping("/paperMes")
	public ModelAndView paperMes(){
		
		return new ModelAndView("teacher/paperMes");
	}
	@PostMapping("/createExam")
	public ModelAndView createExam(HttpServletRequest request,Model model){
		int CQnum=Integer.valueOf(request.getParameter("CQnum"));
		int SQnum=Integer.valueOf(request.getParameter("SQnum"));
		int CphQnum=0;//Integer.valueOf(request.getParameter("CphQnum"));
		Exam ex=examService.createPaper("数据库", CQnum, SQnum, CphQnum);
		ex.setCQScore(Integer.parseInt(request.getParameter("CQscore")));
		ex.setSQScore(Integer.parseInt(request.getParameter("SQscore")));
		//ex.setCphQScore(Integer.parseInt(request.getParameter("CphQscore")));
		String ymd=request.getParameter("ymd");
		String BeginTime=request.getParameter("BeginTime");
		String EndTime=request.getParameter("EndTime");
		ex.setBeginTime(ymd+" "+BeginTime);
		ex.setEndTime(ymd+" "+EndTime);
		examService.savePaper(ex);
		List<Exam> exams=examService.getAllPaper();
		model.addAttribute("Exams", exams);
		return new ModelAndView("teacher/index5");
	}
	@PostMapping("/findPaper")
	public ModelAndView findPaper(HttpServletRequest request,Model model){	 
		String paper=request.getParameter("paper");
		Exam exam=examService.getPaper(paper);
		String CQSet=exam.getChoiceQuestionSet();
		String SQSet=exam.getShortanswerQuestionSet();
		String CphQSet=exam.getComprehensiveQuestionSet();
		List<ChoiceQuestion> cQuestions=new ArrayList<>();
		if(CQSet.length()!=0) cQuestions=examService.getListCQ(CQSet);
		List<ShortanswerQuestion> shortanswerQuestions=new ArrayList<>();
		if(SQSet.length()!=0) shortanswerQuestions=examService.getListSQ(SQSet);
		List<ComprehensiveQuestion> comprehensiveQuestions=new ArrayList<>();
		if(CphQSet.length()!=0) comprehensiveQuestions=examService.getListCphQ(CphQSet);
		model.addAttribute("CourseId", exam.getCourseId());
		model.addAttribute("CQs", cQuestions);
		model.addAttribute("SQs", shortanswerQuestions);
		model.addAttribute("CphQs", comprehensiveQuestions);
		return new ModelAndView("teacher/paper","paper", model);
	}
}
