package H_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import H_entity.Message;

public class MessageDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql="";
	/**
	 * 保存一条记录
	 */
	public int save(Message message){
		int line=0;//保存记录的行数
		sql="insert into TBL_MESSAGE(message,author,postTime) values(?,?,getdate())";
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, message.getMessage());
			ps.setString(2, message.getAuthor());
			line=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(null, ps, conn);
		}
		return line;
	}
	/**
	 * 分页显示信息
	 * 每页显示的信息数量
	 * 定位到哪一页
	 */
	public List<Message> listByPage(int pageSize,int pageNum){
		List<Message> list=new ArrayList<Message>();
		sql="select top "+pageSize+  
                " * from TBL_MESSAGE where id not in (select top "+pageSize*(pageNum-1)+  
                " id from TBL_MESSAGE order by postTime) order by postTime";  
		try {
			conn=DBUitl.getCon();
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Message message=new Message();
				message.setId(rs.getInt(1));
				message.setMessage(rs.getString(2));
				message.setAuthor(rs.getString(3));
				message.setPostTime(rs.getDate(4));
				list.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 获得记录的总条数
	 * 返回查询的所有记录的总条数
	 */
	public int getAllUserCount(){
		int ret=0;
		sql="select count(*) from TBL_MESSAGE";
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				ret=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			DBUitl.closeAll(rs, ps, conn);
		}
		return ret;
	}
}
