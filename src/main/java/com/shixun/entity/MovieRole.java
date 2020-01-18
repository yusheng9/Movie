package com.shixun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 	角色实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "movie_role")
public class MovieRole {
	//角色ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	//角色名称
	@Column(length = 255)
	private String roleName;
	//创建时间
	@Column(length = 255)
	private String createTime;
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "MovieRole [roleId=" + roleId + ", roleName=" + roleName + ", createTime=" + createTime + "]";
	}
	
	
	
	
}
