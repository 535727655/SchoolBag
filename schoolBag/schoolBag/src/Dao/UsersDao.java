package Dao;

import Entity.UsersEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
	
	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
	//ע��  �˺������ǳƵ���phone
	public boolean regist(UsersEntity user) throws Exception{
		boolean bl=false;
		String sql="insert into users values(?,?,?,?,?,0,null,default)";
		try{
			conn=DBCon.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1,user.getUserId());
			ps.setString(2,user.getUserPwd());
			ps.setInt(3,user.getAddressId());
			ps.setString(4,user.getUserName());
			ps.setString(5,user.getPhone());
			bl=ps.executeUpdate()>0;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBCon.closeAll(ps, rs, conn);
		}
		return bl;
	}
	
	//��¼  �����˺�����   �ж��Ƿ���ڸ��û�
	public boolean login(UsersEntity user) throws Exception{
		boolean bl=false;
		String sql="select count(*) from users where userid='"+user.getUserId()+"' and userPwd='"+user.getUserPwd()+"'";
		try{
			conn=DBCon.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
				bl=rs.getInt(1)>0;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBCon.closeAll(ps, rs, conn);
		}
		return bl;
	}
	//��ѯ  �����˺�   �ж��Ƿ���ڸ��û� �������ֻ�����
		public String login(String usersId) throws Exception{
			String bl=null;
			String sql="select * from users where userid='"+usersId+"'";
			try{
				conn=DBCon.getCon();
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					bl=rs.getString("phone");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBCon.closeAll(ps, rs, conn);
			}
			return bl;
		}
		
		
		//�����û�����
		public boolean update(String userId,String userPwd) throws Exception{
			boolean bl=false;
			String sql="update users set userpwd=? where userid=?";
			try{
				conn=DBCon.getCon();
				ps=conn.prepareStatement(sql);
				ps.setString(1, userPwd);
				ps.setString(2, userId);
				bl=ps.executeUpdate()>0;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBCon.closeAll(ps, null, conn);
			}
			return bl;
		}
		
		
		
		//��ѯ�û���ϸ��Ϣ
		public UsersEntity SelUsers(String usersId) throws Exception{
			UsersEntity user=new UsersEntity();
			String sql="select * from users where userid='"+usersId+"'";
			try{
				conn=DBCon.getCon();
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					user.setAddressId(rs.getInt("addressId"));
					user.setPhone(rs.getString("phone"));
					user.setTime(new java.util.Date(rs.getTimestamp("time").getTime()));
					user.setUserId(rs.getString("userId"));
					user.setUserInt(rs.getInt("userInt"));
					user.setUserName(rs.getString("userName"));
					user.setUserPwd(rs.getString("userPwd"));
					user.setTouxiang(rs.getString("touxiang"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBCon.closeAll(ps, rs, conn);
			}
			return user;
		}
		
		
		//��ַת��
		public String toAddress(int addressId) throws Exception{
			String addressname=null;
			String sql="select * from address where address='"+addressId+"'";
			try{
				conn=DBCon.getCon();
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					addressname=rs.getString("addressname");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBCon.closeAll(ps, rs, conn);
			}
			return addressname;
		}
		//ɾ��users ����userid
		public boolean deleteUsers(int userid){
			String sql="delete users where userid='"+userid+"'";
			boolean bl=false;
			Connection conn=null;
			PreparedStatement ps= null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				bl=ps.executeUpdate()>0;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUitl.closeAll(null,ps, conn);
			}
			return bl;
		}
		//ģ����ѯ  ����ָ��������ѯ +��ҳ    ִ�д洢���� u_c
		public List<UsersEntity> SelUsers(int i,int row,String add) throws Exception{
			List<UsersEntity> ls=new ArrayList<UsersEntity>();
			String sql="{call u_c(?,?,?)}";
			CallableStatement cs=null;
			try{
				conn=DBCon.getCon();
				cs=conn.prepareCall(sql);
				cs.setInt(1,i);
				cs.setInt(2,row);
				cs.setString(3,add);
				if(cs.execute()){
					rs=cs.getResultSet();
					while(rs.next()){
						UsersEntity user=new UsersEntity();
						user.setAddressId(rs.getInt("addressId"));
						user.setPhone(rs.getString("phone"));
						user.setTime(new java.util.Date(rs.getTimestamp("time").getTime()));
						user.setUserId(rs.getString("userId"));
						user.setUserInt(rs.getInt("userInt"));
						user.setUserName(rs.getString("userName"));
						user.setUserPwd(rs.getString("userPwd"));
						ls.add(user);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBCon.closeAll(cs, rs, conn);
			}
			return ls;
		}
		
		//��ѯ��ǰ���ݿ����ҳ��
		public int getCount(int row){
			int i=0;
			String sql="select count(*) from users";
			Connection conn=null;
			PreparedStatement ps= null;
			ResultSet rs=null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					if(rs.getInt(1)%row>0)
						i=rs.getInt(1)/row+1;
					else
						i=rs.getInt(1)/row;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUitl.closeAll(null,ps, conn);
			}
			return i;
		}
		
		
		//����users
		public boolean UpdUsers(String add,String obj,String userid){
			boolean bl=false;
			String sql="update users set "+add+"='"+obj+"' where userid='"+userid+"'";
			Connection conn=null;
			PreparedStatement ps= null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				bl=ps.executeUpdate()>0;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUitl.closeAll(null,ps, conn);
			}
			return bl;
		}
		
		
		//�����û�����
		public boolean UpdUserInt(String userid,int userint){
			boolean bl=false;
			String sql="update users set userint += "+userint+"where userid='"+userid+"'";
			Connection conn=null;
			PreparedStatement ps= null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				bl=ps.executeUpdate()>0;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUitl.closeAll(null,ps, conn);
			}
			return bl;
		}
}
