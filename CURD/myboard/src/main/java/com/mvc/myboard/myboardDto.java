package com.mvc.myboard;

import java.sql.Date;

public class myboardDto {

	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	private int readcount;
	private int myboardpw;
	private String fileupdown;
	
	public myboardDto() {
		// TODO Auto-generated constructor stub
	}

	public myboardDto(int myno, String myname, String mytitle, String mycontent, Date mydate, int readcount,
			int myboardpw, String fileupdown) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
		this.readcount = readcount;
		this.myboardpw = myboardpw;
		this.fileupdown = fileupdown;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
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

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getMyboardpw() {
		return myboardpw;
	}

	public void setMyboardpw(int myboardpw) {
		this.myboardpw = myboardpw;
	}

	public String getFileupdown() {
		return fileupdown;
	}

	public void setFileupdown(String fileupdown) {
		this.fileupdown = fileupdown;
	}
	
}
