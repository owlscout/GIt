package com.answer.biz;

import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dao.AnswerDaoImple;
import com.answerboard.dto.AnswerDto;

public class AnswerBizImple implements AnswerBiz {
	
	private AnswerDao dao =new AnswerDaoImple();
	
	@Override
	public List<AnswerDto> selectList() {
		return dao.selectList();
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		return dao.selectOne(boardno);
	}

	@Override
	public boolean boardInsert(AnswerDto dto) {
		return dao.boardInsert(dto);
	}

	@Override
	public boolean boardupdate(AnswerDto dto) {
		return dao.boardInsert(dto);
	}

	@Override
	public boolean boardDelete(int boardno) {
		return dao.boardDelete(boardno);
	}

	@Override
	public int answerProc(AnswerDto dto) {
		// business logic (service logic)에서 transaction(최소한의 작업단위) 처리
		
		int update =dao.answerUdapte(dto.getBoardno());
		int insert =dao.answerInsert(dto);
		
		
		return update + insert;
	}

}
