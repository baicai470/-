package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ExamScoreDao;
import com.entity.ExamScores;
import com.service.ExamScoresService;

public class ExamScoresServiceImpl implements ExamScoresService{
	
	@Autowired
	private ExamScoreDao examScoreDao;
	
	@Override
	public String saveExamScore(ExamScores es) {
		//TODO 批改试卷还没写
		examScoreDao.save(es);
		return "保存成功";
	}

	@Override
	public int getScore(int id) {
		ExamScores eScores=examScoreDao.findByStudentStudentId(id);
		if(eScores.getMarked()) return eScores.getScore();
		else return 0;
	}
}
