package com.mvc.myboard.delivery;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class deliveryDaoImpl implements deliveryDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<deliveryDto> list(String username) {
		// TODO Auto-generated method stub
		List<deliveryDto> list = new ArrayList<deliveryDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "list", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public deliveryDto find(String username) {
		deliveryDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "find", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	
	@Override
	public int count(String username) {
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "count", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public int total(String username) {
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "total", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}

	@Override
	public int insert(deliveryDto dto) {
		// TODO Auto-generated method stub
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
	public int update(deliveryDto dto) {
		// TODO Auto-generated method stub
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(String delno) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete", delno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public int cancel(String delno) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "cancel", delno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return res;
	}
	
}
