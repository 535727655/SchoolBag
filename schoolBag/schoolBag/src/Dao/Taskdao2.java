package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import Entity.TaskEntity;

public class Taskdao2 {
	public boolean addTask(TaskEntity tke){
		boolean bl=false;//          -任务标题       图片                  任务类型          任务内容                发布人               任务发布时间  任务开始时间              任务结束时间         状态                  任务奖励
		String sql="insert into task(TaskTitle,TaskImage,TaskType,TaskContent,TaskUserid,TaskTime,TaskBeginTime,TaskEndTime,TaskState,TaskMoney) values(?,?,?,?,?,default,?,?,?,?)";
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,tke.getTaskTitle());
			ps.setString(2,tke.getTaskImage());
			ps.setString(3,tke.getTaskType());
			ps.setString(4,tke.getTaskContent());
			ps.setString(5,tke.getTaskUserid());//发布人
			//ps.setDate(6,tke.getTaskTime());
			ps.setTimestamp(6,new Timestamp(tke.getTaskBeginTime().getTime()));
			ps.setTimestamp(7,new Timestamp(tke.getTaskEndTime().getTime()));
			
			ps.setInt(8,tke.getTaskState());
			ps.setString(9,tke.getTaskMoney());
			int p=ps.executeUpdate();
			bl=p>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUitl.closeAll(null, ps, conn);
		}
		return bl;	
	}
	
	//点击领取，插入单前的账号的名称作为接收人
	public boolean InTaskRec(String TaskRec, String taskId){
		boolean bl= false;
		String sql="update task set TaskRec=?,TaskState=1 where TaskId=?";
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,TaskRec);
			ps.setString(2,taskId);
			int p=ps.executeUpdate();
			bl=p>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUitl.closeAll(null, ps, conn);
		}
		return bl;
		
		}
	//取消任务
	   public boolean Abolish( int taskId){
			boolean bl= false;
			String sql="update task set TaskState=3 where TaskId=?";
			Connection conn=null;
			PreparedStatement ps=null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				ps.setInt(1,taskId);
				int p=ps.executeUpdate();
				bl=p>0;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUitl.closeAll(null, ps, conn);
			}
			return bl;
	}
	   
	   //提交任务添加提交的地址图片，条件是本条的编号
	   public boolean  addRw(TaskEntity tke){
		   boolean bl=false;
		   String sql="update task set TaskShancImage=? where TaskId=?";
		   Connection conn=null;
		   PreparedStatement ps=null;
		   try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,tke.getTaskShancImage());
			ps.setString(2,tke.getTaskId());
			int p=ps.executeUpdate();
			bl=p>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUitl.closeAll(null, ps, conn);
		}
		   return bl;
		   
	   }
	   
}
