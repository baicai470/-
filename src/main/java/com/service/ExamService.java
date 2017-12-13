package com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.entity.ChoiceQuestion;
import com.entity.ComprehensiveQuestion;
import com.entity.Exam;
import com.entity.ShortanswerQuestion;

public interface ExamService {
	/**
	 * 根据课程Id查询所有选择题
	 * @param CourseId
	 * @return 所有选择题
	 */
	public Page<ChoiceQuestion> CQs(String CourseId);
	/**
	 * 查询所有选择题
	 * @return
	 */
	public List<ChoiceQuestion> getAllCQs();
	/**
	 * 查询所有填空题
	 * @return
	 */
	public List<ShortanswerQuestion> getAllSQs();
	/**
	 * 查询所有综合题
	 * @return
	 */
	public List<ComprehensiveQuestion> getAllCphQs();
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
	public Exam createPaper(String CourseId,int CQnum,int SQnum,int CphQnum); 
	/**
	 * 保存试卷
	 * @param exam
	 */
	public void savePaper(Exam exam);
	/**
	 * 
	 * @param paperId
	 * @return 试卷
	 */
	public Exam getPaper(String paperId);
	/**
	 * 
	 * @return
	 */
	public List<Exam> getAllPaper();
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
