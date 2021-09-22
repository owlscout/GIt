package com.mvc.myboard.order;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class orderDaoImpl implements orderDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<orderDto> selectList(String delno) {
		// TODO Auto-generated method stub
		List<orderDto> list = new ArrayList<orderDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "list", delno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public orderDto select(String ordno) {
		// TODO Auto-generated method stub
		orderDto dto = null;

		try {
			dto = sqlSession.selectOne(NAMESPACE + "select", ordno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public int insert(orderDto dto) {
		// TODO Auto-generated method stub
		int res = 0;

		res = sqlSession.insert(NAMESPACE + "insert", dto);

		return res;
	}

	@Override
	public int update(orderDto dto) {
		// TODO Auto-generated method stub
		int res = 0;

		res = sqlSession.insert(NAMESPACE + "update", dto);

		return res;
	}

	@Override
	public int delete(String ordno) {
		// TODO Auto-generated method stub
		
		int res = 0;
		
		res = sqlSession.insert(NAMESPACE + "delete", ordno);
		
		return res;
		
	}

}
