package Entity;

import java.util.Date;

public class UsersEntity {//�û���
	private String userId;//�û��˺�
	private String userPwd;//�û�����
	private int AddressId;//��ַ���
	private String userName;//�û�����(�ǳ�
	private String phone;//�ֻ�����
	private int userInt;//����(���������)
	private Date time;//ע��ʱ��
	private String touxiang;
	public String getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int addressId) {
		AddressId = addressId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserInt() {
		return userInt;
	}
	public void setUserInt(int userInt) {
		this.userInt = userInt;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public UsersEntity(String userId, String userPwd, int addressId,
			String userName, String phone, int userInt, Date time) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		AddressId = addressId;
		this.userName = userName;
		this.phone = phone;
		this.userInt = userInt;
		this.time = time;
	}
	public UsersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
