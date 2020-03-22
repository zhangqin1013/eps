package dao;

/**
 * FileName: LogOnDao.java
 * ��ݲ�ͬ��¼
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.19
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Admin;
import pojo.College;
import pojo.User;

public class LogOnDao {
	public User login(Connection con, User student) throws Exception {
		User resultStu = null;
		String sql = "select * from user where id=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, student.getID());
		pstmt.setString(2, student.getSpassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			resultStu = new User();
			resultStu.setID(rs.getInt("id"));
			resultStu.setSpassword(rs.getString("password"));
		}
		return resultStu;
	}

	public Admin login(Connection con, Admin admin) throws SQLException {
		Admin resultStu = null;
		String sql = "select * from admin1 where id=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, admin.getID());
		pstmt.setString(2, admin.getSpassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			resultStu = new Admin();
			resultStu.setID(rs.getInt("id"));
			resultStu.setSpassword(rs.getString("password"));
		}
		return resultStu;
	}

	public College login(Connection con, College college) throws SQLException {
		College resultStu = null;
		String sql = "select * from college,mes where college.id=? and college.password=? and college.college=mes.userCollege";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, college.getID());
		pstmt.setString(2, college.getSpassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			resultStu = new College();
			resultStu.setID(rs.getInt("id"));
			resultStu.setSpassword(rs.getString("password"));
		}
		return resultStu;
	}

}
