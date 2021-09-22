package com.mvc.myboard;

import java.util.List;

public interface commentBiz {
	
	public List<commentDto> commentList(int myno);
	public int insert(commentDto cdto);
	public int update(commentDto cdto);
	public int delete(commentDto cdto);
	public int answerProc(commentDto cdto);
}
