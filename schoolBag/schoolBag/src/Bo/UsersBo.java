package Bo;

import java.util.List;

import Dao.UsersDao;
import Entity.UsersEntity;

public class UsersBo {
		/**
		 * 登录  输入账号密码   判断是否存在该用户*/
		public boolean login(UsersEntity user) throws Exception{
			return new UsersDao().login(user);
		}
		
		/**
		 * 注册  账号密码昵称地区phone*/
		public boolean regist(UsersEntity user) throws Exception{
			return new UsersDao().regist(user);
		}
		
		/**查询  输入账号   判断是否存在该用户*/
		public String login(String userId) throws Exception{
			return new UsersDao().login(userId);
		}
		/**更新用户密码*/
		public boolean update(String userId,String userPwd) throws Exception{
			return new UsersDao().update(userId, userPwd);
		}
		/**查询用户详细信息*/
		public UsersEntity SelUsers(String usersId) throws Exception{
			return new UsersDao().SelUsers(usersId);
		}
		
		/**地址转换*/
		public String toAddress(int addressId) throws Exception{	
			return new UsersDao().toAddress(addressId);
		}
		/**删除users 根据userid*/
		public boolean deleteUsers(int userid){
			return new UsersDao().deleteUsers(userid);
		}
		/**模糊查询  根据指定条件查询 +分页    执行存储过程 u_c
		 * i:第几页
		 * row:每页几行
		 * add:筛选条件
		 * */
		public List<UsersEntity> SelUsers(int i,int row,String add) throws Exception{
			return new UsersDao().SelUsers(i, row, add);
		}
		/**查询当前数据库的总页数*/
		public int getCount(int row){
			return new UsersDao().getCount(row);
		}
		/**更新users*/
		public boolean UpdUsers(String add,String obj,String userid){
			return new UsersDao().UpdUsers(add, obj, userid);
		}
		/**更新用户积分*/
		public boolean UpdUserInt(String userid,int userint){
			return new UsersDao().UpdUserInt(userid, userint);
		}
}
