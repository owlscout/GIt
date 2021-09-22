package com.mvc.myboard.cart;

import java.util.List;

import com.mvc.myboard.product.productDto;

public interface cartDao {

	String NAMESPACE = "cart.";

	public List<cartDto> selectList(String username);
	
	public List<productDto> list(int prono);
	
	public int insert(cartDto dto);
	
	public int mulinsert(cartDto dto);

	public int update(cartDto dto);

	public int delete(int cartno);

	public int count(cartDto dto);
	
	public cartDto find(cartDto dto);
}
