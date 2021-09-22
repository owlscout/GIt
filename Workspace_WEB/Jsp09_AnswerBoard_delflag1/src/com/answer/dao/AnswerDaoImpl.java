package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.answer.db.JDBCTemplate.*;

import com.answer.dto.AnswerDto;

public class AnswerDaoImpl implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. 쿼리 준비" + SELECT_LIST_SQL);
			
			rs= pstm.executeQuery();
			System.out.println("4. 쿼리실행 및 리턴");
			while(rs.next()) {
				AnswerDto dto = new AnswerDto(rs.getInt(1),
											rs.getInt(2), 
											rs.getInt(3),
											rs.getInt(4),
											rs.getString(5), 
											rs.getString(6), 
											rs.getString(7), 
											rs.getString(8), 
											rs.getDate(9));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, rs, pstm);
		}
		
		
		return list;
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto dto = null;
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, boardno);
			System.out.println("3. 쿼리 준비 :" + SELECT_ONE_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리 실행 및 리턴");
			while(rs.next()) {
				dto = new AnswerDto();
				dto.setBoardno(rs.getInt("BOARDNO"));
				dto.setGroupno(rs.getInt("GROUPNO"));
				dto.setGroupseq(rs.getInt("GROUPSEQ"));
				dto.setTitletab(rs.getInt("TITLETAB"));
				dto.setDelflag(rs.getString("DELFLAG"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setRegdate(rs.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, rs, pstm);
			System.out.println("5.db 종료");
		}
		
		return dto;
	}

	@Override
	public boolean boardInsert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm=con.prepareStatement(BOARD_INSERT_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			System.out.println("3. 쿼리준비 : " + BOARD_INSERT_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. 쿼리 실행 및 리턴");
			if (res> 0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("5. 디비 종료");
		}
		return (res > 0)? true : false;
	}

	@Override
	public boolean boardUpdate(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(BOARD_UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getBoardno());
			System.out.println("3. 쿼리 준비 : " + BOARD_UPDATE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. 쿼리 실행 및 리턴");
			if(res>0) {
				commit(con);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		
		return false;
	}

	@Override
	public boolean boardDelete(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(BOARD_DELETE_SQL);
			pstm.setInt(1, boardno);
			System.out.println("3. 쿼리 준비 : " + BOARD_DELETE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. 쿼리 실행 및 리턴");
			if(res> 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		
		return (res>0)? true:false;
	}

	@Override
	public int answerUpdate(int parentboardNo) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm= con.prepareStatement(ANSWER_UPDATE_SQL);
			pstm.setInt(1, parentboardNo);
			pstm.setInt(2, parentboardNo);
			System.out.println("3.쿼리 준비 : " + ANSWER_UPDATE_SQL);
			
			res = pstm.executeUpdate(); // 업데이트된 row의 갯수가 리턴이된다.
			System.out.println("4.쿼리 실행 및 리턴");
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("5.디비종료");
		}
		
		return res;
	}

	@Override
	public int answerInsert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(ANSWER_INSERT_SQL);
			pstm.setInt(1, dto.getBoardno());
			pstm.setInt(2, dto.getBoardno());
			pstm.setInt(3, dto.getBoardno());
			pstm.setString(4, dto.getTitle());
			pstm.setString(5, dto.getContent());
			pstm.setString(6, dto.getWriter());
			System.out.println("3.쿼리 준비 : " + ANSWER_INSERT_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4.쿼리 실행 및 리턴");
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("5. 디비 종료");
		}
		return res;
	}

}
