package com.delivery.pojo;

public class Receiver {
    private String rname;
    private String rsex;
    private int rage;
    private String rphone;
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRsex() {
		return rsex;
	}
	public void setRsex(String rsex) {
		this.rsex = rsex;
	}
	public int getRage() {
		return rage;
	}
	public void setRage(int rage) {
		this.rage = rage;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public Receiver(String rname, String rsex, int rage, String rphone) {
		super();
		this.rname = rname;
		this.rsex = rsex;
		this.rage = rage;
		this.rphone = rphone;
	}
	public Receiver() {
		super();
	}
	@Override
	public String toString() {
		return "Receiver [rname=" + rname + ", rsex=" + rsex + ", rage=" + rage
				+ ", rphone=" + rphone + "]";
	}
   
}
