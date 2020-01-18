package com.shixun.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 二级类型实体
 * @author Y
 *
 */
@Entity
@Table(name = "secondtype")
public class Secondtype {

	//二级类型ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stId;
	//二级类型名称
	@Column(length = 255)
	private String stName;
	//一级类型实体
	@ManyToOne
	@JoinColumn(name = "type_id")
	private Type type;
	public long getStId() {
		return stId;
	}
	public void setStId(long stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Secondtype [stId=" + stId + ", stName=" + stName + ", type=" + type + "]";
	}
	
	

	
	
}
