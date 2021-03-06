package com.mvc.myboard;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class userDaoImpl implements userDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public userDto login(userDto dto) {
		userDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+ "login", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int signup(userDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "signup", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public String idCheck(String userid) {
		String res = null;
		try {
			res = sqlSession.selectOne(NAMESPACE + "idChk", userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}

}
