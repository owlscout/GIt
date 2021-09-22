<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">



<%	
	// scriptlet 여기가 자바 코드 영역이다.
	
	// http 500 : internal server error
	// http 404 : not found (경로 오타)
	
	// EMP 테이블 전체 출력
	
	//jsp는 java server page이고, 서버에서 컴파일하다 예외가 발생할 시 특정 화면으로 넘겨주는 지시자가 따로 있습니다.
	//또한 에러메시지를 화면에 바로 출력해주기에 안써도 상관은 없습니다...만, 그래도 사실 쓰는게 좋긴 합니다.
	
	// 1. driver 연결
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	// 2. 계정 연결
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "kh";
	String password = "kh";
	Connection con = null;	// 컨트롤 세페이스바로 java.sql꺼로 임포트 하면된다.
	
	con = DriverManager.getConnection(url, user, password);
	// 3. query 준비
	String sql= " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO " +
				" FROM EMP ";
	
	Statement stmt = null; // java.sql\
	ResultSet rs = null;
	stmt = con.createStatement();
	
	// 4. query 실행 및 리턴
	rs= stmt.executeQuery(sql);
	
	while(rs.next()){
%>
<!-- HTML 영역 -->
	<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getInt(4) %></td>
		<td><%=rs.getDate(5) %></td>
		<td><%=rs.getDouble(6) %></td>
		<td><%=rs.getDouble(7) %></td>
		<td><%=rs.getInt(8) %></td>
	</tr>	

<% 	
	}
	
	// 5. db종료
	rs.close();
	stmt.close();
	con.close();
	
	
%>

	</table>

</body>
</html>