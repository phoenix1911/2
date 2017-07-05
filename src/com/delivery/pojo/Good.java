package com.delivery.pojo;

import java.util.Date;

public class Good {
	 private String gno;
	 private String gname;
	 private String gaddress;
	 private String rname;
	 private String cname;
	 private Date intime;
	 private Date outtime;
	 private Date endtime;
	 private String state;
	public String getGno() {
		return gno;
	}
	public void setGno(String gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGaddress() {
		return gaddress;
	}
	public void setGaddress(String gaddress) {
		this.gaddress = gaddress;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	public Date getOuttime() {
		return outtime;
	}
	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Good(String gno, String gname, String gaddress, String rname,
			String cname, Date intime, Date outtime, Date endtime, String state) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.gaddress = gaddress;
		this.rname = rname;
		this.cname = cname;
		this.intime = intime;
		this.outtime = outtime;
		this.endtime = endtime;
		this.state = state;
	}
	public Good() {
		super();
	}
	@Override
	public String toString() {
		return "Good [gno=" + gno + ", gname=" + gname + ", gaddress="
				+ gaddress + ", rname=" + rname + ", cname=" + cname
				+ ", intime=" + intime + ", outtime=" + outtime + ", endime="
				+ endtime + ", state=" + state + "]";
	}
	 
}
