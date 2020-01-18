package com.shixun.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.shixun.entity.Type;
import com.shixun.mapper.SecondTypeMapper;
import com.shixun.service.SecondTypeService;
import com.shixun.service.TypeService;


/**
 * 一级类型控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping()
public class TypeController {

	@Resource
	private TypeService typeService;
	@Resource
	private SecondTypeService secondTypeService;
	
	@RequestMapping(value = "/selectType")
	public String selectType() {
		System.out.println(123);
		List<Type> list=typeService.selectType();
		System.out.println(list);

		return null;
		
	}
	@RequestMapping(value = "/selectSecondType")
	public String selectSecondType() {
		System.out.println(123);
		List<SecondTypeMapper> list=secondTypeService.selectSecondType();
		System.out.println(list);

		return null;
		
	}
	
}
