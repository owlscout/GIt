package com.ncs;

public class Member {
	
	private String userId;
	private String Password;
	private String userName;
	
	
	public Member() {
		
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return userName + " 님, 안녕하세요!";
	}

}
