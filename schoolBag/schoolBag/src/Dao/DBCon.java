package Dao;

import java.sql.*;

public class DBCon {
	public static Connection getCon() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=xiaobang","sa","123123");
		return conn;
	}
	
	public static void closeAll(Statement stmt,ResultSet rs,Connection conn) throws Exception{
		if(stmt!=null)
			stmt.close();
		if(rs!=null)
				rs.close();
		if(conn!=null)
			conn.close();
	}
}
