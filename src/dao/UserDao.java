package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import pojo.User;
import pojo.userMes;
import util.StringUtil;

public class UserDao {

	public int userAdd(Connection con,userMes user) throws Exception{
		String sql="insert into mes(userId,userName,userSex,userCollege,userPro,"
				+ "userCity,userTemperature,userArrive,userSympotom,userCheck,date) "
				+ "values('"+user.getUserId()+"','"+user.getUserName()+"',"
				+ "'"+user.getUserSex()+"','"+user.getUserCollege()+"','"+user.getUserPro()+"',"
				+ "'"+user.getUserCity()+"','"+user.getUserTemperature()+"','"+user.getUserArrive()+"',"
				+ "'"+user.getUserSympotom()+"','"+user.getUserCheck()+"',now())";
		PreparedStatement  pstmt=con.prepareStatement(sql);	
		return pstmt.executeUpdate();
	}

	public ResultSet StudentList(Connection con, userMes user) throws Exception{
		StringBuffer sb=new StringBuffer("select * from mes");
		if(user.getUserId()!=-1){
			sb.append(" and userId="+user.getUserId());
		}
		if(StringUtil.isNotEmpty(user.getUserName())){
			sb.append(" and userName like '%"+user.getUserName()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserSex())){
			sb.append(" and userSex like '%"+user.getUserSex()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserPro())){
			sb.append(" and userPro like '%"+user.getUserPro()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserCheck())){
			sb.append(" and userCheck like '%"+user.getUserCheck()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserCity())){
			sb.append(" and userCity like '%"+user.getUserCity()+"%'");
		}
		//System.out.println(user.getUser());
		if(StringUtil.isNotEmpty(user.getUserArrive())){
			sb.append(" and userArrive like '%"+user.getUserArrive()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserCollege())){
			sb.append(" and userCollege like '%"+user.getUserCollege()+"%'");
		}
		if(user.getDate()>0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') ="+user.getDate());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public ResultSet Chart(Connection con, userMes user) throws Exception{
		StringBuffer sb=new StringBuffer("select userSex,count(distinct userId) as num from mes");
		
		if(StringUtil.isNotEmpty(user.getUserPro())){
			sb.append(" and userPro like '%"+user.getUserPro()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserCheck())){
			sb.append(" and userCheck like '%"+user.getUserCheck()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserCity())){
			sb.append(" and userCity like '%"+user.getUserCity()+"%'");
		}
		//System.out.println(user.getUser());
		if(StringUtil.isNotEmpty(user.getUserArrive())){
			sb.append(" and userArrive like '%"+user.getUserArrive()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserCollege())){
			sb.append(" and userCollege like '%"+user.getUserCollege()+"%'");
		}
		if(user.getDate()>0) {
			sb.append(" and DATE_FORMAT(date,'%Y%m%d') ="+user.getDate());
		}
		sb.append(" group by userSex");
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		//PreparedStatement pstmt=con.prepareStatement(sb);
		return pstmt.executeQuery();
	}
	
	public ResultSet SelectedList(Connection con,int id)throws Exception{
		String sql="select  * from college c,Mes m where c.id=? and c.college=m.userCollege ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,id);
		return pstmt.executeQuery();
	}
	
	public void pieChart(Connection con, userMes user) {
		StringBuffer sb=new StringBuffer("select \"Œ¥ÃÓ–¥\" as status ,count(user.id)-B.num as num from user,(select date,count(date) as num from mes where date=\"2020-3-20\")as B GROUP BY date UNION select \\\"ÃÓ–¥\\\"as status,count(date) from mes where date=\\\"2020-3-20\\\"");
		if(StringUtil.isNotEmpty(user.getUserArrive())){
			sb.append(" and userArrive like '%"+user.getUserArrive()+"%'");
		}
	}
}
