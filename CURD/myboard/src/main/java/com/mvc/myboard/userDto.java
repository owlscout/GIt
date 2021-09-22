package com.mvc.myboard;

import java.util.Date;

public class userDto {
	
	private int userno;
	private String userid;
	private String userpw;
	private String username;
	private String userrole;
	private String address_1;
	private String address_2;
	private String addno;
	private Date userdate;
	
	public userDto() {
		// TODO Auto-generated constructor stub
	}

	public userDto(int userno, String userid, String userpw, String username, String userrole, String address_1,
			String address_2, String addno, Date userdate) {
		super();
		this.userno = userno;
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userrole = userrole;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.addno = addno;
		this.userdate = userdate;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getAddno() {
		return addno;
	}

	public void setAddno(String addno) {
		this.addno = addno;
	}

	public Date getUserdate() {
		return userdate;
	}

	public void setUserdate(Date userdate) {
		this.userdate = userdate;
	}

	@Override
	public String toString() {
		return "userDto [userno=" + userno + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", userrole=" + userrole + ", address_1=" + address_1 + ", address_2=" + address_2 + ", addno="
				+ addno + ", userdate=" + userdate + "]";
	}
	
	
	
	
}
