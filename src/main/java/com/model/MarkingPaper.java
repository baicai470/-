package com.model;

import java.util.List;

public class MarkingPaper {
	List<MarkingSAQ> markingSAQs;
	List<MarkingCphQ> markingCphQs;
	public List<MarkingSAQ> getMarkingSAQs() {
		return markingSAQs;
	}
	public void setMarkingSAQs(List<MarkingSAQ> markingSAQs) {
		this.markingSAQs = markingSAQs;
	}
	public List<MarkingCphQ> getMarkingCphQs() {
		return markingCphQs;
	}
	public void setMarkingCphQs(List<MarkingCphQ> markingCphQs) {
		this.markingCphQs = markingCphQs;
	}
	
}
