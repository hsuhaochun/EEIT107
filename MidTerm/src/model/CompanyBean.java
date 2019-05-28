package model;

import java.util.Date;

public class CompanyBean   {
	private int comco;
	private String comname;
	private String industry;
	private String chariman;
	private java.util.Date listdate;
	private String email;
	
	public CompanyBean() {
	}
	
	public CompanyBean(int comco, String comname, String industry, String chariman, Date listdate, String email
			) {
		super();
		this.comco = comco ;
		this.comname =comname;
		this.industry = industry;
		this.chariman = chariman;
		this.listdate = listdate;
		this.email = email;
		
	}
	
	public String toString() {
		return "["+comco+","+comname+","+industry+","+chariman+","+listdate+","+email+"]";
	}
	public int getComco() {
		return comco;
	}

	public void setComco(int comco) {
		this.comco = comco;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getChariman() {
		return chariman;
	}

	public void setChariman(String chariman) {
		this.chariman = chariman;
	}

	public java.util.Date getListdate() {
		return listdate;
	}

	public void setListdate(java.util.Date listdate) {
		this.listdate = listdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
