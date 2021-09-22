package com.ncs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ncs.JDBCTemplate.*;
public class LoginDAO {
	
	public Member selectOneMember(String userId, String password) {
		Connection con = getConnection();
		String sql = " SELECT USERID, PASSWORD, USERNAME "
				+ " FROM LOGIN "
				+ " WHERE USERID = ? "
				+ " AND PASSWORD = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		System.out.println("selectOne");
		// new Member(); 로하면 로그인 실패가 안뜨고 바로 다 로그인이 된다.
		Member Member = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, userId);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Member = new Member();
				Member.setUserId(rs.getString(1));
				Member.setPassword(rs.getString(2));
				Member.setUserName(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return Member;
	}
	
}
