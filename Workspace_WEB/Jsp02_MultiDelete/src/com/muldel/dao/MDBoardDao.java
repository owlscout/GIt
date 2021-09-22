package com.muldel.dao;

import java.util.List;

import com.muldel.dto.MDBoardDto;

public interface MDBoardDao {
	
	String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
			+ " FROM MDBOARD "
			+ " ORDER BY SEQ DESC ";
	String SELECT_ONE_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
			+ " FROM MDBOARD "
			+ " WHERE SEQ = ? ";
	String INSERT_SQL = " INSERT INTO MDBOARD "
			+ " VALUES(MDBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
	String UPDATE_SQL = " UPDATE MDBOARD"
			+ " SET TITLE=?, CONTENT=? "
			+ " WHERE SEQ = ? ";
	String DELETE_SQL = " DELETE FROM MDBOARD "
			+ " WHERE SEQ=? ";
	// 전체 출력
	public List<MDBoardDto> selectlist();
	// 선택 출력
	public MDBoardDto selectOne(int seq);
	// 추가
	public int insert(MDBoardDto dto);
	// 수정
	public int update(MDBoardDto dto);
	// 삭제
	public int delete(int seq);
	// 선택 삭제 (여러개 한번에 삭제)	String이 아니라 list, map, set 이어도 된다.
	public int multiDelete(String[] seq);
	
	
	
}
