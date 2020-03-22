package pojo;

import java.sql.Date;

public class College {
	private int id=-1;
	private String password;
	public College() {
		super();
	}
	public College(int id, String password) {
		super();
		this.id=id;
		this.password =password;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
	this.id=id;	
	}
	public String getSpassword() {
		return password;
	}
	public void setSpassword(String password) {
		this.password=password;
	}
	

}
