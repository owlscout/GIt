package com.mvc.myboard.product;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.myboard.pagingDto;

@Service
public class productBizImpl implements productBiz {
	
	@Autowired
	private productDao dao;
	
	@Override
	public List<productDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public productDto selectOne(int prono) {
		// TODO Auto-generated method stub
		return dao.selectOne(prono);
	}

	@Override
	public int insert(productDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(productDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int prono) {
		// TODO Auto-generated method stub
		return dao.delete(prono);
	}
	
	@Override
	public int listCnt() {
		
		return dao.listCnt();
	}
	
	@Override
	public int mulupdate(productDto dto) {
		
		return dao.mulupdate(dto);
	}
	
	@Override
	public List<String> katelist(String prokate_1){
		
		return dao.katelist(prokate_1);
	}
	
	@Override
	public List<productDto> kateall(String prokate_1){
		
		return dao.kateall(prokate_1);
	}
	
	@Override
	public List<productDto> kateselect(productDto dto){
		
		return dao.kateselect(dto);
	}
	
}
