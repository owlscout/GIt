package com.answer.biz;

import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dao.AnswerDaoImpl;
import com.answer.dto.AnswerDto;

public class AnswerBizImpl implements AnswerBiz {
	
	AnswerDao dao = new AnswerDaoImpl();
	@Override
	public List<AnswerDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		// TODO Auto-generated method stub
		return dao.selectOne(boardno);
	}

	@Override
	public int boardInsert(AnswerDto dto) {
		// TODO Auto-generated method stub
		return dao.answerInsert(dto);
	}

	@Override
	public int boardUpdate(AnswerDto dto) {
		// TODO Auto-generated method stub
		return dao.boardUpdate(dto);
	}

	@Override
	public int boardDelete(int boardno) {
		// TODO Auto-generated method stub
		return dao.boardDelete(boardno);
	}

	@Override
	public int answerProc(AnswerDto dto) {
		
		int update = dao.answerUpdate(dto.getBoardno());
		int insert = dao.answerInsert(dto);
		
		return update + insert;
	}
	
	

}
