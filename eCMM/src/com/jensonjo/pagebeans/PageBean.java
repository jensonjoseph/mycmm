package com.jensonjo.pagebeans;

public class PageBean {
	String fromPage;
	String dt;

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getFromPage() {
		return fromPage;
	}

	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}

	public PageBean() {
		fromPage = "none";
	}
}
