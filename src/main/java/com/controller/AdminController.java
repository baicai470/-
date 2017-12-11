package com.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Student;
import com.entity.Teacher;
import com.service.StudentService;
import com.service.TeacherService;
import com.util.toJsonObject;


@Controller
public class AdminController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/admin_button")
	public ModelAndView button(){
		return new ModelAndView("admin/button");
	}

	@GetMapping("/admin_teacher")
	public ModelAndView teacher(@RequestParam(value="page",defaultValue="1") int page,
			                                                   @RequestParam(value="size",defaultValue="3") int size,
			                                                   Model model) throws IOException{
		PageRequest  request=new PageRequest(page-1, size);
		Page<Teacher> pageteacher =teacherService.pageTeacher(request);
		List<Teacher> pagelist = pageteacher.getContent();
		model.addAttribute("pages", toJsonObject.JsonObject(pagelist) );
		model.addAttribute("pageNumber",pageteacher.getTotalPages() );
		model.addAttribute("currentPage", page);
		System.out.println(pageteacher.getTotalPages());
		
		List<Teacher> teachers= teacherService.findAll();
	
		model.addAttribute("teachers", teachers);

		
		model.addAttribute("teachers", toJsonObject.JsonObject(teachers));

		return new ModelAndView("admin/teacher_info_list","teacherModel",model);
	}
	
	@GetMapping("/admin_student")
	public ModelAndView student(@RequestParam(value="page",defaultValue="1") int page,
                                                              @RequestParam(value="size",defaultValue="3") int size,    
                                                               Model model) throws IOException{
		PageRequest  request=new PageRequest(page-1, size);
		Page<Student> pagestudent =studentService.pageStudent(request);
		List<Student> pagelist = pagestudent.getContent();
		model.addAttribute("pages",toJsonObject.JsonObject(pagelist) );
		model.addAttribute("pageNumber",pagestudent.getTotalPages() );
		model.addAttribute("currentPage", page);
	  List<Student> students= studentService.findAll();
		
		model.addAttribute("students", toJsonObject.JsonObject(students));
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
