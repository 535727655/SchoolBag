package H_dao;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

public class UserDao {
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // url�����ݿ�
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=xiaobang";
	String username = "sa"; // �û���
	String password = "123123"; // ����
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public UserDao() { // ͨ�����췽���������ݿ�����
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			System.out.println("���ݿ����ʧ��");
		}
	}

	public boolean Connection() { // �������ݿ�����
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("creatConnectionError!");
		}
		return true;
	}

	public ResultSet selectStatic(String sql) throws SQLException { // �����ݿ�Ĳ�ѯ����
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

	public void closeConnection() { // �ر����ݿ�Ĳ���
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
