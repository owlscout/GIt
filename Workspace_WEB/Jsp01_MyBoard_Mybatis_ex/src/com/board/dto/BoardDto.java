package com.board.dto;

import java.util.Date;

// Data Transfer Object : 값 전달 객체 (VO - Value Object)
// DB Table 의 row 한개 값을 저장할 수 있다.
public class BoardDto {
	
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date date;
	
	public BoardDto() {
		
	}

	public BoardDto(int seq, String writer, String title, String content, Date date) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
