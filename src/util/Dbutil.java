package util;

/**


* FileName: Dbutil.java

* 数据库连接

* @author Lipeishan Zhangqin
* @Date    2020.03.19

*/
import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
	private static String dbUrl = "jdbc:mysql://localhost:3306/mes?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	private static String dbUserName = "root";
	private static String dbPassword = ":hksdaPoe3jE";
	private static String jdbcName = "com.mysql.jdbc.Driver";

	public static Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}

	public static void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

}
