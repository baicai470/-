package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExamScoreDao;
import com.entity.ChoiceQuestion;
import com.entity.ComprehensiveQuestion;
import com.entity.ExamScores;
import com.entity.ShortanswerQuestion;
import com.model.Choose;
import com.model.MarkingCphQ;
import com.model.MarkingPaper;
import com.model.MarkingSAQ;
import com.model.SelfTestESet;
import com.service.ExamScoresService;
import com.service.ExamService;

@Service("ExamScore")
public class ExamScoresServiceImpl implements ExamScoresService{
	
	@Autowired
	private ExamScoreDao examScoreDao;
	
	@Autowired
	ExamService examService;
	
	@Override
	public String saveExamScore(ExamScores es) {
		//TODO 批改试卷还没写
		List<ChoiceQuestion> choiceQuestions=examService.getListCQ(es.getExam().getChoiceQuestionSet());
		String CQScoresSet=new String();
		String[] CQlist =es.getChoiceQuestionAnswerset().split("/");
		double score=es.getExam().getCQScore()/choiceQuestions.size();
		for(int i=0;i<CQlist.length;i++){
			ChoiceQuestion cQuestion=choiceQuestions.get(i);
			if(CQlist[i].charAt(0)!=cQuestion.getAnswer()) {
				CQScoresSet+="0/";
			}else{
				CQScoresSet+=score+"/";
			}
		}
		es.setChoiceQuestionScore(CQScoresSet);
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

	@Override
	public List<ExamScores> getAllPaperByPaperId(String paperId) {
		
		return examScoreDao.findByExamPaperId(Integer.valueOf(paperId));
	}

	@Override
	public ExamScores getExamScoresById(String Id) {
		return examScoreDao.findOne(Integer.valueOf(Id));
	}

	@Override
	public MarkingPaper getMarkingPaperByExamScores(ExamScores ex) {
		List<ShortanswerQuestion> SAQs=examService.getListSQ(ex.getExam().getShortanswerQuestionSet());
		List<ComprehensiveQuestion> CphQs=examService.getListCphQ(ex.getExam().getComprehensiveQuestionSet());
		List<MarkingSAQ> MSAQs=new ArrayList<>();
		List<MarkingCphQ> MCphQs=new ArrayList<>();
		String[] SAQSet=ex.getShortanswerQuestionAnswerset().split("/");
		String[] CphQSet=ex.getComprehensiveQuestionAnswerset().split("/");
		if(SAQs!=null)for(int i=0;i<SAQs.size();i++){
			MarkingSAQ s=new MarkingSAQ();
			ShortanswerQuestion saq=SAQs.get(i);
			s.setID(i);
			s.setDesc(saq.getDescript());
			s.setStuAns(SAQSet[i]);
			s.setTrueAns(saq.getAnswer());
			MSAQs.add(s);
		}
		if(CphQs!=null)for(int i=0;i<CphQs.size();i++){
			MarkingCphQ c=new MarkingCphQ();
			ComprehensiveQuestion cphq=new ComprehensiveQuestion();
			c.setID(i);
			c.setDesc(cphq.getDescript());
			c.setStuAns(CphQSet[i]);
			c.setTrueAns(cphq.getAnswer());
			MCphQs.add(c);
		}
		MarkingPaper mp=new MarkingPaper();
		mp.setMarkingSAQs(MSAQs);
		mp.setMarkingCphQs(MCphQs);
		return mp;
	}
}
