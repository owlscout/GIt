package com.mvc.myboard;

import java.sql.Date;

public class commentDto {
	
	private int commentno;
	private int groupno;
	private int groupseq;
	private int titletab;
	private int myno;
	private String username;
	private String ccontent;
	private Date cdate;
	
	public commentDto() {
		// TODO Auto-generated constructor stub
	}

	public commentDto(int commentno, int groupno, int groupseq, int titletab, int myno, String username,
			String ccontent, Date cdate) {
		super();
		this.commentno = commentno;
		this.groupno = groupno;
		this.groupseq = groupseq;
		this.titletab = titletab;
		this.myno = myno;
		this.username = username;
		this.ccontent = ccontent;
		this.cdate = cdate;
	}

	public int getCommentno() {
		return commentno;
	}

	public void setCommentno(int commentno) {
		this.commentno = commentno;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getGroupseq() {
		return groupseq;
	}

	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}

	public int getTitletab() {
		return titletab;
	}

	public void setTitletab(int titletab) {
		this.titletab = titletab;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
	

}
