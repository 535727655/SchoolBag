package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.TaskEntity;

public class Taskdao {	
	//查詢全部人的帶接受任務
	public List<TaskEntity> MyAllTask(String add){
		List<TaskEntity> list= new ArrayList<TaskEntity>();
		String sql="select * from task where TaskState=0 "+add;
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
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUitl.closeAll(rs,ps, conn);
		}
		return list;
		
	}
	
	
	//查询待领取的任务
//	public List<TaskEntity> MyUnclaimedTask(int taskRec){
//		List<TaskEntity> list= new ArrayList<TaskEntity>();
//		String sql="select * from task where TaskState=0 and taskRec=?";
//		Connection conn=null;
//		PreparedStatement ps= null;
//		ResultSet rs=null;
//		try {
//			conn=DBUitl.getCon();
//			ps=conn.prepareStatement(sql);
//			ps.setInt(1,taskRec);
//			rs=ps.executeQuery();
//			while(rs.next()){
//				TaskEntity p= new TaskEntity();	
//				p.setTaskId(rs.getInt("TaskId"));
//				p.setTaskTitle(rs.getString("TaskTitle"));
//				p.setTaskImage(rs.getString("TaskImage"));
//				p.setTaskType(rs.getInt("TaskType"));
//				p.setTaskContent(rs.getString("TaskContent"));
//				p.setTaskUserid(rs.getString("TaskUserid"));
//				p.setTaskTime(rs.getDate("TaskTime"));
//				p.setTaskBeginTime(rs.getDate("TaskBeginTime"));
//				p.setTaskEndTime(rs.getDate("TaskEndTime"));
//				p.setTaskFinishTime(rs.getDate("TaskFinishTime"));
//				p.setTaskState(rs.getInt("TaskState"));
//				p.setTaskMoney(rs.getString("TaskMoney"));
//				p.setTaskRec(rs.getInt("TaskRec"));
//				list.add(p);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			DBUitl.closeAll(rs,ps, conn);
//		}
//		return list;
//		
//	}
	
	//处理中的任务
	public List<TaskEntity> MyInprocessTask(String taskRec,String add){
		List<TaskEntity> list= new ArrayList<TaskEntity>();
		String sql="select * from task where TaskState=1 and taskRec=? "+add;
		Connection conn=null;		
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,taskRec);
			rs=ps.executeQuery();
			
			while(rs.next()){
				TaskEntity p=new TaskEntity();
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
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUitl.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	//待确认的任务
	public List<TaskEntity> daiqueren(String taskRec,String add){
		List<TaskEntity> list= new ArrayList<TaskEntity>();
		String sql="select * from task where TaskState=4 and taskRec=? "+add;
		Connection conn=null;		
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,taskRec);
			rs=ps.executeQuery();
			
			while(rs.next()){
				TaskEntity p=new TaskEntity();
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
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUitl.closeAll(rs, ps, conn);
		}
		return list;
	}
	
		//查询已完成的任务
		public List<TaskEntity> MyCompleteTask(String taskRec,String add){
			List<TaskEntity> list=new ArrayList<TaskEntity>();
			String sql="select * from task where TaskState=2 and taskRec=? "+add;
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				ps.setString(1,taskRec);
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
					list.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUitl.closeAll(rs, ps, conn);
			}
			
			return list;
		}
		
		//查询取消的任务
		public List<TaskEntity> MyCanceledTask(String taskRec,String add){
			List<TaskEntity> list= new ArrayList<TaskEntity>();
			String sql="select * from task where TaskState=3 and taskRec=? "+add;
			Connection conn=null;
			PreparedStatement ps= null;
			ResultSet rs= null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				ps.setString(1,taskRec);
				rs=ps.executeQuery();
				while(rs.next()){
					TaskEntity p=new TaskEntity();
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
					list.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUitl.closeAll(rs,ps, conn);
			}
			return list;
		}
			//发布任务表单
//			public boolean addTask(TaskEntity emp){
//				boolean bl=false;
//				String sql="insert task values(?,?,?,?,?,default,?,?,?,?)";
//				
//				return bl;
//			}
//			//查询该序号的内容，点击标题显示
		public List<TaskEntity> MytaskIdTask(String taskId,String add){
			List<TaskEntity> list= new ArrayList<TaskEntity>();
			String sql="select * from task where taskId=? "+add;
			Connection conn=null;
			PreparedStatement ps= null;
			ResultSet rs= null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				ps.setString(1,taskId);
				rs=ps.executeQuery();
				while(rs.next()){
					TaskEntity p=new TaskEntity();
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
					list.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUitl.closeAll(rs,ps, conn);
			}
			return list;
		}
		
		//更新状态  Task表
		public boolean  updState(int taskid,int taskstate){
			   boolean bl=false;
			   String sql="update task set TaskState="+taskstate+" where taskid="+taskid;
			   Connection conn=null;
			   PreparedStatement ps=null;
			   try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				bl=ps.executeUpdate()>0;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUitl.closeAll(null, ps, conn);
			}
			   return bl;
			   
		   }
}
