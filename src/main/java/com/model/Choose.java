package com.model;

public class Choose {
	
	private char[] list;
	private char choose0;
	private char choose1;
	private char choose2;
	private char choose3;
	private char choose4;
	private char choose5;
	private char choose6;
	private char choose7;
	private char choose8;
	private char choose9;
	public char[] getList() {
		list=new char[10];
		list[0]=getChoose0();
		list[1]=getChoose1();
		list[2]=getChoose2();
		list[3]=getChoose3();
		list[4]=getChoose4();
		list[5]=getChoose5();
		list[6]=getChoose6();
		list[7]=getChoose7();
		list[8]=getChoose8();
		list[9]=getChoose9();
		return list;
	}
	public void setList(char[] list) {
		this.list = list;
	}
	public char getChoose0() {
		return choose0;
	}
	public void setChoose0(char choose0) {
		this.choose0 = choose0;
	}
	public char getChoose1() {
		return choose1;
	}
	public void setChoose1(char choose1) {
		this.choose1 = choose1;
	}
	public char getChoose2() {
		return choose2;
	}
	public void setChoose2(char choose2) {
		this.choose2 = choose2;
	}
	public char getChoose3() {
		return choose3;
	}
	public void setChoose3(char choose3) {
		this.choose3 = choose3;
	}
	public char getChoose4() {
		return choose4;
	}
	public void setChoose4(char choose4) {
		this.choose4 = choose4;
	}
	public char getChoose5() {
		return choose5;
	}
	public void setChoose5(char choose5) {
		this.choose5 = choose5;
	}
	public char getChoose6() {
		return choose6;
	}
	public void setChoose6(char choose6) {
		this.choose6 = choose6;
	}
	public char getChoose7() {
		return choose7;
	}
	public void setChoose7(char choose7) {
		this.choose7 = choose7;
	}
	public char getChoose8() {
		return choose8;
	}
	public void setChoose8(char choose8) {
		this.choose8 = choose8;
	}
	public char getChoose9() {
		return choose9;
	}
	public void setChoose9(char choose9) {
		this.choose9 = choose9;
	}
	
	
}
