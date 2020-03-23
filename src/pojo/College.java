package pojo;

/**
 * FileName: College.java
 * 二级学院登录实体类
 * @author Lipeishan，ZhangQin
 * @Date  2020.03.19
 */
import java.sql.Date;

public class College {
   //学院账号
	private int id = -1;
	//学院密码
	private String password;
	//学院名
	private String college;

	public College() {
		super();
	}

	public College(int id, String password) {
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

}
