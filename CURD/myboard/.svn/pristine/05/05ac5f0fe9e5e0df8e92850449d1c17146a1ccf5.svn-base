package com.mvc.myboard;

import java.util.List;

public interface myboardBiz {

	public List<myboardDto> selectList();
	public myboardDto selectOne(int myno);
	public int insert(myboardDto dto);
	public int update(myboardDto dto);
	public int delete(int myno);
	public int readcount(int myno);
	public List<myboardDto> searchtitle(String mytitle);
	public List<myboardDto> searchcontent(String mycontent);
	public List<myboardDto> searchname(String myname);
	public int insertafter(String myname);
	public int listCnt();
	public List<myboardDto> listpaging(pagingDto dto);
	public int titleCnt(String mytitle);
	public int contentCnt(String mycontent);
	public int nameCnt(String myname);
	public myboardDto pwChk(myboardDto dto);
	public List<myboardDto> pagingtitle(searchtitleDto dto);
	public List<myboardDto> pagingcontent(searchcontentDto dto);
	public List<myboardDto> pagingname(searchnameDto dto);
}
