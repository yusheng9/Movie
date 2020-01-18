package com.shixun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shixun.entity.Type;
import com.shixun.mapper.TypeMapper;
import com.shixun.service.TypeService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class TypeServiceImpl implements TypeService {
	
	//注入MovieUser
	@Resource
	private TypeMapper typeMapper;

	//查询所有类型
	public List<Type> selectType() {
		// TODO Auto-generated method stub
		return typeMapper.selectType();
	}



	//查询所有类型

}
