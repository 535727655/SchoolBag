package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class schoolDao {
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
	
	//查找address  查找所有addressid and addressname
	public  List<Map<String,String>> getAllSchool() throws Exception{
		List<Map<String,String>> ls=new ArrayList<Map<String,String>>();
		String sql="select addressid,addressname from address";
		try{
			conn=DBCon.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Map<String,String> m=new HashMap<String,String>();
				m.put("addressid", rs.getString(1));
				m.put("addressname", rs.getString(2));
				ls.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBCon.closeAll(ps, rs, conn);
		}
		return ls;
	}
}
