package com.shixun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shixun.entity.MovieFilm;
import com.shixun.entity.Type;
import com.shixun.mapper.MovieFilmMapper;
import com.shixun.mapper.TypeMapper;
import com.shixun.service.FilmService;
import com.shixun.service.TypeService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class FilmServiceImpl implements FilmService {
	
	//注入MovieFilmMapper
	@Resource
	private MovieFilmMapper movieFilmMapper;

	@Override
	public List<MovieFilm> selectMovie() {
		// TODO Auto-generated method stub
		return movieFilmMapper.selectMovie();
	}




}
