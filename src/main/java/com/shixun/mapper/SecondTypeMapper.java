package com.shixun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author Administrator
 *
 */
@Mapper
public interface SecondTypeMapper {
	//查询类型
	List<SecondTypeMapper> selectSecondType();
}
