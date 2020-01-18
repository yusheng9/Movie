package com.shixun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shixun.entity.MovieFilm;

/**
 * 
 * @author Y
 *
 */
@Mapper
public interface MovieFilmMapper {

	List<MovieFilm> selectMovie();
}
