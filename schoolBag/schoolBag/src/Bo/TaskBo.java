package Bo;
import java.util.List;

import Dao.Taskdao;
import Entity.TaskEntity;
public class TaskBo {
	//��ԃȫ���˵Ď������΄�
	public List<TaskEntity> AllTask(String add){
		return new Taskdao().MyAllTask(add);
	}
	//��ѯ����ȡ������
//	public List<TaskEntity> UnclaimedTask(int taskRec){
//		return new Taskdao().MyUnclaimedTask(taskRec);
//	}
	//�����е�����bo
	public List<TaskEntity> InprocessTask(String taskRec,String add){
		return new Taskdao().MyInprocessTask(taskRec,add);
	}
	//��ȷ�ϵ�����
	public List<TaskEntity> daiqueren(String taskRec,String add){
		return new Taskdao().daiqueren(taskRec, add);
	}
	//��ѯ����ɵ�����bo
	public List<TaskEntity> CompleteTask(String taskRec,String add){
		return new Taskdao().MyCompleteTask(taskRec,add);	
	}
	//��ѯȡ��������
	public List<TaskEntity> CanceledTask(String taskRec,String add){
		return new Taskdao().MyCanceledTask(taskRec,add);
	}
	////��ѯ����ŵ����ݣ����������ʾ
	public List<TaskEntity> MytaskIdTask(String taskId,String add){
		return new Taskdao().MytaskIdTask(taskId,add);
		
	}
	//����״̬  Task��
	public boolean  updState(int taskid,int taskstate){
		return new Taskdao().updState(taskid, taskstate);
	}	
}
