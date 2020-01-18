package com.shixun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shixun.entity.Type;



/**
 * type dao层
 * @author Y
 *
 */
@Mapper
public interface TypeMapper {

	//查询所有类型
	List<Type> selectType();
}
