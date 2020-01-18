package com.shixun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shixun.entity.MovieRole;
import com.shixun.mapper.MovieRoleMapper;
import com.shixun.service.RoleService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	//注入RoleMapper
	@Resource
	private MovieRoleMapper roleMapper;

	//查询所有角色
	public List<MovieRole> selectRoleAll() {
		// TODO Auto-generated method stub
		return roleMapper.selectRoleAll();
	}


}
