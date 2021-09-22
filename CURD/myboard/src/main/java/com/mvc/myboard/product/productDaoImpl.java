package com.mvc.myboard.product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.myboard.pagingDto;

@Repository
public class productDaoImpl implements productDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<productDto> selectList() {
		List<productDto> list = new ArrayList<productDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public productDto selectOne(int prono) {
		productDto dto = null;

		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", prono);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public int insert(productDto dto) {
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
	public int update(productDto dto) {
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
	public int delete(int prono) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "delete", prono);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int listCnt() {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "insert");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int mulupdate(productDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "mulupdate", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public List<String> katelist(String prokate_1){
		List<String> list = new ArrayList<String>();
		System.out.println("다오"+ prokate_1);
		try {
			list = sqlSession.selectList(NAMESPACE + "katelist", prokate_1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<productDto> kateall(String prokate_1){
		List<productDto> list = new ArrayList<productDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "kateall", prokate_1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<productDto> kateselect(productDto dto){
		List<productDto> list = new ArrayList<productDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "kateselect", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
