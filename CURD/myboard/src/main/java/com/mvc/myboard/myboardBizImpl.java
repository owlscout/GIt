package com.mvc.myboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class myboardBizImpl implements myboardBiz {
	
	@Autowired
	private myboardDao dao;
	
	@Override
	public List<myboardDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public myboardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		return dao.selectOne(myno);
	}

	@Override
	public int insert(myboardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(myboardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		// TODO Auto-generated method stub
		return dao.delete(myno);
	}

	@Override
	public int readcount(int myno) {
		// TODO Auto-generated method stub
		return dao.readcount(myno);
	}
	
	@Override
	public List<myboardDto> searchtitle(String mytitle){
		
		return dao.searchtitle(mytitle);
	}
	
	@Override
	public List<myboardDto> searchcontent(String mycontent){
		
		return dao.searchcontent(mycontent);
	}
	
	@Override
	public List<myboardDto> searchname(String myname){
		
		return dao.searchname(myname);
	}
	
	@Override
	public int insertafter(String myname) {
		
		return dao.insertafter(myname);
	}
	
	@Override
	public int listCnt() {
		
		return dao.listCnt();
	}
	
	@Override
	public List<myboardDto> listpaging(pagingDto dto){
		
		return dao.listpaging(dto);
	}
	
	@Override
	public int titleCnt(String mytitle) {
		
		return dao.titleCnt(mytitle);
	}
	
	@Override
	public int contentCnt(String mycontent) {
		
		return dao.contentCnt(mycontent);
	}
	
	@Override
	public int nameCnt(String myname) {
		
		return dao.nameCnt(myname);
	}
	
	@Override
	public myboardDto pwChk(myboardDto dto) {
		
		return dao.pwChk(dto);
	}
	
	@Override
	public List<myboardDto> pagingtitle(searchtitleDto dto){
		
		return dao.pagingtitle(dto);
	}
	
	@Override
	public List<myboardDto> pagingcontent(searchcontentDto dto){
		
		return dao.pagingcontent(dto);
	}
	
	@Override
	public List<myboardDto> pagingname(searchnameDto dto){
		
		return dao.pagingname(dto);
	}
	
}
