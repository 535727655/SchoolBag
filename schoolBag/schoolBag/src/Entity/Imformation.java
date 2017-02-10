package Entity;

import java.util.Date;

public class Imformation {
	private int ImfoId;//消息ID
	private String ImfoRec;//--消息接收人 外键users(userid)
	private int Imfostate;//--消息状态   1已读  0未读   2删除
	private Date Imfotime;//--发送时间 默认当前时间
	private Date dispoTime;//--处理时间
	private String Content;//--内容  附带的消息
	private int taskId;//--有关任务编号 外键 task(taskid)
	private String Imfouserid;//发布人
	public String getImfouserid() {
		return Imfouserid;
	}
	public void setImfouserid(String imfouserid) {
		Imfouserid = imfouserid;
	}
	public int getImfoId() {
		return ImfoId;
	}
	public void setImfoId(int imfoId) {
		ImfoId = imfoId;
	}
	public String getImfoRec() {
		return ImfoRec;
	}
	public void setImfoRec(String imfoRec) {
		ImfoRec = imfoRec;
	}
	public int getImfostate() {
		return Imfostate;
	}
	public void setImfostate(int imfostate) {
		Imfostate = imfostate;
	}
	public Date getImfotime() {
		return Imfotime;
	}
	public void setImfotime(Date imfotime) {
		Imfotime = imfotime;
	}
	public Date getDispoTime() {
		return dispoTime;
	}
	public void setDispoTime(Date dispoTime) {
		this.dispoTime = dispoTime;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
}
