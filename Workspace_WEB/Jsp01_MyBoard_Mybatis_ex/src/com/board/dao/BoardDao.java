package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.db.sqlMapConfig;
import com.board.dto.BoardDto;

// DAO : Data Access Object : db 연결
public class BoardDao extends sqlMapConfig {
	
	// 전체 출력
	//	리턴 타입 : list의BoardDto이다	db에 전달할 값 : (){}  이부분 이다.
	public List<BoardDto> selectList(){
		SqlSession session = null;
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try { 
			session = getSqlSessionFactory().openSession(true); 
			//SqlSession 객체를 얻을 때 openSession(true)와 같이 호출하면 INSERT, UPDATE, DELETE문 실행 시 auto commit을 수행하는 SqlSession 객체를 얻을 수 있다.
			list = session.selectList("mapper.selectList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(list.size());
		return list;
	}
	
	// 하나 출력
	public BoardDto selectOne(int seq){
		SqlSession session = null;
		
		BoardDto dto = new BoardDto();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne("mapper.selectOne", seq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}
	
	// 추가   
	public int insert(BoardDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.insert("mapper.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	// 수정
	public int update(BoardDto dto) {
		int res = 0;
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.update("mapper.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	// 삭제
	public int delete(int seq) {
		int res = 0;
		try (SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.delete("mapper.delete", seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
