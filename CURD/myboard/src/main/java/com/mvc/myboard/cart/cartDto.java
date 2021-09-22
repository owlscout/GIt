package com.mvc.myboard.cart;

public class cartDto {

	private int cartno;
	private int prono;
	private String proname;
	private String protitle;
	private String prokate_1;
	private String prokate_2;
	private String username;
	private int amount;
	
	public cartDto() {
		// TODO Auto-generated constructor stub
	}

	public cartDto(int cartno, int prono, String proname, String protitle, String prokate_1, String prokate_2,
			String username, int amount) {
		super();
		this.cartno = cartno;
		this.prono = prono;
		this.proname = proname;
		this.protitle = protitle;
		this.prokate_1 = prokate_1;
		this.prokate_2 = prokate_2;
		this.username = username;
		this.amount = amount;
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
	}

	public int getProno() {
		return prono;
	}

	public void setProno(int prono) {
		this.prono = prono;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProtitle() {
		return protitle;
	}

	public void setProtitle(String protitle) {
		this.protitle = protitle;
	}

	public String getProkate_1() {
		return prokate_1;
	}

	public void setProkate_1(String prokate_1) {
		this.prokate_1 = prokate_1;
	}

	public String getProkate_2() {
		return prokate_2;
	}

	public void setProkate_2(String prokate_2) {
		this.prokate_2 = prokate_2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "cartDto [cartno=" + cartno + ", prono=" + prono + ", proname=" + proname + ", protitle=" + protitle
				+ ", prokate_1=" + prokate_1 + ", prokate_2=" + prokate_2 + ", username=" + username + ", amount="
				+ amount + "]";
	}
	
	
	
}
