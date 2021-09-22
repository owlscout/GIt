package com.mvc.myboard.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class deliveryBizImpl implements deliveryBiz {
	
	@Autowired
	private deliveryDao dao;
	
	@Override
	public List<deliveryDto> list(String username) {
		// TODO Auto-generated method stub
		return dao.list(username);
	}

	@Override
	public deliveryDto find(String username) {
		
		return dao.find(username);
	}
	
	@Override
	public int count(String username) {
		
		return dao.count(username);
	}
	
	@Override
	public int total(String username) {
		
		return dao.total(username);
	}
	
	@Override
	public int insert(deliveryDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(deliveryDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(String delno) {
		// TODO Auto-generated method stub
		return dao.delete(delno);
	}
	
	@Override
	public int cancel(String delno) {
		
		return dao.cancel(delno);
	}

}
