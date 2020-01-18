package com.shixun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shixun.entity.MovieRole;
import com.shixun.service.RoleService;


/**
 * 一级类型控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping()
public class RoleController {

	@Resource
	RoleService roleService;
	
	@RequestMapping(value = "/selectRole")
	public String roleType() {;
		List<MovieRole> list=roleService.selectRoleAll();
		System.out.println(list);

		return null;
		
	}
	
}
