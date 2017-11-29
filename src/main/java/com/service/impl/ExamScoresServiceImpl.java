package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExamScoreDao;
import com.entity.ChoiceQuestion;
import com.entity.ExamScores;
import com.model.Choose;
import com.model.SelfTestESet;
import com.service.ExamScoresService;

@Service("ExamScore")
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

	@Override
	public SelfTestESet getErrorSet(List<ChoiceQuestion> CQs, Choose ch) {
		SelfTestESet selfTestESet=new SelfTestESet();
		List<ChoiceQuestion> errorSet=new ArrayList<>();
		int Score=100;
		char[] CQlist=ch.getList();
		for(int i=0;i<10;i++){
			ChoiceQuestion cQuestion=CQs.get(i);
			if(CQlist[i]!=cQuestion.getAnswer()) {
				errorSet.add(cQuestion);
				Score=Score-10;
			}
		}
		selfTestESet.setErrorCQuestions(errorSet);
		selfTestESet.setScores(Score);
		return selfTestESet;
	}
}
