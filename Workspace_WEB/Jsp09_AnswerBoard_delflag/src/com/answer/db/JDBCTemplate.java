package com.answer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	
public static Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="kh";
		String password ="kh";
		System.out.println("1.계정연결");
		Connection con=null;
		
		try {
			con =DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			System.out.println("2.driver연결");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return con;
	}
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstm) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
