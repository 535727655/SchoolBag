package Entity;

import java.sql.Date;

public class HistoryEntity {//��¼��  ��¼�û�������ִ�еĲ���
	private int taskId;//������
	private String userId;//�û����
	private Date time;//ʱ��
	private int state;//ִ�еĲ���(0:���� 1:��� 2:ȡ�� 3:����)
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
