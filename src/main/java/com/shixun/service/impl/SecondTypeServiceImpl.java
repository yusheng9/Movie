package com.shixun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shixun.entity.Type;
import com.shixun.mapper.SecondTypeMapper;
import com.shixun.mapper.TypeMapper;
import com.shixun.service.SecondTypeService;
import com.shixun.service.TypeService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class SecondTypeServiceImpl implements SecondTypeService {
	
	//注入MovieUser
	@Resource
	private SecondTypeMapper secondtypeMapper;

	//查询类型
	public List<SecondTypeMapper> selectSecondType() {
		// TODO Auto-generated method stub
		return secondtypeMapper.selectSecondType();
	}


}
