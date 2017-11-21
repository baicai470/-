package com;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dao.TeacherDao;
import com.entity.Teacher;
import com.service.TeacherService;
   

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=OnlineTestApplication.class)
@WebAppConfiguration
public class TeacherTests {
	@Autowired
	private TeacherDao teacherDao;
	
	@Test
	public void teacheradd(){
		//add
		Teacher t=new Teacher();
		String identityCard="420103199708083333";
		t.setIdentityCard(identityCard);
		t.setName("刘老师");
		t.setPassword(identityCard.substring(identityCard.length()-6, identityCard.length()));
		t.setRole("teacher");
		teacherDao.save(t);
		
		
	}
	
	@Test
	public void teacherFindAll() {
		// findAll
		List<Teacher> TeacherAll = teacherDao.findAll();
		for (Teacher teacher : TeacherAll) {
			System.out.println(teacher.getTeacherId());
		}
	}
	
	@Test
	public void teacherFindOne() throws Exception{
		Teacher t=teacherDao.findByTeacherId(10000);
		System.out.println(t.getRole());
	}
	
	@Autowired
	TeacherService teacherService;
	
	@Test
	public void FindCourse(){
		int id=10002;
		List<String> courses=teacherService.getCourse(id);
		for(String course:courses){
			System.out.println(course);
		}
	}
}
