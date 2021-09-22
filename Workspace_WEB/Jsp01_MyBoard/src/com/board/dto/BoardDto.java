package com.board.dto;

import java.util.Date;

// Data Transfer Object : 값 전달 객체 (VO - Value Object)
// DB Table 의 row 한개 값을 저장할 수 있다.
public class BoardDto {
	
	private int myseq;
	private String mywriter;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	
	public BoardDto() {
		
	}
	
	public BoardDto(int myseq, String mywriter, String mytitle, String mycontent, Date mydate) {
		super();
		this.myseq = myseq;
		this.mywriter = mywriter;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}

	public int getMyseq() {
		return myseq;
	}

	public void setMyseq(int myseq) {
		this.myseq = myseq;
	}

	public String getMywriter() {
		return mywriter;
	}

	public void setMywriter(String mywriter) {
		this.mywriter = mywriter;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	

}
