package Entity;

import java.util.Date;

public class TaskEntity { //�����
	private String taskId;//������
	private String taskTitle;//�������
	private String taskImage;//����ͼƬ��ַ
	private String TaskShancImage;//�ϴ���ͼƬ
	private String taskType;//�������� Fk_type(typeid)
	private String taskContent;//��������
	private String taskUserid;//������
	private Date taskTime;//���񷢲�ʱ��
	private Date taskBeginTime;//����ʼʱ��
	private Date taskEndTime;//�������ʱ��
	private Date taskFinishTime;//�������ʱ��
	private int taskState;//״̬  (0:������   1:������  2:�������  3:ȡ��)
	private String taskMoney;//������(���ʻ���Ǯ��)
	private String taskRec;//-������ Fk_tu users(user)
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskImage() {
		return taskImage;
	}
	public void setTaskImage(String taskImage) {
		this.taskImage = taskImage;
	}
	public String getTaskShancImage() {
		return TaskShancImage;
	}
	public void setTaskShancImage(String taskShancImage) {
		TaskShancImage = taskShancImage;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	public String getTaskUserid() {
		return taskUserid;
	}
	public void setTaskUserid(String taskUserid) {
		this.taskUserid = taskUserid;
	}
	public Date getTaskTime() {
		return taskTime;
	}
	public void setTaskTime(Date taskTime) {
		this.taskTime = taskTime;
	}
	public Date getTaskBeginTime() {
		return taskBeginTime;
	}
	public void setTaskBeginTime(Date taskBeginTime) {
		this.taskBeginTime = taskBeginTime;
	}
	public Date getTaskEndTime() {
		return taskEndTime;
	}
	public void setTaskEndTime(Date taskEndTime) {
		this.taskEndTime = taskEndTime;
	}
	public Date getTaskFinishTime() {
		return taskFinishTime;
	}
	public void setTaskFinishTime(Date taskFinishTime) {
		this.taskFinishTime = taskFinishTime;
	}
	public int getTaskState() {
		return taskState;
	}
	public void setTaskState(int taskState) {
		this.taskState = taskState;
	}
	public String getTaskMoney() {
		return taskMoney;
	}
	public void setTaskMoney(String taskMoney) {
		this.taskMoney = taskMoney;
	}
	public String getTaskRec() {
		return taskRec;
	}
	public void setTaskRec(String taskRec) {
		this.taskRec = taskRec;
	}
	
}
