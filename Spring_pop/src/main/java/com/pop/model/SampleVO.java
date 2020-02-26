package com.pop.model;

public class SampleVO {
	// 주의사항 : 변수명의 맨앞은 소문자.(spring이 읽을 수 있도록.)
	private String firstname;
	private String lastname;
	private int mno;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	
}
