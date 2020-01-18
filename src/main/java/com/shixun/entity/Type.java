package com.shixun.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 	一级类型实体
 * @author Y
 *
 */
@Entity
@Table(name = "type")
public class Type {
	//一级类型ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long typeId;
	//一级类型名称
	@Column(length = 255)
	private String typeName;
	
	
	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
