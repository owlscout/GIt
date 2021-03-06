package com.mvc.myboard.address;

public class addressDto {
	
	private int addrno;
	private String addname;
	private String username;
	private String address_1;
	private String address_2;
	private String addno;
	private char mainaddr;
	
	public addressDto() {
		// TODO Auto-generated constructor stub
	}

	public addressDto(int addrno, String addname, String username, String address_1, String address_2, String addno,
			char mainaddr) {
		super();
		this.addrno = addrno;
		this.addname = addname;
		this.username = username;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.addno = addno;
		this.mainaddr = mainaddr;
	}

	public int getAddrno() {
		return addrno;
	}

	public void setAddrno(int addrno) {
		this.addrno = addrno;
	}

	public String getAddname() {
		return addname;
	}

	public void setAddname(String addname) {
		this.addname = addname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public char getMainaddr() {
		return mainaddr;
	}

	public void setMainaddr(char mainaddr) {
		this.mainaddr = mainaddr;
	}

	@Override
	public String toString() {
		return "addressDto [addrno=" + addrno + ", addname=" + addname + ", username=" + username + ", address_1="
				+ address_1 + ", address_2=" + address_2 + ", addno=" + addno + ", mainaddr=" + mainaddr + "]";
	}
	
	
	
}
