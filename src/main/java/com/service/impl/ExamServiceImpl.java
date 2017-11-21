package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dao.ChoiceQuestionDao;
import com.dao.ComprehensiveQuestionDao;
import com.dao.ShortanswerQuestionDao;
import com.entity.ChoiceQuestion;
import com.entity.ComprehensiveQuestion;
import com.entity.Exam;
import com.entity.ShortanswerQuestion;
import com.service.ExamService;

@Service("Exam")
public class ExamServiceImpl implements ExamService{

	@Autowired
	private ChoiceQuestionDao choiceQuestionDao;
	
	@Autowired	private ComprehensiveQuestionDao comprehensiveQuestionDao;
	
	@Autowired
	private ShortanswerQuestionDao shortanswerQuestionDao;
	
	@Override
	public List<ChoiceQuestion> CQtest(String CourseId) {
		//取出所有
		List<ChoiceQuestion> choiceQuestions=choiceQuestionDao.findByCourseId(CourseId);
		//目标集合
		List<ChoiceQuestion> selectCQ=new ArrayList<>();
		//为了防止重复的集合
		List<Integer> tempList=new ArrayList<>();
		int count=choiceQuestions.size();
		int temp=0;
		Random random=new Random();
		for(int i=0;i<10;i++){
			temp=random.nextInt(count);
			if(!tempList.contains(temp)){
				tempList.add(temp);
				selectCQ.add(choiceQuestions.get(temp));
			}else {
				i--;
			}
		}		
		return selectCQ;
	}

	@Override
	public List<Exam> getPaper(String CourseId, int CQnum, int SQnum, int CphQnum) {
		//获取
		List<ChoiceQuestion> choiceQuestions=choiceQuestionDao.findByCourseId(CourseId);
		List<ComprehensiveQuestion> comprehensiveQuestions=comprehensiveQuestionDao.findByCourseId(CourseId);
		List<ShortanswerQuestion> shortanswerQuestions=shortanswerQuestionDao.findByCourseId(CourseId);
		//
		List<ChoiceQuestion> CQ=new ArrayList<>();
		List<ComprehensiveQuestion> CphQ=new ArrayList<>();
		List<ShortanswerQuestion> SAQ=new ArrayList<>();
		List<Integer> tempList=new ArrayList<>();
		//选择题随机抽取
		int count=choiceQuestions.size();
		int temp=0;
		Random random=new Random();
		for(int i=0;i<CQnum;i++){
			temp=random.nextInt(count);
			if(!tempList.contains(temp)){
				tempList.add(temp);
				CQ.add(choiceQuestions.get(temp));
			}else {
				i--;
			}
		}		
		//填空题随机抽取
		count=shortanswerQuestions.size();
		temp=0;
		for(int i=0;i<SQnum;i++){
			temp=random.nextInt(count);
			if(!tempList.contains(temp)){
				tempList.add(temp);
				SAQ.add(shortanswerQuestions.get(temp));
			}else {
				i--;
			}
		}	
		//综合题随机抽取
		count=comprehensiveQuestions.size();
		temp=0;
		for(int i=0;i<CphQnum;i++){
			temp=random.nextInt(count);
			if(!tempList.contains(temp)){
				tempList.add(temp);
				CphQ.add(comprehensiveQuestions.get(temp));
			}else {
				i--;
			}
		}	
		return null;
	}

	@Override
	public Page<ChoiceQuestion> CQs(String CourseId) {
		Pageable pageable=new PageRequest(0, 1);
		Page<ChoiceQuestion > pages=choiceQuestionDao.findByCourseId(CourseId, pageable);
		return pages;
	}
}
