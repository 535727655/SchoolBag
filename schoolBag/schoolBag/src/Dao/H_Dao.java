package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.TaskEntity;
import Entity.UsersEntity;

public class H_Dao {

	//查询task表	 add=条件
	public List<TaskEntity> SelTask(String add){
		List<TaskEntity> list= new ArrayList<TaskEntity>();
		String sql="select * from task where "+add;
		Connection conn=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				TaskEntity p= new TaskEntity();	
				p.setTaskId(rs.getString("TaskId"));
				p.setTaskTitle(rs.getString("TaskTitle"));
				p.setTaskImage(rs.getString("TaskImage"));
				p.setTaskType(rs.getString("TaskType"));
				p.setTaskContent(rs.getString("TaskContent"));
				p.setTaskUserid(rs.getString("TaskUserid"));
				p.setTaskTime(rs.getDate("TaskTime"));
				p.setTaskBeginTime(rs.getDate("TaskBeginTime"));
				p.setTaskEndTime(rs.getDate("TaskEndTime"));
				p.setTaskFinishTime(rs.getDate("TaskFinishTime"));
				p.setTaskState(rs.getInt("TaskState"));
				p.setTaskMoney(rs.getString("TaskMoney"));
				p.setTaskRec(rs.getString("TaskRec"));
				p.setTaskShancImage(rs.getString("taskShancImage"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(rs,ps, conn);
		}
		return list;
		
	}
	
	//查询task表	 add=条件   执行存储过程    分页
	/**
	 * i:第几页
	 * row:每页几行
	 * add:条件
	 * */
		public List<TaskEntity> SelTask(int i,int row,String add){
			List<TaskEntity> list= new ArrayList<TaskEntity>();
			String sql="{call t_c(?,?,?)}";
			Connection conn=null;
			CallableStatement cs= null;
			ResultSet rs=null;
			try {
				conn=DBUitl.getCon();
				cs=conn.prepareCall(sql);
				cs.setInt(1, i);
				cs.setInt(2, row);
				cs.setString(3,add);
				if(cs.execute()){
					rs=cs.getResultSet();
					while(rs.next()){
						TaskEntity p= new TaskEntity();	
						p.setTaskId(rs.getString("TaskId"));
						p.setTaskTitle(rs.getString("TaskTitle"));
						p.setTaskImage(rs.getString("TaskImage"));
						p.setTaskType(rs.getString("TaskType"));
						p.setTaskContent(rs.getString("TaskContent"));
						p.setTaskUserid(rs.getString("TaskUserid"));
						p.setTaskTime(new Date(rs.getTimestamp("TaskTime").getTime()));
						p.setTaskBeginTime(new Date(rs.getTimestamp("TaskBeginTime").getTime()));
						//System.out.println(new Date(rs.getTimestamp("TaskBeginTime").getTime()));
						p.setTaskEndTime(new Date(rs.getTimestamp("TaskEndTime").getTime()));
						p.setTaskFinishTime(rs.getTimestamp("TaskFinishTime"));
						p.setTaskState(rs.getInt("TaskState"));
						p.setTaskMoney(rs.getString("TaskMoney"));
						p.setTaskRec(rs.getString("TaskRec"));
						list.add(p);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUitl.closeAll(rs,cs, conn);
			}
			return list;
		}
	
	// 根据taskid删除此条task
	public boolean DelTask(String taskid){
		boolean bl=false;
		String sql="delete task where TaskId="+taskid;
		System.out.println(sql);
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
	
	//查看个人详细信息
	public UsersEntity SelUsers(String UserId){
		String sql="select * from Users where UserId='"+UserId+"'";
		UsersEntity user=new UsersEntity();
		Connection conn=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				user.setAddressId(rs.getInt("addressId"));
				user.setPhone(rs.getString("phone"));
				user.setTime(rs.getDate("time"));
				user.setUserId(rs.getString("userId"));
				user.setUserInt(rs.getInt("userInt"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(rs,ps, conn);
		}
		return user;
		
	}
	
	//查询当前数据库的总页数
	public int getCount(int row){
		int i=0;
		String sql="select count(*) from task";
		Connection conn=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)%row>0)
					i=rs.getInt(1)/row+1;
				else
					i=rs.getInt(1)/row;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(null,ps, conn);
		}
		return i;
	}
	
	//更新Task
	public boolean UpdTask(String add,String obj,int taskid){
		boolean bl=false;
		String sql="update task set "+add+"='"+obj+"' where taskid="+taskid;
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
	
}
