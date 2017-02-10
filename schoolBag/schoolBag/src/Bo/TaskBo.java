package Bo;
import java.util.List;

import Dao.Taskdao;
import Entity.TaskEntity;
public class TaskBo {
	//查詢全部人的帶接受任務
	public List<TaskEntity> AllTask(String add){
		return new Taskdao().MyAllTask(add);
	}
	//查询待领取的任务
//	public List<TaskEntity> UnclaimedTask(int taskRec){
//		return new Taskdao().MyUnclaimedTask(taskRec);
//	}
	//处理中的任务bo
	public List<TaskEntity> InprocessTask(String taskRec,String add){
		return new Taskdao().MyInprocessTask(taskRec,add);
	}
	//待确认的任务
	public List<TaskEntity> daiqueren(String taskRec,String add){
		return new Taskdao().daiqueren(taskRec, add);
	}
	//查询已完成的任务bo
	public List<TaskEntity> CompleteTask(String taskRec,String add){
		return new Taskdao().MyCompleteTask(taskRec,add);	
	}
	//查询取消的任务
	public List<TaskEntity> CanceledTask(String taskRec,String add){
		return new Taskdao().MyCanceledTask(taskRec,add);
	}
	////查询该序号的内容，点击标题显示
	public List<TaskEntity> MytaskIdTask(String taskId,String add){
		return new Taskdao().MytaskIdTask(taskId,add);
		
	}
	//更新状态  Task表
	public boolean  updState(int taskid,int taskstate){
		return new Taskdao().updState(taskid, taskstate);
	}	
}
