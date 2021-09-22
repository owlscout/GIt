package com.mvc.myboard.ordhistory;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ordhisDaoImpl implements ordhisDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ordhisDto> alllist(String username) {
		List<ordhisDto> list = new ArrayList<ordhisDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "alllist", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ordhisDto> list(String delno) {
		List<ordhisDto> list = new ArrayList<ordhisDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "list", delno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(ordhisDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public int update(ordhisDto dto) {
		
		int res = 0;
		
		res = sqlSession.update(NAMESPACE + "update", dto);
		
		return res;
	}
	
}
