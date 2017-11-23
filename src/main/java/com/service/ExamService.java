package com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.entity.ChoiceQuestion;
import com.entity.ComprehensiveQuestion;
import com.entity.Exam;
import com.entity.ShortanswerQuestion;

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
	public Exam getPaper(String CourseId,int CQnum,int SQnum,int CphQnum); 
	/**
	 * 保存试卷
	 * @param exam
	 */
	public void savePaper(Exam exam);
	/**
	 * 分割字符串查找题目
	 * @param CQString Exam中的选择题集合
	 * @return 试卷选择题集合
	 */
	public List<ChoiceQuestion> getListCQ(String CQString);
	/**
	 * 分割字符串查找题目
	 * @param SQString Exam中的填空题集合
	 * @return 试卷填空题集合
	 */
	public List<ShortanswerQuestion> getListSQ(String SQString);
	/**
	 * 分割字符串查找题目
	 * @param CphQString Exam的综合题集合
	 * @return 综合题集合
	 */
	public List<ComprehensiveQuestion> getListCphQ(String CphQString);
	
}
