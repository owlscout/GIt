package com.mvc.myboard;

public interface userDao {
	
	String NAMESPACE = "user.";
	
	public userDto login(userDto dto);
	public int signup(userDto dto);
	public String idCheck(String userid);
	
}
