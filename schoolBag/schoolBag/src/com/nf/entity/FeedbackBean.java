package com.nf.entity;

import java.sql.Date;

public class FeedbackBean{
	private int fbId;//���
	private String usId;//�û���
	private Date fbTime;//ʱ��
	private String fbContent;//��������
	private String fbImages;//ͼƬ
	private String fblianxi; //��ϵ��ʽ
	private int fbStatu;//״̬
	public int getFbId() {
		return fbId;
	}
	public void setFbId(int fbId) {
		this.fbId = fbId;
	}
	public String getUsId() {
		return usId;
	}
	public void setUsId(String usId) {
		this.usId = usId;
	}
	public Date getFbTime() {
		return fbTime;
	}
	public void setFbTime(Date fbTime) {
		this.fbTime = fbTime;
	}
	public String getFbContent() {
		return fbContent;
	}
	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}
	public String getFbImages() {
		return fbImages;
	}
	public void setFbImages(String fbImages) {
		this.fbImages = fbImages;
	}
	public String getFblianxi() {
		return fblianxi;
	}
	public void setFblianxi(String fblianxi) {
		this.fblianxi = fblianxi;
	}
	public int getFbStatu() {
		return fbStatu;
	}
	public void setFbStatu(int fbStatu) {
		this.fbStatu = fbStatu;
	}
	
	
}