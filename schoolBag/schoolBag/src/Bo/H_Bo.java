package Bo;

import java.util.List;

import Dao.H_Dao;
import Entity.TaskEntity;
import Entity.UsersEntity;

public class H_Bo {
	/**��ѯtask��	 add=����  ���ط��������������б�*/
		public List<TaskEntity> SelTask(String add){
			return new H_Dao().SelTask(add);
		}
	/**����taskidɾ������task*/
		public boolean DelTask(String taskid){
			return new H_Dao().DelTask(taskid);
		}	
	/**�鿴������ϸ��Ϣ*/
		public UsersEntity SelUsers(String UserId){
			return new H_Dao().SelUsers(UserId);
		}
		
		/**ִ�д洢����   ����add������ѯ ����ҳ*/
		public List<TaskEntity> SelTask(int i, int row, String add) {
			// TODO Auto-generated method stub
			return new H_Dao().SelTask(i,row,add);
		}
		
		/**��ѯ��ǰ���ݿ����ҳ��*/
		public int getCount(int row){
			return new H_Dao().getCount(row);
		}	
		/**����Task*/
		public boolean UpdTask(String add,String obj,int taskid){
			return new H_Dao().UpdTask(add, obj, taskid);
		}		
		
}
