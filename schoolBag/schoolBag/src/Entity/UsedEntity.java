package Entity;

import java.sql.Date;

public class UsedEntity{//二手货物信息表   提供线上宣传 相当于发帖
	private int usedId;//信息编号
	private String usedTitle;//标题
	private String usedContent;//内容(具体介绍)
	private Date usedTime;//信息发布时间
	private String usedAddress;//-地点或面议
	private String usedPhone;//-电话号码
	private String images;//-图片地址 (以$符隔开用来分割)
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
