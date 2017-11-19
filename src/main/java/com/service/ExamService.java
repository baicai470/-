package com.service;

import java.util.List;

import com.entity.ChoiceQuestion;
import com.entity.Exam;

public interface ExamService {
	//通过课程ID来查找自我检测模块的20道选择题
	public List<ChoiceQuestion> CQtest(String CourseId);

	//通过课程ID来生成试卷
	public List<Exam> getPaper(String CourseId,int CQnum,int SQnum,int CphQnum); 
}
