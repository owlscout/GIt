package com.mvc.myboard.product;

import java.util.List;
import java.util.Set;

import com.mvc.myboard.pagingDto;

public interface productDao {
	
	String NAMESPACE = "product.";
	
	public List<productDto> selectList();
	public productDto selectOne(int prono);
	public int insert(productDto dto);
	public int update(productDto dto);
	public int delete(int prono);
	public int listCnt();
	public int mulupdate(productDto dto);
	public List<String> katelist(String prokate_1);
	public List<productDto> kateall(String prokate_1);
	public List<productDto> kateselect(productDto dto);
}
