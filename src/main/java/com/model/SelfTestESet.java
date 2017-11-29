package com.model;

import java.util.List;

import com.entity.ChoiceQuestion;

public class SelfTestESet {
	private List<ChoiceQuestion> errorCQuestions;
	
	private int Scores;

	public List<ChoiceQuestion> getErrorCQuestions() {
		return errorCQuestions;
	}
	public void setErrorCQuestions(List<ChoiceQuestion> errorCQuestions) {
		this.errorCQuestions = errorCQuestions;
	}
	public int getScores() {
		return Scores;
	}
	public void setScores(int scores) {
		Scores = scores;
	}

}
