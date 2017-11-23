package com.service;

import com.entity.ExamScores;

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
}
