package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.ShortanswerQuestion;

public interface ShortanswerQuestionDao extends JpaRepository<ShortanswerQuestion, Integer>,JpaSpecificationExecutor<ShortanswerQuestion>{

	List<ShortanswerQuestion> findByCourseId(String courseId);

}
