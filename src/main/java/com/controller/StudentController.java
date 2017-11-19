package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.ChoiceQuestion;

@Controller
public class StudentController {
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public String ChoiceQuestionPage(Model model,HttpServletRequest request, HttpServletResponse response){
		
		String pn=request.getParameter("pageNow");
		if (pn==null) {
			pn="1";
		}
		int pageNow=Integer.parseInt(pn);
		Pageable pageable=new PageRequest(pageNow-1, 1);
		
		Page<ChoiceQuestion> cqs=choiceQuestionDao.findAll(pageable);
		
		//得到页数pageCount
		int pc=cqs.getTotalPages();
		
		String pageCount=Integer.toString(pc);
		
		System.out.println("选择题pageCount======"+pageCount);
		
		
		model.addAttribute("choiceques",cqs);
		model.addAttribute("pageNow",pageNow);
		
		return "page";
	}

}
