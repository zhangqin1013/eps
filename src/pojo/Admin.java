package pojo;

/**
 * FileName: Admin.java
 * 防控办登录实体类
 * @author Lipeishan，ZhangQin
 * @Date  2020.03.19
 */
import java.sql.Date;

public class Admin {
	private int id = -1;
	private String password;

	public Admin() {
		super();
	}

	public Admin(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getSpassword() {
		return password;
	}

	public void setSpassword(String password) {
		this.password = password;
	}

}
