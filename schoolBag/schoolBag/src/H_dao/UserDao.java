package H_dao;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

public class UserDao {
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // url，数据库
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=xiaobang";
	String username = "sa"; // 用户名
	String password = "123123"; // 密码
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public UserDao() { // 通过构造方法加载数据库驱动
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
		}
	}

	public boolean Connection() { // 创建数据库连接
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("creatConnectionError!");
		}
		return true;
	}

	public ResultSet selectStatic(String sql) throws SQLException { // 对数据库的查询操作
		ResultSet rs = null;
		if (con == null) {
			Connection();
		}
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void closeConnection() { // 关闭数据库的操作
		if (con != null && stmt != null && rs != null) {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Failed to close connection!");
			} finally {
				con = null;
			}
		}
	}

}
