package com.delivery.pojo;

public class Courier {
    private String cname;
    private String csex;
    private int cage;
    private String cphone;
   
    public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCsex() {
		return csex;
	}
	public void setCsex(String csex) {
		this.csex = csex;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

    public Courier(String cname, String csex, int cage, String cphone) {
		super();
		this.cname = cname;
		this.csex = csex;
		this.cage = cage;
		this.cphone = cphone;
	}
	public Courier() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	public String toString() {
		return "Courier [cname=" + cname + ", csex=" + csex + ", cage=" + cage
				+ ", cphone=" + cphone + "]";
	}

    
    
}