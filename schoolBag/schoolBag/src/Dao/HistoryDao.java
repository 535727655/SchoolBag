package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.HistoryEntity;

public class HistoryDao {
	//记录表 接收
	public  List<HistoryEntity> MyreceiveTask(String userId){
		List<HistoryEntity> list =new ArrayList<HistoryEntity>();
		String sql="select TaskId,userId,Time,state from history where state=0 userId=?";
		Connection conn= null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,userId);
			rs=ps.executeQuery();
			while(rs.next()){
				HistoryEntity p= new HistoryEntity();
				p.setTaskId(rs.getInt("TaskId"));
				p.setUserId(rs.getString("userId"));
				p.setTime(rs.getDate("Time"));
				p.setState(rs.getInt("state"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}finally {
			DBUitl.closeAll(rs,ps, conn);
		}
		return list;
	}
	
	//已完成我接受的
	public  List<HistoryEntity> MyCompleteHistory(String userId){
		List<HistoryEntity> list =new ArrayList<HistoryEntity>();
		String sql="select TaskId,userId,Time,state from history where state=1 userId=?";
		Connection conn= null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,userId);
			rs=ps.executeQuery();
			while(rs.next()){
				HistoryEntity p= new HistoryEntity();
				p.setTaskId(rs.getInt("TaskId"));
				p.setUserId(rs.getString("userId"));
				p.setTime(rs.getDate("Time"));
				p.setState(rs.getInt("state"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}finally {
			DBUitl.closeAll(rs,ps, conn);
		}
		return list;
     }
	
	//取消我接受的任务
	public  List<HistoryEntity> MyInprocessHistory(String userId){
		List<HistoryEntity> list =new ArrayList<HistoryEntity>();
		String sql="select TaskId,userId,Time,state from history where state=2 userId=?";
		Connection conn= null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,userId);
			rs=ps.executeQuery();
			while(rs.next()){
				HistoryEntity p= new HistoryEntity();
				p.setTaskId(rs.getInt("TaskId"));
				p.setUserId(rs.getString("userId"));
				p.setTime(rs.getDate("Time"));
				p.setState(rs.getInt("state"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}finally {
			DBUitl.closeAll(rs,ps, conn);
		}
		return list;
     }
	//我发布的任务
	public  List<HistoryEntity> MyissueHistory(String userId){
		List<HistoryEntity> list =new ArrayList<HistoryEntity>();
		String sql="select TaskId,userId,Time,state from history where state=3 userId=?";
		Connection conn= null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,userId);
			rs=ps.executeQuery();
			while(rs.next()){
				HistoryEntity p= new HistoryEntity();
				p.setTaskId(rs.getInt("TaskId"));
				p.setUserId(rs.getString("userId"));
				p.setTime(rs.getDate("Time"));
				p.setState(rs.getInt("state"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}finally {
			DBUitl.closeAll(rs,ps, conn);
		}
		return list;
     }
}
