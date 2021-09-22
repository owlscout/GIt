package com.mvc.myboard.product;

import java.util.Date;

public class productDto {
	
	private int prono;
	private String proname;
	private String protitle;
	private String procontent;
	private Date prodate;
	private String prokate_1; 
	private String prokate_2; 
	private String thumb;
	private int proshow;
	private int ordprice;
	private int principal;
	private int tax;
	
	public productDto() {
		// TODO Auto-generated constructor stub
	}

	public productDto(int prono, String proname, String protitle, String procontent, Date prodate, String prokate_1,
			String prokate_2, String thumb, int proshow, int ordprice, int principal, int tax) {
		super();
		this.prono = prono;
		this.proname = proname;
		this.protitle = protitle;
		this.procontent = procontent;
		this.prodate = prodate;
		this.prokate_1 = prokate_1;
		this.prokate_2 = prokate_2;
		this.thumb = thumb;
		this.proshow = proshow;
		this.ordprice = ordprice;
		this.principal = principal;
		this.tax = tax;
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

	public String getProcontent() {
		return procontent;
	}

	public void setProcontent(String procontent) {
		this.procontent = procontent;
	}

	public Date getProdate() {
		return prodate;
	}

	public void setProdate(Date prodate) {
		this.prodate = prodate;
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

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public int getProshow() {
		return proshow;
	}

	public void setProshow(int proshow) {
		this.proshow = proshow;
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

	
	
	
}
