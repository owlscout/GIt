package com.mvc.myboard.order;

import java.util.List;

public interface orderDao {
	
	String NAMESPACE = "order.";
	public List<orderDto> selectList(String delno);
	public orderDto select(String ordno);
	public int insert(orderDto dto);
	public int update(orderDto dto);
	public int delete(String ordno);
	
}
