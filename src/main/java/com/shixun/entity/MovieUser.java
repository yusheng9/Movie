package com.shixun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "movie_user")
public class MovieUser {
	//用户ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	//用户名
	@Column(length = 255)
	private String userName;
	//密码
	@Column(length = 255)
	private String userPassword;
	//真实姓名
	@Column(length = 255)
	private String userRealname;
	//身份证号码
	@Column(length = 255)
	private String userIdcard;
	//手机号码
	@Column(length = 255)
	private String userPhone;
	//头像
	@Column(length = 255)
	private String userHeadimg;
	//性别
	@Column(length = 255)
	private String userSex;
	//生日
	@Column(length = 255)
	private String userBirthday;
	//个人简介
	@Column(length = 255)
	private String userIntro;
	//QQ账号
	@Column(length = 255)
	private String userQq;
	//电子邮箱
	@Column(length = 255)
	private String userEmail;
	//省份
	@Column(length = 255)
	private String province;
	//市
	@Column(length = 255)
	private String city;
	//区/县
	@Column(length = 255)
	private String district;
	//状态
	private int userStatus;
	//注册时间
	@Column(length = 255)
	private String createTime;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRealname() {
		return userRealname;
	}
	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}
	public String getUserIdcard() {
		return userIdcard;
	}
	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserHeadimg() {
		return userHeadimg;
	}
	public void setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	public String getUserQq() {
		return userQq;
	}
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "MovieUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userRealname=" + userRealname + ", userIdcard=" + userIdcard + ", userPhone=" + userPhone
				+ ", userHeadimg=" + userHeadimg + ", userSex=" + userSex + ", userBirthday=" + userBirthday
				+ ", userIntro=" + userIntro + ", userQq=" + userQq + ", userEmail=" + userEmail + ", province="
				+ province + ", city=" + city + ", district=" + district + ", userStatus=" + userStatus
				+ ", createTime=" + createTime + "]";
	}
	
	
	
}
