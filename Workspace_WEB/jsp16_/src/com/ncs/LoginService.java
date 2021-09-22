package com.ncs;

public class LoginService {
	
	LoginDAO dao;
	
	public LoginService() {
		dao = new LoginDAO();
	}
	
	public Member selectOneMember(String userId, String password) {
		return dao.selectOneMember(userId, password);
	}
	
}
