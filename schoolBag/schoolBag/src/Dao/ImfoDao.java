package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.Imformation;
import Entity.UsersEntity;


public class ImfoDao {
	
	/**
	 * 查找指定前用户的消息
	 * 根据状态
	 * user:接收人
	 * state:消息状态
	 * */
	public List<Imformation> SelImfo(UsersEntity user,int state){
		List<Imformation> list= new ArrayList<Imformation>();
		String sql="select * from Imformation where ImfoRec='"+user.getUserId()+"' and Imfostate="+state;
		System.out.println(sql);
		Connection conn=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
				while(rs.next()){
					Imformation im=new Imformation();
					im.setContent(rs.getString("content"));
					im.setDispoTime(rs.getTimestamp("dispoTime")!=null?new Date(rs.getTimestamp("dispoTime").getTime()):null);
					im.setImfoId(rs.getInt("imfoId"));
					im.setImfoRec(rs.getString("imfoRec"));
					im.setImfostate(rs.getInt("imfostate"));
					im.setImfotime(new Date(rs.getTimestamp("imfotime").getTime()));
					im.setTaskId(rs.getInt("taskId"));
					im.setImfouserid(rs.getString("imfouserid"));
					list.add(im);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(rs,ps, conn);
		}
		return list;
	}
	
	//发送消息  接收人完成任务时发送给发布人的确认消息   默认确认时间为null  接收人点击时修改时间为当前时间
	public boolean send(Imformation im){
		boolean bl=false;
		String sql="insert into imformation values(?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement ps= null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,im.getImfoRec());
			ps.setInt(2,im.getImfostate());
			ps.setTimestamp(3,new Timestamp(im.getImfotime().getTime()));
			ps.setDate(4, null);
			ps.setString(5,im.getContent());
			ps.setInt(6, im.getTaskId());
			ps.setString(7,im.getImfouserid());
			bl=ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(null,ps, conn);
		}
		return bl;
	}
	
	//修改查看时间 为default
	public boolean Lookup(Imformation im){
		boolean bl=false;
		String sql="update imformation set dispoTime=default where ImfoId="+im.getImfoId();
		Connection conn=null;
		PreparedStatement ps= null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);			
			bl=ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(null,ps, conn);
		}
		return bl;
	}
	
	//修改imfo状态servlet
	public boolean UpImfoState(Imformation im){
		boolean bl=false;
		String sql="update imformation set Imfostate="+im.getImfostate()+" where ImfoId="+im.getImfoId();
		Connection conn=null;
		PreparedStatement ps= null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);			
			bl=ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(null,ps, conn);
		}
		return bl;
	}
	
	//根据id查找imfo信息
	public Imformation SelImfo(int imfoid){
		Imformation im=new Imformation();
		String sql="select * from Imformation where ImfoId="+imfoid;
		Connection conn=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
				if(rs.next()){
					im.setContent(rs.getString("content"));
					im.setDispoTime(rs.getTimestamp("dispoTime")!=null?new Date(rs.getTimestamp("dispoTime").getTime()):null);
					im.setImfoId(rs.getInt("imfoId"));
					im.setImfoRec(rs.getString("imfoRec"));
					im.setImfostate(rs.getInt("imfostate"));
					im.setImfotime(new Date(rs.getTimestamp("imfotime").getTime()));
					im.setTaskId(rs.getInt("taskId"));
					im.setImfouserid(rs.getString("imfouserid"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(rs,ps, conn);
		}
		return im;
	}
}
