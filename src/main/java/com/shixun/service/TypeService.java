package com.shixun.service;

import java.util.List;

import com.shixun.entity.MovieUser;
import com.shixun.entity.Type;

public interface TypeService {

	//查询所有类型
	List<Type> selectType();
}
