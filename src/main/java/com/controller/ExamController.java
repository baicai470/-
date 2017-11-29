package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamController {

	@PostMapping("/exam")
	public ModelAndView exam(HttpServletRequest request,Model model){
		request.getParameter("paperId");
		return null;	
	}
}
