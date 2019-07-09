package com.bw.bean;

public class Area {
	private Integer aid;
	private String aname;
	private Integer pdi;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Integer getPdi() {
		return pdi;
	}
	public void setPdi(Integer pdi) {
		this.pdi = pdi;
	}
	@Override
	public String toString() {
		return aname;
	}
	
}
