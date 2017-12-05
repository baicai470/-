package com.entity;

public class TeacherTest {
	//{"tcID":"1","name":"一号","email":"一号邮箱号","id":"一号身份证","tel":"一号电话"},
	private int tcID;
	private String name;
	private String email;
	private int id;
	private long tel;
	public TeacherTest(int tcID, String name, String email, int id, long tel) {
		this.tcID = tcID;
		this.name = name;
		this.email = email;
		this.id = id;
		this.tel = tel;
	}
	public int getTcID() {
		return tcID;
	}
	public void setTcID(int tcID) {
		this.tcID = tcID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	
	
	
}
