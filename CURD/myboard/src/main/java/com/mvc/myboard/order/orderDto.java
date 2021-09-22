package com.mvc.myboard.order;



public class orderDto {

	private String ordno;
	private String delno;
	private int prono;
	private String protitle;
	private String proname;
	private int amout;
	private int ordprice;
	private int principal;
	private int tax;
	private String username;
	private String orddate;
	
	public orderDto() {
		// TODO Auto-generated constructor stub
	}

	public orderDto(String ordno, String delno, int prono, String protitle, String proname, int amout, int ordprice,
			int principal, int tax, String username, String orddate) {
		super();
		this.ordno = ordno;
		this.delno = delno;
		this.prono = prono;
		this.protitle = protitle;
		this.proname = proname;
		this.amout = amout;
		this.ordprice = ordprice;
		this.principal = principal;
		this.tax = tax;
		this.username = username;
		this.orddate = orddate;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getDelno() {
		return delno;
	}

	public void setDelno(String delno) {
		this.delno = delno;
	}

	public int getProno() {
		return prono;
	}

	public void setProno(int prono) {
		this.prono = prono;
	}

	public String getProtitle() {
		return protitle;
	}

	public void setProtitle(String protitle) {
		this.protitle = protitle;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public int getAmout() {
		return amout;
	}

	public void setAmout(int amout) {
		this.amout = amout;
	}

	public int getOrdprice() {
		return ordprice;
	}

	public void setOrdprice(int ordprice) {
		this.ordprice = ordprice;
	}

	public int getPrincipal() {
		return principal;
	}

	public void setPrincipal(int principal) {
		this.principal = principal;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrddate() {
		return orddate;
	}

	public void setOrddate(String orddate) {
		this.orddate = orddate;
	}

	@Override
	public String toString() {
		return "orderDto [ordno=" + ordno + ", delno=" + delno + ", prono=" + prono + ", protitle=" + protitle
				+ ", proname=" + proname + ", amout=" + amout + ", ordprice=" + ordprice + ", principal=" + principal
				+ ", tax=" + tax + ", username=" + username + ", orddate=" + orddate + "]";
	}
	
	
	
}
