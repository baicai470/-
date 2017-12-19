package com.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dao.ExamScoreDao;
import com.dao.StudentDao;
import com.entity.ExamScores;
import com.entity.Student;
import com.model.historyModel;
import com.service.StudentService;

@Service("Student")
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	ExamScoreDao examScoreDao;
	
	public String getPassword(String id) throws Exception {
		Student s=studentDao.findByStudentId(Integer.valueOf(id));
		if(s==null) return null;
		else return s.getPassword();
	}

	public Student getStudent(String id) {
		Student s=studentDao.getOne(Integer.valueOf(id));
		return s;
	}

	@Override
	public void saveStudent(Student student) {
		studentDao.save(student);
	}

	@Override
	public void deleteStudent(String id) {
		studentDao.delete(Integer.valueOf(id));
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Page<Student> pageStudent(Pageable pageable) {
		
		return studentDao.findAll(pageable);
	}

	@Override
	public List<historyModel> findByStudentId(String id) {
		List<historyModel> histories=new ArrayList<>();
		List<ExamScores> exs=examScoreDao.findByStudentStudentId(Integer.valueOf(id));
		for(int i=0;i<exs.size();i++){
			ExamScores ex=exs.get(i);
			historyModel history=new historyModel();
			history.setHisID(ex.getId()+"");
			if(ex.getMarked()!=null &&ex.getMarked()) history.setHasRead("已批阅");
			else history.setHasRead("未批阅");
			history.setScore(ex.getExam().getCQScore()+ex.getExam().getSQScore()+ex.getExam().getCphQScore());
			history.setAct_score(ex.getScore());
			history.setSubject(ex.getExam().getCourseId());
			histories.add(history);
		}
		return histories;
	}
}
