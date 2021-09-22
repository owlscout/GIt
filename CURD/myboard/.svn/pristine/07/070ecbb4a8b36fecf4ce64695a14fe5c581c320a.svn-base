package com.mvc.myboard.ordhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ordhisBizImpl implements ordhisBiz {
	
	@Autowired
	private ordhisDao dao;
	
	@Override
	public List<ordhisDto> alllist(String username) {
		// TODO Auto-generated method stub
		return dao.alllist(username);
	}

	@Override
	public List<ordhisDto> list(String delno) {
		// TODO Auto-generated method stub
		return dao.list(delno);
	}

	@Override
	public int insert(ordhisDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}
	
	@Override
	public int update(ordhisDto dto) {
		
		return dao.update(dto);
	}

}
