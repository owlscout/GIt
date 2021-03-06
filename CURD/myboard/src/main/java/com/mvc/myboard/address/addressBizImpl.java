package com.mvc.myboard.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addressBizImpl implements addressBiz {
	
	@Autowired
	private addressDao dao;
	
	@Override
	public List<addressDto> selectList(String username) {
		// TODO Auto-generated method stub
		return dao.selectList(username);
	}
	
	@Override
	public addressDto main(String username) {
		
		return dao.main(username);
	}
	
	@Override
	public addressDto find(int addrno) {
		
		return dao.find(addrno);
	}
	
	@Override
	public addressDto namefind(String addname) {
		
		return dao.namefind(addname);
	}
	
	@Override
	public int insert(addressDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int mainupdate(addressDto dto) {
		// TODO Auto-generated method stub
		return dao.mainupdate(dto);
	}

	@Override
	public int delete(int addrno) {
		// TODO Auto-generated method stub
		return dao.delete(addrno);
	}

	@Override
	public int count(String username) {
		// TODO Auto-generated method stub
		return dao.count(username);
	}

}
