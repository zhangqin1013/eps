package dao;

/**
 * FileName: UserDao.java
 * ʵ�ַ�����Ϣ����ز���
 * @author Lipeishan��ZhangQin
 * @Date  2020.03.20
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import pojo.User;
import pojo.userMes;
import util.IntUtil;
import util.StringUtil;

public class UserDao {
	/** ��ʦѧ��������Ϣ��д */
	public int userAdd(Connection con, userMes user) throws Exception {
		String sql = "insert into mes(userId,userName,userSex,userCollege,userPro,"
				+ "userCity,userTemperature,userArrive,userSympotom,userCheck,date) " + "values('" + user.getUserId()
				+ "','" + user.getUserName() + "'," + "'" + user.getUserSex() + "','" + user.getUserCollege() + "','"
				+ user.getUserPro() + "'," + "'" + user.getUserCity() + "','" + user.getUserTemperature() + "','"
				+ user.getUserArrive() + "'," + "'" + user.getUserSympotom() + "','" + user.getUserCheck() + "',now())";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

	/** admin�������з�����Ϣ��ʾ */
	public ResultSet StudentList(Connection con, userMes user) throws Exception {
		StringBuffer sb = new StringBuffer("select * from mes");
		if (user.getUserId() != -1) {
			sb.append(" and userId=" + user.getUserId());
		}
		if (StringUtil.isNotEmpty(user.getUserName())) {
			sb.append(" and userName like '%" + user.getUserName() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserSex())) {
			sb.append(" and userSex like '%" + user.getUserSex() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserPro())) {
			sb.append(" and userPro like '%" + user.getUserPro() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCheck())) {
			sb.append(" and userCheck like '%" + user.getUserCheck() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCity())) {
			sb.append(" and userCity like '%" + user.getUserCity() + "%'");
		}
		// System.out.println(user.getUser());
		if (StringUtil.isNotEmpty(user.getUserArrive())) {
			sb.append(" and userArrive like '%" + user.getUserArrive() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCollege())) {
			sb.append(" and userCollege like '%" + user.getUserCollege() + "%'");
		}
		if (user.getDate() > 0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') =" + user.getDate());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	/**
	 * �����Ա������״ͼ��ʾ
	 * 
	 * @param con  �������ݿ�
	 * @param user ʵ�廯�û���Ϣ
	 * @return
	 * @throws Exception
	 */
	public ResultSet Chart(Connection con, userMes user) throws Exception {
		StringBuffer sb = new StringBuffer("select userSex,count(distinct userId) as num from mes");
		if (StringUtil.isNotEmpty(user.getUserPro())) {
			sb.append(" and userPro like '%" + user.getUserPro() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCheck())) {
			sb.append(" and userCheck like '%" + user.getUserCheck() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCity())) {
			sb.append(" and userCity like '%" + user.getUserCity() + "%'");
		}
		// System.out.println(user.getUser());
		if (StringUtil.isNotEmpty(user.getUserArrive())) {
			sb.append(" and userArrive like '%" + user.getUserArrive() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCollege())) {
			sb.append(" and userCollege like '%" + user.getUserCollege() + "%'");
		}
		if (user.getDate() > 0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') =" + user.getDate());
		}
		sb.append(" group by userSex");
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		// PreparedStatement pstmt=con.prepareStatement(sb);
		return pstmt.executeQuery();
	}

	/**
	 * ����ȷ�����������״ͼ��ʾ
	 * 
	 * @param con  �������ݿ�
	 * @param user ʵ�廯�û���Ϣ
	 * @return
	 * @throws Exception
	 */
	public ResultSet Chart1(Connection con, userMes user) throws Exception {
		StringBuffer sb = new StringBuffer("select userCheck,count(distinct userId) as num from mes");

		if (StringUtil.isNotEmpty(user.getUserSex())) {
			sb.append(" and userSex like '%" + user.getUserSex() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserPro())) {
			sb.append(" and userPro like '%" + user.getUserPro() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCheck())) {
			sb.append(" and userCheck like '%" + user.getUserCheck() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCity())) {
			sb.append(" and userCity like '%" + user.getUserCity() + "%'");
		}
		// System.out.println(user.getUser());
		if (StringUtil.isNotEmpty(user.getUserArrive())) {
			sb.append(" and userArrive like '%" + user.getUserArrive() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCollege())) {
			sb.append(" and userCollege like '%" + user.getUserCollege() + "%'");
		}
		if (user.getDate() > 0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') =" + user.getDate());
		}
		sb.append(" group by userCheck");
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		// PreparedStatement pstmt=con.prepareStatement(sb);
		return pstmt.executeQuery();
	}

	/**
	 * ����ȷ���������ѧԺ��״ͼ��ʾ
	 * 
	 * @param con  �������ݿ�
	 * @param user ʵ�廯�û���Ϣ
	 * @return
	 * @throws Exception
	 */
	public ResultSet ChartCheck(Connection con, userMes user) throws Exception {
		StringBuffer sb = new StringBuffer(
				"select userCheck,count(distinct userId) as num from (select  * from college c,mes m where college=m.userCollege) as a");
		if (StringUtil.isNotEmpty(user.getUserSex())) {
			sb.append(" and userSex like '%" + user.getUserSex() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserPro())) {
			sb.append(" and userPro like '%" + user.getUserPro() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCheck())) {
			sb.append(" and userCheck like '%" + user.getUserCheck() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCity())) {
			sb.append(" and userCity like '%" + user.getUserCity() + "%'");
		}
		// System.out.println(user.getUser());
		if (StringUtil.isNotEmpty(user.getUserArrive())) {
			sb.append(" and userArrive like '%" + user.getUserArrive() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCollege())) {
			sb.append(" and userCollege like '%" + user.getUserCollege() + "%'");
		}
		if (user.getDate() > 0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') =" + user.getDate());
		}
		sb.append(" group by userCheck");
		// PreparedStatement pstmt=con.prepareStatement(sb);
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	/**
	 * ����ѧԺ��д���������״ͼ��ʾ
	 * 
	 * @param con  �������ݿ�
	 * @param user ʵ�廯�û���Ϣ
	 * @return
	 * @throws Exception
	 */
	public ResultSet PieChart(Connection con, userMes user) throws Exception {
		StringBuffer sb = new StringBuffer(
				"select \"δ��д\" as status ,count(user.id)-B.num as num from user,(select date,count(date) as num from mes");
		if (user.getDate() > 0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d ') =" + user.getDate());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		sb.append(" as B GROUP BY date UNION select \"��д\"as status,count(date) from mes");
		if (user.getDate() > 0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') =" + user.getDate());
		}
		PreparedStatement pstmt1 = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();

	}

	/**
	 * ��ʾ��¼ѧԺ�ķ�����Ϣ
	 * 
	 * @param con ���ݿ�����
	 * @param id  ��¼�˺�
	 * @return
	 * @throws Exception
	 */
	public ResultSet SelectedList(Connection con, int id) throws Exception {
		String sql = "select  * from college c,mes m where c.id=? and c.college=m.userCollege ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeQuery();

	}

	/**
	 * ѧԺ�ڲ�ѯ
	 * 
	 * @param con     ���ݿ�����
	 * @param user    ʵ�廯�û���Ϣ
	 * @param college ��ǰ��¼ѧԺ
	 * @return
	 * @throws Exception
	 */
	public ResultSet Select(Connection con, userMes user, String college) throws Exception {
		StringBuffer sb = new StringBuffer(
				"select *  from (select  * from college c,mes m where college=m.userCollege) as a");
		if (user.getUserId() != -1) {
			sb.append(" and userId=" + user.getUserId());
		}
		if (StringUtil.isNotEmpty(user.getUserName())) {
			sb.append(" and userName like '%" + user.getUserName() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserSex())) {
			sb.append(" and userSex like '%" + user.getUserSex() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserPro())) {
			sb.append(" and userPro like '%" + user.getUserPro() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCheck())) {
			sb.append(" and userCheck like '%" + user.getUserCheck() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCity())) {
			sb.append(" and userCity like '%" + user.getUserCity() + "%'");
		}
		// System.out.println(user.getUser());
		if (StringUtil.isNotEmpty(user.getUserArrive())) {
			sb.append(" and userArrive like '%" + user.getUserArrive() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCollege())) {
			sb.append(" and userCollege like '%" + user.getUserCollege() + "%'");
		}
		if (user.getDate() > 0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') =" + user.getDate());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	/**
	 * �����Ա����ѧԺ��״ͼ��ʾ
	 * 
	 * @param con  �������ݿ�
	 * @param user ʵ�廯�û���Ϣ
	 * @return
	 * @throws Exception
	 */
	public ResultSet ChartSex(Connection con, userMes user) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(
				"select userSex,count(distinct userId) as num from (select  * from college c,mes m where college=m.userCollege) as a");
		if (StringUtil.isNotEmpty(user.getUserPro())) {
			sb.append(" and userPro like '%" + user.getUserPro() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCheck())) {
			sb.append(" and userCheck like '%" + user.getUserCheck() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCity())) {
			sb.append(" and userCity like '%" + user.getUserCity() + "%'");
		}
		// System.out.println(user.getUser());
		if (StringUtil.isNotEmpty(user.getUserArrive())) {
			sb.append(" and userArrive like '%" + user.getUserArrive() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getUserCollege())) {
			sb.append(" and userCollege like '%" + user.getUserCollege() + "%'");
		}
		if (user.getDate() > 0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') =" + user.getDate());
		}
		sb.append(" group by userSex");
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
