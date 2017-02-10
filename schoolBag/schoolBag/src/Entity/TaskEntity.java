package Entity;

import java.util.Date;

public class TaskEntity { //任务表
	private String taskId;//任务编号
	private String taskTitle;//任务标题
	private String taskImage;//主题图片地址
	private String TaskShancImage;//上传的图片
	private String taskType;//任务类型 Fk_type(typeid)
	private String taskContent;//任务内容
	private String taskUserid;//发布人
	private Date taskTime;//任务发布时间
	private Date taskBeginTime;//任务开始时间
	private Date taskEndTime;//任务结束时间
	private Date taskFinishTime;//任务完成时间
	private int taskState;//状态  (0:待接收   1:处理中  2:处理完成  3:取消)
	private String taskMoney;//任务奖励(物质或者钱等)
	private String taskRec;//-接收人 Fk_tu users(user)
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
