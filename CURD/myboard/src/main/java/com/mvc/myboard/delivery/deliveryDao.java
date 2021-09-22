package com.mvc.myboard.delivery;

import java.util.List;

public interface deliveryDao {
	
	String NAMESPACE = "delivery.";
	
	public List<deliveryDto> list(String username);
	public deliveryDto find(String username);
	public int count(String username);
	public int total(String username);
	public int insert(deliveryDto dto);
	public int update(deliveryDto dto);
	public int delete(String delno);
	public int cancel(String delno);
}
