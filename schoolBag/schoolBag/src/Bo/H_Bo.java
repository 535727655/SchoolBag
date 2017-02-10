package Bo;

import java.util.List;

import Dao.H_Dao;
import Entity.TaskEntity;
import Entity.UsersEntity;

public class H_Bo {
	/**查询task表	 add=条件  返回符合条件的任务列表*/
		public List<TaskEntity> SelTask(String add){
			return new H_Dao().SelTask(add);
		}
	/**根据taskid删除此条task*/
		public boolean DelTask(String taskid){
			return new H_Dao().DelTask(taskid);
		}	
	/**查看个人详细信息*/
		public UsersEntity SelUsers(String UserId){
			return new H_Dao().SelUsers(UserId);
		}
		
		/**执行存储过程   根据add条件查询 并分页*/
		public List<TaskEntity> SelTask(int i, int row, String add) {
			// TODO Auto-generated method stub
			return new H_Dao().SelTask(i,row,add);
		}
		
		/**查询当前数据库的总页数*/
		public int getCount(int row){
			return new H_Dao().getCount(row);
		}	
		/**更新Task*/
		public boolean UpdTask(String add,String obj,int taskid){
			return new H_Dao().UpdTask(add, obj, taskid);
		}		
		
}
