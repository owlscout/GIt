package com.mvc.myboard.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderBizImpl implements orderBiz {
	
	@Autowired
	private orderDao dao;
	
	@Override
	public List<orderDto> selectList(String delno) {
		// TODO Auto-generated method stub
		return dao.selectList(delno);
	}

	@Override
	public orderDto select(String ordno) {
		// TODO Auto-generated method stub
		return dao.select(ordno);
	}

	@Override
	public int insert(orderDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(orderDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(String ordno) {
		// TODO Auto-generated method stub
		return dao.delete(ordno);
	}

}
