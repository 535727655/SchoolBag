package Entity;

import java.sql.Date;

public class UsedEntity{//���ֻ�����Ϣ��   �ṩ�������� �൱�ڷ���
	private int usedId;//��Ϣ���
	private String usedTitle;//����
	private String usedContent;//����(�������)
	private Date usedTime;//��Ϣ����ʱ��
	private String usedAddress;//-�ص������
	private String usedPhone;//-�绰����
	private String images;//-ͼƬ��ַ (��$�����������ָ�)
	public int getUsedId() {
		return usedId;
	}
	public void setUsedId(int usedId) {
		this.usedId = usedId;
	}
	public String getUsedTitle() {
		return usedTitle;
	}
	public void setUsedTitle(String usedTitle) {
		this.usedTitle = usedTitle;
	}
	public String getUsedContent() {
		return usedContent;
	}
	public void setUsedContent(String usedContent) {
		this.usedContent = usedContent;
	}
	public Date getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(Date usedTime) {
		this.usedTime = usedTime;
	}
	public String getUsedAddress() {
		return usedAddress;
	}
	public void setUsedAddress(String usedAddress) {
		this.usedAddress = usedAddress;
	}
	public String getUsedPhone() {
		return usedPhone;
	}
	public void setUsedPhone(String usedPhone) {
		this.usedPhone = usedPhone;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	
}
