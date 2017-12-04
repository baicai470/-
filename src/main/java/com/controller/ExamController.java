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
import com.entity.ExamScores;
import com.entity.ShortanswerQuestion;
import com.service.ExamScoresService;
import com.service.ExamService;
import com.service.StudentService;

@Controller
public class ExamController {
	@Autowired
	ExamService examService;
	
	@Autowired
	ExamScoresService examScoresService;
	
	@Autowired
	StudentService studentService;

	@PostMapping("/exam")
	public ModelAndView exam(HttpServletRequest request,Model model){
		String paperId=request.getParameter("paperId");
		request.getSession().setAttribute("paperId", paperId);
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
		request.getSession().setAttribute("CourseId", exam.getCourseId());
		model.addAttribute("CQs", cQuestions);
		request.getSession().setAttribute("CQList", cQuestions);
		model.addAttribute("SQs", shortanswerQuestions);
		request.getSession().setAttribute("SQList", shortanswerQuestions);
		model.addAttribute("CphQs", comprehensiveQuestions);
		request.getSession().setAttribute("CphQList", comprehensiveQuestions);
		return new ModelAndView("student/exam","paper",model);	
	}
	@SuppressWarnings("unchecked")
	@PostMapping("/examAnswer")
	public ModelAndView examAnswer(HttpServletRequest request,Model model){
		List<ChoiceQuestion> choiceQuestions=(List<ChoiceQuestion>) request.getSession().getAttribute("CQList");
		List<ShortanswerQuestion> shortanswerQuestions=(List<ShortanswerQuestion>) request.getSession().getAttribute("SQList");
		List<ComprehensiveQuestion> comprehensiveQuestions=(List<ComprehensiveQuestion>) request.getSession().getAttribute("CphQList");
		String cQStrings=new String();
		String sQStrings=new String();
		String cphQStrings=new String();
		if(choiceQuestions!=null)for(int i=0;i<choiceQuestions.size();i++){
			cQStrings+=request.getParameter("choose"+i)+"/";
		}
		if(shortanswerQuestions!=null)for(int i=0;i<shortanswerQuestions.size();i++){
			sQStrings+=request.getParameter("SQanswer"+i)+"/";
		}
		if(comprehensiveQuestions!=null)for(int i=0;i<comprehensiveQuestions.size();i++){
			cphQStrings+=request.getParameter("CphQanswer"+i)+"/";
		}
		ExamScores ex=new ExamScores();
		String paperId=(String) request.getSession().getAttribute("paperId");
		ex.setExam(examService.getPaper(paperId));
		Integer studentId=(Integer) request.getSession().getAttribute("studentId");
		ex.setStudent(studentService.getStudent(studentId+""));
		ex.setChoiceQuestionAnswerset(cQStrings);
		ex.setShortanswerQuestionAnswerset(sQStrings);
		ex.setComprehensiveQuestionAnswerset(cphQStrings);
		examScoresService.saveExamScore(ex);
		return new ModelAndView("student/finsh");
	}
}
