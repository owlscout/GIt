package com.mvc.myboard.ordhistory;

import java.util.Date;

public class ordhisDto {
	
	private int ordhisno;
	private String username;
	private String delno;
	private String reason;
	private String ordhisdate;
	
	public ordhisDto() {
		// TODO Auto-generated constructor stub
	}

	public ordhisDto(int ordhisno, String username, String delno, String reason, String ordhisdate) {
		super();
		this.ordhisno = ordhisno;
		this.username = username;
		this.delno = delno;
		this.reason = reason;
		this.ordhisdate = ordhisdate;
	}

	public int getOrdhisno() {
		return ordhisno;
	}

	public void setOrdhisno(int ordhisno) {
		this.ordhisno = ordhisno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDelno() {
		return delno;
	}

	public void setDelno(String delno) {
		this.delno = delno;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOrdhisdate() {
		return ordhisdate;
	}

	public void setOrdhisdate(String ordhisdate) {
		this.ordhisdate = ordhisdate;
	}

	@Override
	public String toString() {
		return "ordhisDto [ordhisno=" + ordhisno + ", username=" + username + ", delno=" + delno + ", reason=" + reason
				+ ", ordhisdate=" + ordhisdate + "]";
	}
	
	
	
}
