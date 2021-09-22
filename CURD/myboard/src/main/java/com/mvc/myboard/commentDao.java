package com.mvc.myboard;

import java.util.List;

public interface commentDao {
	String NAMESPACE = "comment.";
	
	public List<commentDto> commentList(int myno);
	public int insert(commentDto cdto);
	public int update(commentDto cdto);
	public int delete(commentDto cdto);
	public int answerUpdate(int parentcommentNo);
	public int answerInsert(commentDto cdto);
	
}
