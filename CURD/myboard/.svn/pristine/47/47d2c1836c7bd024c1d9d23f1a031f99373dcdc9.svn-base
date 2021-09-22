package com.mvc.myboard.cart;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.myboard.product.productDto;

@Repository
public class cartDaoImpl implements cartDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<cartDto> selectList(String username) {
		List<cartDto> list = new ArrayList<cartDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "list", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<productDto> list(int prono){
		List<productDto> list = new ArrayList<productDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "plist", prono);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert(cartDto dto) {
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
	public int mulinsert(cartDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "mulinsert", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(cartDto dto) {
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
	public int delete(int cartno) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete", cartno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public int count(cartDto dto) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "count", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public cartDto find(cartDto dto) {
		cartDto cdto = null;
		
		try {
			cdto = sqlSession.selectOne(NAMESPACE + "find", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cdto;
	}
	
}
