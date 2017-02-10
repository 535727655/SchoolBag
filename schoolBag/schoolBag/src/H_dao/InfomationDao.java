package H_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import H_entity.Infomation;


public class InfomationDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	public List<Infomation> finaAll(){
		List<Infomation> list=new ArrayList<Infomation>();
		sql="select * from infomation";
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Infomation in=new Infomation();
				in.setBh(rs.getInt("bh"));
				in.setBiaoti(rs.getString("biaoti"));
				in.setCd(rs.getString("cd"));
				in.setLxr(rs.getString("lxr"));
				in.setPhone(rs.getString("phone"));
				in.setPricture(rs.getString("pricture"));
				in.setTime(rs.getDate("time"));
				in.setPrice(rs.getInt("price"));
				in.setContent(rs.getString("content"));
				list.add(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(rs, ps, conn);
		}
		return list;
	}
}
