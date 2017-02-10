package Entity;

import java.sql.Date;

public class HistoryEntity {//记录表  记录用户对任务执行的操作
	private int taskId;//任务编号
	private String userId;//用户编号
	private Date time;//时间
	private int state;//执行的操作(0:接收 1:完成 2:取消 3:发布)
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
