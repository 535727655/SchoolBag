package Entity;

import java.util.Date;

public class Imformation {
	private int ImfoId;//��ϢID
	private String ImfoRec;//--��Ϣ������ ���users(userid)
	private int Imfostate;//--��Ϣ״̬   1�Ѷ�  0δ��   2ɾ��
	private Date Imfotime;//--����ʱ�� Ĭ�ϵ�ǰʱ��
	private Date dispoTime;//--����ʱ��
	private String Content;//--����  ��������Ϣ
	private int taskId;//--�й������� ��� task(taskid)
	private String Imfouserid;//������
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
