package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.ChoiceQuestion;
import com.entity.ComprehensiveQuestion;
import com.entity.Exam;
import com.entity.ShortanswerQuestion;
import com.service.ExamService;

@Controller
public class ExamController {
	@Autowired
	ExamService examService;

	@PostMapping("/exam")
	public ModelAndView exam(HttpServletRequest request,Model model){
		String paperId=request.getParameter("paperId");
		Exam exam=examService.getPaper(paperId);
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
		return new ModelAndView("student/exam","paper",model);	
	}
}
