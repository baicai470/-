package com.entity;
// Generated 2017-10-11 16:06:00 by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StudentCourse generated by hbm2java
 */
@Entity
@Table(name = "STUDENT_COURSE", schema = "dbo", catalog = "EXAM")
public class StudentCourse implements java.io.Serializable {

	
	private StudentCourseId id;
	private Student student;
	
	@Column(name = "studentID")
	private Integer score;
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public StudentCourse() {
	}

	public StudentCourse(StudentCourseId id, Student student) {
		this.id = id;
		this.student = student;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "courseId", column = @Column(name = "courseID", nullable = false, length = 20)),
			@AttributeOverride(name = "studentId", column = @Column(name = "studentID", nullable = false)) })
	public StudentCourseId getId() {
		return this.id;
	}

	public void setId(StudentCourseId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studentID", nullable = false, insertable = false, updatable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
