package com.shixun.entity;

import javax.persistence.*;

/**
 * 管理员用户实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "movie_admin_user")
public class MovieAdminUser {
	//用户ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long auserId;
	//用户名
	@Column(length = 255)
	private String auserName;
	//密码
	@Column(length = 255)
	private String auserPassword;
	//手机号码
	@Column(length = 255)
	private String auserPhone;
	//性别
	@Column(length = 255)
	private String auserSex;
	//电子邮箱
	@Column(length = 255)
	private String auserEmail;
	//角色
	@ManyToOne
	@JoinColumn(name = "role_id")
	private MovieRole movieRole;
	//状态
	private int auserStatus;
	//加入时间
	@Column(length = 255)
	private String createTime;
	public long getAuserId() {
		return auserId;
	}
	public void setAuserId(long auserId) {
		this.auserId = auserId;
	}
	public String getAuserName() {
		return auserName;
	}
	public void setAuserName(String auserName) {
		this.auserName = auserName;
	}
	public String getAuserPassword() {
		return auserPassword;
	}
	public void setAuserPassword(String auserPassword) {
		this.auserPassword = auserPassword;
	}
	public String getAuserPhone() {
		return auserPhone;
	}
	public void setAuserPhone(String auserPhone) {
		this.auserPhone = auserPhone;
	}
	public String getAuserSex() {
		return auserSex;
	}
	public void setAuserSex(String auserSex) {
		this.auserSex = auserSex;
	}
	public String getAuserEmail() {
		return auserEmail;
	}
	public void setAuserEmail(String auserEmail) {
		this.auserEmail = auserEmail;
	}
	public MovieRole getMovieRole() {
		return movieRole;
	}
	public void setMovieRole(MovieRole movieRole) {
		this.movieRole = movieRole;
	}
	public int getAuserStatus() {
		return auserStatus;
	}
	public void setAuserStatus(int auserStatus) {
		this.auserStatus = auserStatus;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "MovieAdminUser [auserId=" + auserId + ", auserName=" + auserName + ", auserPassword=" + auserPassword
				+ ", auserPhone=" + auserPhone + ", auserSex=" + auserSex + ", auserEmail=" + auserEmail
				+ ", movieRole=" + movieRole + ", auserStatus=" + auserStatus + ", createTime=" + createTime + "]";
	}
	
	
	
	
		
}
