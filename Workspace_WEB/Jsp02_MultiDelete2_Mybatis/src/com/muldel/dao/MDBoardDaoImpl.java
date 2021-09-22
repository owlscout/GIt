package com.muldel.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.muldel.db.SqlMapConfig;
import com.muldel.dto.MDBoardDto;

public class MDBoardDaoImpl extends SqlMapConfig implements MDBoardDao {
	// 구분자가 있어야해서 마지막에 . 을 넣었다.
	private String namespace = "com.muldel.mapper.";
	
	@Override
	public List<MDBoardDto> selectlist() {
		
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		int offset = 0;
		int limit = 2;
		SqlSession session = null;
		try {
			// 오토 커밋, 기본값은 true
			session = getSqlSessionFactory().openSession(false);
			//list = session.selectList(namespace+"selectList");
			RowBounds row = new RowBounds(offset , limit); 
			list = session.selectList(namespace+"selectList", null, row);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		
		return null;
	}

	@Override
	public int insert(MDBoardDto dto) {
		
		return 0;
	}

	@Override
	public int update(MDBoardDto dto) {
		
		return 0;
	}

	@Override
	public int delete(int seq) {
		
		return 0;
	}

	@Override
	public int multiDelete(String[] seqs) {
		int count = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);
		
		try (SqlSession session = getSqlSessionFactory().openSession(false);){
			count = session.delete(namespace+"multiDelete", map);
			if (count == seqs.length) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mapper에서 
		// item을 abc로 적는다면
		// #{abc}로 적어줘야한다
		// 그리고 seqs의 숫자만큼 ,가 반복되는것이다.
		
		
		return count;
	}

}
