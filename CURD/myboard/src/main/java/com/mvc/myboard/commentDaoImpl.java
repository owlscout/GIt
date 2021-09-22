package com.mvc.myboard;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class commentDaoImpl implements commentDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<commentDto> commentList(int myno) {
		List<commentDto> list = new ArrayList<commentDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "commentList", myno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insert(commentDto cdto) {
		// TODO Auto-generated method stub
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "insert", cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int update(commentDto cdto) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "update", cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(commentDto cdto) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete", cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int answerUpdate(int parentcommentNo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.update(NAMESPACE + "answerUpdate", parentcommentNo);
		
		return res;
	}

	@Override
	public int answerInsert(commentDto cdto) {
		// TODO Auto-generated method stub
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "answerInsert", cdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
