package com.bike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static com.bike.db.JDBCTemplate.*;
import com.bike.dto.BikeDto;

public class BikeDao {

	public boolean insert(List<BikeDto> list) {
		// list 안에 있는 값들 전체 저장
		Connection con = getConnection();
		
		String sql = " INSERT INTO KOREABIKE "
					+" VALUES(?, ?, ?, ?, ?)  ";
		
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			for (int i = 0; i< list.size(); i++) {
				pstm.setString(1, list.get(i).getName());
				pstm.setString(2, list.get(i).getAddr());
				pstm.setDouble(3, list.get(i).getLatitude());
				pstm.setDouble(4, list.get(i).getLongitude());
				pstm.setInt(5, list.get(i).getBike_count());
				
				pstm.addBatch();
			}
			
			int[] result = pstm.executeBatch();
			
			for (int i = 0; i < result.length; i++) {
				if(result[i] == -2) {
					res++;
				}
			}
			if(res == list.size()) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstm);
			System.out.println("5.db 종료");
		}
		
		return (res == list.size())? true : false;
	}
	
	
	public boolean delete() {
		//db 내용 전체 삭제
		Connection con = getConnection();
		String sql = " DELETE FROM KOREABIKE ";
		
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			res = pstm.executeUpdate();
			if (res > 0 ) {
				commit(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}
		return (res > 0)? true : false;
	}
	
}
