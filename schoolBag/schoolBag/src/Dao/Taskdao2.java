package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import Entity.TaskEntity;

public class Taskdao2 {
	public boolean addTask(TaskEntity tke){
		boolean bl=false;//          -�������       ͼƬ                  ��������          ��������                ������               ���񷢲�ʱ��  ����ʼʱ��              �������ʱ��         ״̬                  ������
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
			ps.setString(5,tke.getTaskUserid());//������
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
	
	//�����ȡ�����뵥ǰ���˺ŵ�������Ϊ������
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
	//ȡ������
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
	   
	   //�ύ��������ύ�ĵ�ַͼƬ�������Ǳ����ı��
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
