package com.mvc.myboard.address;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class addressDaoImpl implements addressDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<addressDto> selectList(String username) {
		// TODO Auto-generated method stub
		List<addressDto> list = new ArrayList<addressDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "list", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public addressDto main(String username) {
		addressDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "main", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
	@Override
	public addressDto find(int addrno) {
		addressDto adto = null;
		
		try {
			System.out.println("adto start ");
			adto = sqlSession.selectOne(NAMESPACE + "find", addrno);
			System.out.println("adto : " + adto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adto;
	}
	
	@Override
	public addressDto namefind(String addname) {
		addressDto adto = null;
		
		try {
			System.out.println("adto start ");
			adto = sqlSession.selectOne(NAMESPACE + "namefind", addname);
			System.out.println("adto : " + adto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adto;
	}

	@Override
	public int insert(addressDto dto) {
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
	public int mainupdate(addressDto dto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "mainupdate", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int delete(int addrno) {
		// TODO Auto-generated method stub
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "delete", addrno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int count(String username) {
		// TODO Auto-generated method stub
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "count", username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

}
