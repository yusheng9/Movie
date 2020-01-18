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
@RequestMapping(value = "/")
public class IndexController {
	
	/**
	 * 进入网站首页
	 */
	@RequestMapping(value = "/")
	public String index() {;
		
		return "frontdesk/index";
	}
	
}
