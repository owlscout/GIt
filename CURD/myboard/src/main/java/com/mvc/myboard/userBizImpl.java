package com.mvc.myboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userBizImpl implements userBiz {
	
	@Autowired
	private userDao dao;
	
	@Override
	public userDto login(userDto dto) {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

	@Override
	public int signup(userDto dto) {
		// TODO Auto-generated method stub
		return dao.signup(dto);
	}
	
	@Override
	public String idCheck(String userid) {
		
		return dao.idCheck(userid);
	}

}
