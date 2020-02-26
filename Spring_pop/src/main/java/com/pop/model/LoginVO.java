package com.pop.model;

public class LoginVO {
	private String uid;			// id
	private String upw;			// password
	private boolean useCookie;	// cookie 사용여부
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginVO [uid=" + uid + ", upw=" + upw + ", useCookie=" + useCookie + "]";
	}
	
}
