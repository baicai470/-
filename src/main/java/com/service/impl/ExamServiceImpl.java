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
import com.dao.ExamDao;
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
	
	@Autowired	
	private ComprehensiveQuestionDao comprehensiveQuestionDao;
	
	@Autowired
	private ShortanswerQuestionDao shortanswerQuestionDao;
	
	@Autowired
	private ExamDao examDao;

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
	public Exam createPaper(String CourseId, int CQnum, int SQnum, int CphQnum) {
		Exam exam=new Exam();
		exam.setCourseId(CourseId);
		String cQString=new String();
		String sQString=new String();
		String CphQString=new String();
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
				ChoiceQuestion CQtemp=choiceQuestions.get(temp);
				cQString+=CQtemp.getId()+"/";
				CQ.add(CQtemp);
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
				ShortanswerQuestion SQtemp=shortanswerQuestions.get(temp);
				sQString+=SQtemp.getId()+"/";
				SAQ.add(SQtemp);
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
				ComprehensiveQuestion CphQtemp=comprehensiveQuestions.get(temp);
				CphQString+=CphQtemp.getId()+"/";
				CphQ.add(CphQtemp);
			}else {
			i--;
			}
		}	
		exam.setChoiceQuestionSet(cQString);
		exam.setShortanswerQuestionSet(sQString);
		exam.setComprehensiveQuestionSet(CphQString);
		return exam;
	}

	@Override
	public Page<ChoiceQuestion> CQs(String CourseId) {
		Pageable pageable=new PageRequest(0, 1);
		Page<ChoiceQuestion > pages=choiceQuestionDao.findByCourseId(CourseId, pageable);
		return pages;
	}

	@Override
	public List<ChoiceQuestion> getListCQ(String CQString) {
		List<ChoiceQuestion> choiceQuestions=new ArrayList<>();
		String[] temp=CQString.split("/");
		for(int i=0;i<temp.length;i++){
			ChoiceQuestion cq=choiceQuestionDao.getOne(Integer.valueOf(temp[i]));
			choiceQuestions.add(cq);
		}
		return choiceQuestions;
	}

	@Override
	public List<ShortanswerQuestion> getListSQ(String SQString) {
		List<ShortanswerQuestion> shortanswerQuestions=new ArrayList<>();
		String[] temp=SQString.split("/");
		for(int i=0;i<temp.length;i++){
			ShortanswerQuestion sq=shortanswerQuestionDao.getOne(Integer.valueOf(temp[i]));
			shortanswerQuestions.add(sq);
		}
		return shortanswerQuestions;
	}

	@Override
	public List<ComprehensiveQuestion> getListCphQ(String CphQString) {
		List<ComprehensiveQuestion> comprehensiveQuestions=new ArrayList<>();
		String[] temp=CphQString.split("/");
		for(int i=0;i<temp.length;i++){
			ComprehensiveQuestion CphQ=comprehensiveQuestionDao.getOne(Integer.valueOf(temp[i]));
			comprehensiveQuestions.add(CphQ);
		}
		return comprehensiveQuestions;
	}

	@Override
	public void savePaper(Exam exam) {
		examDao.save(exam);
	}


	@Override
	public Exam getPaper(String paperId) {	
		return examDao.findOne(Integer.parseInt(paperId));
	}

	@Override
	public List<Exam> getAllPaper() {
		List<Exam> exams=examDao.findAll();
		return exams;
	}


}
