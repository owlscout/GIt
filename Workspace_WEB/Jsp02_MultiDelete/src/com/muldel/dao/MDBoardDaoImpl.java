package com.muldel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muldel.dto.MDBoardDto;
import static com.muldel.db.JDBCTemplate.*;
public class MDBoardDaoImpl implements MDBoardDao {

	@Override
	public List<MDBoardDto> selectlist() {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				MDBoardDto dto = new MDBoardDto(); // while 이 반복할때마다 새로운 객체를 만들어준다.
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return list;
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		MDBoardDto dto = new MDBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
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

	@Override
	public int insert(MDBoardDto dto) {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			
				pstm.setString(1, dto.getWriter());
				pstm.setString(2, dto.getTitle());
				pstm.setString(3, dto.getContent());
				
			res = pstm.executeUpdate();
			
			if (res > 0) {
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

	@Override
	public int update(MDBoardDto dto) {
		Connection con = getConnection();
		System.out.println("db연결");
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm= con.prepareStatement(UPDATE_SQL);
			System.out.println("쿼리준비");
				pstm.setString(1, dto.getTitle());
				pstm.setString(2, dto.getContent());
				pstm.setInt(3, dto.getSeq());
			res = pstm.executeUpdate();
			System.out.println("쿼리 실행 및 리턴");
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("db종료");
		}
		
		return res;
	}

	@Override
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
				pstm.setInt(1, seq);
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

	@Override
	public int multiDelete(String[] seq) {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		
		int res = 0;
		
		int[] cnt = null;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			for(int i = 0; i < seq.length; i++) {
				pstm.setString(1, seq[i]);
				pstm.addBatch();
			}
			// int형 배열([-2,-2,-3])로 리턴이 되니 배열 객체가 필요하다
			cnt = pstm.executeBatch(); 
			
			for(int i=0; i< cnt.length; i++) {// 성공하면 -2 실패하면 -3 리턴이라
				if(cnt[i] == -2) {// 성공한 갯수를 세기위한 res++
					res++;
				} 
			}
			if(seq.length == res) { // 성공한 res가 seq.length랑 같다면 커밋
				commit(con);
			} else {
				System.out.println("삭제 실패");
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
