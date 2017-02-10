package com.nf.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
/**
 * <h2>�Զ���һ�����ݿ�����Ĺ�����</h2>
 * ���Ի�ȡ����getCon();<br>
 * ���Թر��������ݿ�������ԴcloseAll();<br>
 * ����ִ�зǲ�ѯsql���.<br>
 * @author mach
 *
 */
public class DBUitl {
	// ����
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// �����ַ���,"jdbc:sqlserver"Э�飬"localhost"���ݿ����ӵ�ַ,"1433"���ݷ���˿ں�,"nf"Ҫ���ӵ����ݿ���
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=xiaobang";
	// sql��¼�˺�
	private static String uid = "sa";
	// sql��¼����
	private static String pwd = "123456";
	/** 
	 * ��̬���������������,�Զ����У���ִֻ��һ��
	 * */
	static {
		try {
			Class.forName(driver);// ��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���ݿ�����Ӷ���
	 * 
	 * @return �������ݿ����Ӷ���
	 */
	public static Connection getCon() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �رղ��ͷ����ݿ����ӵ������Դ
	 * @param rs �������ֻ�в�ѯʱ���н������û�н�����ɹرգ����Դ�����null
	 * @param stmt ������
	 * @param conn�����Ӷ���
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
		try {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * �������������Ƿ�ɹ�!
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = getCon();
		System.out.println(conn);//��ʾ��ConnectionID:1  ��ʾ���ӳɹ�!
		conn.close();			
	}
	public static List<News> executeQuery(String sql, String ip, String uname, String upwd) {
		return null;
	}
	public static List<News> executeQuery(News news) {
		return null;
	}
}
