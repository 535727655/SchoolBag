package Bo;

import java.util.List;

import Dao.UsersDao;
import Entity.UsersEntity;

public class UsersBo {
		/**
		 * ��¼  �����˺�����   �ж��Ƿ���ڸ��û�*/
		public boolean login(UsersEntity user) throws Exception{
			return new UsersDao().login(user);
		}
		
		/**
		 * ע��  �˺������ǳƵ���phone*/
		public boolean regist(UsersEntity user) throws Exception{
			return new UsersDao().regist(user);
		}
		
		/**��ѯ  �����˺�   �ж��Ƿ���ڸ��û�*/
		public String login(String userId) throws Exception{
			return new UsersDao().login(userId);
		}
		/**�����û�����*/
		public boolean update(String userId,String userPwd) throws Exception{
			return new UsersDao().update(userId, userPwd);
		}
		/**��ѯ�û���ϸ��Ϣ*/
		public UsersEntity SelUsers(String usersId) throws Exception{
			return new UsersDao().SelUsers(usersId);
		}
		
		/**��ַת��*/
		public String toAddress(int addressId) throws Exception{	
			return new UsersDao().toAddress(addressId);
		}
		/**ɾ��users ����userid*/
		public boolean deleteUsers(int userid){
			return new UsersDao().deleteUsers(userid);
		}
		/**ģ����ѯ  ����ָ��������ѯ +��ҳ    ִ�д洢���� u_c
		 * i:�ڼ�ҳ
		 * row:ÿҳ����
		 * add:ɸѡ����
		 * */
		public List<UsersEntity> SelUsers(int i,int row,String add) throws Exception{
			return new UsersDao().SelUsers(i, row, add);
		}
		/**��ѯ��ǰ���ݿ����ҳ��*/
		public int getCount(int row){
			return new UsersDao().getCount(row);
		}
		/**����users*/
		public boolean UpdUsers(String add,String obj,String userid){
			return new UsersDao().UpdUsers(add, obj, userid);
		}
		/**�����û�����*/
		public boolean UpdUserInt(String userid,int userint){
			return new UsersDao().UpdUserInt(userid, userint);
		}
}
