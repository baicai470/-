package com.service;

import java.util.List;

import com.entity.ChoiceQuestion;
import com.entity.ExamScores;
import com.model.Choose;
import com.model.MarkingPaper;
import com.model.SelfTestESet;

public interface ExamScoresService {

	/**
	 * 保存试卷以及分数
	 * @param es
	 * @return
	 */
	public String saveExamScore(ExamScores es);
	/**
	 * 查询分数
	 * @param id 学生id
	 * @return 分数 如果为0则说明未批改完
	 */
	public int getScore(int id); 
	/**
	 * 
	 * @param CQs 自测的题目
	 * @param ch 自测的题号与答案
	 * @return
	 */
	public  SelfTestESet getErrorSet(List<ChoiceQuestion> CQs,Choose ch);
	/**
	 * 根据考试id查询所有答题卡
	 * @param paperId
	 * @return
	 */
	public List<ExamScores> getAllPaperByPaperId(String paperId);
	/**
	 * 根据ExamScores Id查看答题卡
	 * @param Id
	 * @return
	 */
	public ExamScores getExamScoresById(String Id);
	/**
	 * 根据ExamScores 返回用于批改试卷的model
	 * @param ex
	 * @return
	 */
	public MarkingPaper getMarkingPaperByExamScores(ExamScores ex);
}
