package com.shixun.service;

import java.util.List;

import com.shixun.entity.MovieRole;

public interface RoleService {

	//查询所有角色
	List<MovieRole> selectRoleAll();
}
