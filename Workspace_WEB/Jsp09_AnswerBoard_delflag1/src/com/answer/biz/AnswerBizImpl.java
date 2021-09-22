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
	public boolean boardInsert(AnswerDto dto) {
		// TODO Auto-generated method stub
		return dao.boardInsert(dto);
	}

	@Override
	public boolean boardUpdate(AnswerDto dto) {
		// TODO Auto-generated method stub
		return dao.boardUpdate(dto);
	}

	@Override
	public boolean boardDelete(int boardno) {
		// TODO Auto-generated method stub
		return dao.boardDelete(boardno);
	}

	@Override
	public int answerProc(AnswerDto dto) {
		// business logic (service login)에서 transaction(최소 작업 단위) 처리
		// 원래는 트랜잭션 처리 해야하나, 간단하게 넘어감.
		
		int update = dao.answerUpdate(dto.getBoardno());
		int insert = dao.answerInsert(dto);
		return update + insert;
	}

}
