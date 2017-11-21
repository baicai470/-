package com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.entity.ChoiceQuestion;
import com.entity.Exam;

public interface ExamService {
	/**
	 * 分页
	 * @param CourseId
	 * @return 所有选择题
	 */
	public Page<ChoiceQuestion> CQs(String CourseId);
	
	/**
	 * 
	 * @param CourseId
	 * @return 自我检测十道题目
	 */
	public List<ChoiceQuestion> CQtest(String CourseId);
	/**
	 * 
	 * @param CourseId
	 * @param CQnum
	 * @param SQnum
	 * @param CphQnum
	 * @return 通过课程ID返回指定数目的各种题目
	 */
	public List<Exam> getPaper(String CourseId,int CQnum,int SQnum,int CphQnum); 
}
