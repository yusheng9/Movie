package com.shixun.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shixun.entity.MovieFilm;
import com.shixun.entity.MovieUser;
import com.shixun.entity.Type;
import com.shixun.mapper.SecondTypeMapper;
import com.shixun.service.FilmService;
import com.shixun.service.SecondTypeService;
import com.shixun.service.TypeService;
import com.shixun.service.UserService;
import com.shixun.utils.RandomValidateCode;

/**
 * 一级类型控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/movie")
public class FilmController {

	@Resource
	private FilmService filmService;
	@Resource
	private SecondTypeService secondTypeService;
	
	@RequestMapping(value = "/selectFilm")
	@ResponseBody
	public List<MovieFilm> selectFilm() {
		List<MovieFilm> list=filmService.selectMovie();
		System.out.println(list);

		return list;
		
	}
	
	/**
	 * 电影列表页面
	 * @return
	 */
	@RequestMapping(value = "/movielist")
	public String movielist(Model model) {
		List<MovieFilm> list=filmService.selectMovie();
		System.out.println(list);
		model.addAttribute("list", list);
		return "backstage/movie_list";
	}
	/**
	 * 电影添加页面
	 * @return
	 */
	@RequestMapping(value = "/movieadd")
	public String movieadd(Model model) {
		List<SecondTypeMapper> list=secondTypeService.selectSecondType();
		model.addAttribute("type", list);
		return "backstage/movie_add";
	}
	
}
