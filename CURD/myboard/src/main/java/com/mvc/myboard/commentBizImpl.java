package com.mvc.myboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentBizImpl implements commentBiz {
	
	@Autowired
	private commentDao dao;
	
	@Override
	public List<commentDto> commentList(int myno) {
		// TODO Auto-generated method stub
		return dao.commentList(myno);
	}

	@Override
	public int insert(commentDto cdto) {
		// TODO Auto-generated method stub
		return dao.insert(cdto);
	}

	@Override
	public int update(commentDto cdto) {
		// TODO Auto-generated method stub
		return dao.update(cdto);
	}

	@Override
	public int delete(commentDto cdto) {
		// TODO Auto-generated method stub
		return dao.delete(cdto);
	}

	@Override
	public int answerProc(commentDto cdto) {
		// TODO Auto-generated method stub
		int update = dao.answerUpdate(cdto.getCommentno());
		int insert = dao.answerInsert(cdto);
		
		return update + insert;
	}

}
