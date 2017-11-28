package com;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.entity.ChoiceQuestion;
import com.service.ExamService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=OnlineTestApplication.class)
@WebAppConfiguration
public class ExamTests {
	@Autowired
	ExamService examService;
	
	@Test
	public void getTime(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		System.out.println(time+" "+time.length());
	}
	
	@Test
	public void CQtest(){
		List<ChoiceQuestion> choiceQuestions=examService.CQtest("数据库");
		System.out.println(choiceQuestions.size());
	}
	
	@Test
	public void page(){
		int pageNumber=1;
		int pageSize=1;
		String sord="desc";
		String sort="id";
		//生成Sort变量
		Sort sort1=new Sort(Direction.DESC,"id");
		Sort sort2=new Sort(Direction.fromString(sord),sort);
		//生成pageable变量
		Pageable pageable =new PageRequest(pageNumber-1, pageSize,sort2);	
	}
}
