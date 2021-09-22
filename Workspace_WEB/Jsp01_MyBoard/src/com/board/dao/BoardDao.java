package com.board.dao;

import static com.board.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;

// DAO : Data Access Object : db 연결
public class BoardDao {
	
	// 전체 출력
	//	리턴 타입 : list의BoardDto이다	db에 전달할 값 : (){}  이부분 이다.
	public List<BoardDto> selectList(){
		Connection con = getConnection();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				+ " FROM MYBOARD "
				+ " ORDER BY SEQ DESC ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// 리턴타입인 list의 객체를 만들어서 리턴받을 곳을 만든다.
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			// 쿼리 준비
			pstm = con.prepareStatement(sql);
			
			// 쿼리 실행 및 리턴
			rs = pstm.executeQuery();
		
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setMyseq(rs.getInt(1));
				dto.setMywriter(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// db종료
			close(rs);
			close(pstm);
			close(con);
			
		}
		return list;
	}
	
	// 하나 출력
	// 하나만 가지고와서 출력하는거이기때문에 BoardDto로 사용하는것이다.
	// 파라미터에 그걸 식별할 식별키(조건)을 넣어야한다 그것이 프라이머리 키인 int myseq로 번호를 가져오는것이다.
	public BoardDto selectOne(int myseq){
		Connection con = getConnection();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				+ " FROM MYBOARD "
				+ " WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		BoardDto dto= new BoardDto();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myseq);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setMyseq(rs.getInt(1));
				dto.setMywriter(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));
			}
			
			/*	try catch 밖에 BoardDto dto = null을 만들어주고 이렇게 쓰는거다.
			 * while (rs.next()){
			 * 	dto = new BoardDto(rs.getInt("SEQ"),
			 * 						rs.getString("WRITER"),
			 * 						rs.getString("TITLE"),
			 * 						rs.getString("CONTENT"),
			 * 						rs.getString("REGDATE"));
			 * }
			 */
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		
		return dto;
	}
	
	// 추가   
	// dao에서 dto로 db보내고 
	// dao < -- > db
	//		int로 돌려받는다 그래서 리턴타입은 int로 해야 하는것이다.
	// sql에서 ? ? ? 를 사용할꺼기때문에 dto를 파라미터로 가져와서 해야한다
	public int insert(BoardDto dto) {
		Connection con = getConnection();
		
		String sql = " INSERT INTO MYBOARD "
				+ 	" VALUES(MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMywriter());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			
			res = pstm.executeUpdate();
			if(res> 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	// 수정
	public int update(BoardDto dto) {
		Connection con = getConnection();
		
		String sql = " UPDATE MYBOARD "
				+ 	" SET TITLE=?, CONTENT=? "
				+ 	" WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyseq());
			
			res = pstm.executeUpdate();
			
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	// 삭제
	public int delete(int myseq) {
		Connection con = getConnection();
		
		String sql = " DELETE FROM MYBOARD "
				+ 	" WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myseq);
			
			res = pstm.executeUpdate();
			
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
}
