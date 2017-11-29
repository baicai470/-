package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView teacher_index5(HttpServletRequest request,Model model){
		List<Exam> exams=examService.getAllPaper();
		model.addAttribute("Exams", exams);
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
	@PostMapping("/createExam")
	public ModelAndView createExam(HttpServletRequest request,Model model){
		int CQnum=Integer.valueOf(request.getParameter("CQnum"));
		int SQnum=Integer.valueOf(request.getParameter("SQnum"));
		int CphQnum=Integer.valueOf(request.getParameter("CphQnum"));
		Exam ex=examService.createPaper("数据库", CQnum, SQnum, CphQnum);
		ex.setBeginTime(getTime());
		examService.savePaper(ex);
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
	private String getTime() {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
		
	}

}
