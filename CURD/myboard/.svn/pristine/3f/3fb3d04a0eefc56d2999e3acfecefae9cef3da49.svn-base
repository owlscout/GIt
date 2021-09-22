package com.mvc.myboard.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.myboard.product.productDto;

@Service
public class cartBizImpl implements cartBiz {
	
	@Autowired
	private cartDao dao;
	
	@Override
	public List<cartDto> selectList(String username) {
		// TODO Auto-generated method stub
		return dao.selectList(username);
	}

	@Override
	public List<productDto> list(int prono){
		
		return dao.list(prono);
	}
	
	@Override
	public int insert(cartDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}
	
	@Override
	public int mulinsert(cartDto dto) {
		
		return dao.mulinsert(dto);
	}
	
	@Override
	public int update(cartDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int cartno) {
		// TODO Auto-generated method stub
		return dao.delete(cartno);
	}

	@Override
	public int count(cartDto dto) {
		// TODO Auto-generated method stub
		return dao.count(dto);
	}
	
	@Override
	public cartDto find(cartDto dto) {
		
		return dao.find(dto);
	}
}
