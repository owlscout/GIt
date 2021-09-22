package com.answer.dao;


import static com.answer.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answerboard.dto.AnswerDto;

public class AnswerDaoImple implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {
		Connection con = getConnection();
		PreparedStatement pstm =null;
		ResultSet rs=null;
		List<AnswerDto> list =new ArrayList<AnswerDto>();
		try {
			pstm=con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3.쿼리준비");
			rs= pstm.executeQuery();
			System.out.println("4.쿼리실행");
			while(rs.next()) {
				AnswerDto dto =new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setDelflag(rs.getString(5));
				dto.setTitle(rs.getString(6));
				dto.setContent(rs.getString(7));
				dto.setWriter(rs.getString(8));
				dto.setRegdate(rs.getDate(9));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(rs);
			close(con);
			System.out.println("5.db종료");
		}
		return list;
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm =null;
		ResultSet rs= null;
		
		AnswerDto dto = new AnswerDto();
		try {
			pstm =con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, boardno);
			System.out.println("3,쿼리준비"+SELECT_ONE_SQL);
			
			rs=pstm.executeQuery();
			System.out.println("4.쿼리실행");
			while(rs.next()) {
				dto =new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setDelflag(rs.getString(5));
				dto.setTitle(rs.getString(6));
				dto.setContent(rs.getString(7));
				dto.setWriter(rs.getString(8));
				dto.setRegdate(rs.getDate(9));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5.db종료");
		}
		
		
		
		return dto;
	}

	@Override
	public boolean boardInsert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		
		int res =0;
		
		try {
			pstm= con.prepareStatement(BOARD_INSERT_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(1, dto.getWriter());
			System.out.println("3.쿼리 준비 :"+BOARD_INSERT_SQL);
			res =pstm.executeUpdate();
			System.out.println("4쿼리 실행");
			if(res>0){
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("5.db종료");
		}
		
		
		return (res>0)?true:false;
	}

	@Override
	public boolean boardupdate(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		
		int res =0;
		try {
			pstm=con.prepareStatement(BOARD_UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getBoardno());
			
			System.out.println("3.쿼리 준비 :"+BOARD_INSERT_SQL);
			res =pstm.executeUpdate();
			System.out.println("4쿼리 실행");
			if(res>0) {
				commit(con);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return false;
	}

	@Override
	public boolean boardDelete(int boardno) {
		Connection con= getConnection();
		PreparedStatement pstm =null;
		int res =0;
		
		try {
			pstm=con.prepareStatement(BOARD_DELETE_SQL);
			pstm.setInt(1, boardno);
			
			System.out.println("3.쿼리준비 :"+BOARD_DELETE_SQL);
			res= pstm.executeUpdate();
			System.out.println("4.쿼리실핼");
			
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(pstm);
			close(con);
			System.out.println("5db종료");
		}
		return (res>0)? true:false;
	}

	@Override
	public int answerUdapte(int parentBoardNo) {
		Connection con = getConnection();
		PreparedStatement pstm =null;
		int res =0;
		
		try {
			pstm =con.prepareStatement(ANSWER_UPDATE_SQL);
			pstm.setInt(1, parentBoardNo);
			pstm.setInt(2, parentBoardNo);
			
			System.out.println("3.쿼리준비 :"+ANSWER_UPDATE_SQL);
			res =pstm.executeUpdate();
			System.out.println("4.쿼리실행");
			if(res >0) {
				commit(con);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("5.db종료");
		}
		
		
		
		return res;
	}

	@Override
	public int answerInsert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm =null;
		int res =0;
		
		try {
			pstm=con.prepareStatement(ANSWER_INSERT_SQL);
			pstm.setInt(1, dto.getBoardno());
			pstm.setInt(2, dto.getBoardno());
			pstm.setInt(3, dto.getBoardno());
			pstm.setString(4, dto.getTitle());
			pstm.setString(5, dto.getContent());
			pstm.setString(6, dto.getWriter());
			
			System.out.println("3.쿼리준비:"+ANSWER_INSERT_SQL);
			res= pstm.executeUpdate();
			System.out.println("4.쿼리실행");
			
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("5.db종료");
		}
		
		
		return res;
	}

}



















