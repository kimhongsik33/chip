package com.spring.vo;

import java.util.Date;

public class MemberVO {
	private String userId;
	private String userPassword;
	private String userName;
	private String email;
	private Date registerDate;
	private Date updateDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString(){
		return "MemberVO[userId=" + userId + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", email=" + email
				+ ", registerDate" + registerDate + ", updateDate=" + updateDate
				+ ", getUserId()=" + getUserId() + ", getUserPassword()=" + getUserPassword()
				+ ", getUserName()=" + getUserName() + ", getEmail()=" + getEmail()
				+ ", getRegisterDate()=" + getRegisterDate() + ", getUpdateDate()=" + getUpdateDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
