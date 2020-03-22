package pojo;
import java.util.Date;
public class userMes {
	private int userId=-1;
	private String userName;
	private String userSex;
	private String userCollege;
	private String userPro;
	private String userCity;
	private String userArrive;
	private String userSympotom;
	private String userCheck;
	private int date;
	private float userTemperature;
	private int num;//Ìî±¨ÈËÊý
	private String status;
	public userMes() {
		super();
	}
	public userMes(int id, String name, String sex, String college, String province, String city,
				float tem,String school, String sy0, String sy1) {
			  // TODO Auto-generated constructor stub
		super();
		this.userId=id;
		this.userName = name;
		this.userSex = sex;
		this.userCollege = college;
		this.userPro = province;
		this.userCity = city;
		this.userTemperature = tem;
		this.userArrive = school;
		this.userSympotom = sy0;
		this.userCheck = sy1;
		this.date=date;
	}
	public userMes(int id,String name, String sex,String pro,String city, 
			String school,String sy1,int date) {
		
		// TODO Auto-generated constructor stub
		super();
		this.userId=id;
		this.userName = name;
		this.userSex = sex;
		//this.userCollege = college;
		this.userPro = pro;
		this.userCity = city;
		//this.userTemperature = tem;
		this.userArrive = school;
		//this.userSympotom = sy0;
		this.userCheck = sy1;
		this.date=date;
	}
	public userMes(int id,String name, String sex,String college,String pro,String city, 
			String school,String sy1,int date) {
		
		// TODO Auto-generated constructor stub
		super();
		this.userId=id;
		this.userName = name;
		this.userSex = sex;
		this.userCollege = college;
		this.userPro = pro;
		this.userCity = city;
		//this.userTemperature = tem;
		this.userArrive = school;
		//this.userSympotom = sy0;
		this.userCheck = sy1;
		this.date=date;
	}
	public userMes(String college) {
		
		// TODO Auto-generated constructor stub
		super();
		this.userCollege=college;
		//this.userName = name;
	}
	public userMes(int id,String name) {
		
		// TODO Auto-generated constructor stub
		super();
		this.userId=id;
		this.userName = name;
	}
	public userMes(String status, int num) {
		// TODO Auto-generated constructor stub
		super();
		this.status=status;
		this.num=num;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserCollege() {
		return userCollege;
	}
	public void setUserCollege(String userCollege) {
		this.userCollege = userCollege;
	}
	public String getUserPro() {
		return userPro;
	}
	public void setUserPro(String userPro) {
		this.userPro = userPro;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserArrive() {
		return userArrive;
	}
	public void setUserArrive(String userArrive) {
		this.userArrive = userArrive;
	}
	public String getUserSympotom() {
		return userSympotom;
	}
	public void setUserSympotom(String userSympotom) {
		this.userSympotom = userSympotom;
	}
	public String getUserCheck() {
		return userCheck;
	}
	public void setUserCheck(String userCheck) {
		this.userCheck = userCheck;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public float getUserTemperature() {
		return userTemperature;
	}
	public void setUserTemperature(float userTemperature) {
		this.userTemperature = userTemperature;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
