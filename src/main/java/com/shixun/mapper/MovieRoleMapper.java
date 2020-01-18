package com.shixun.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shixun.entity.MovieRole;

/**
 * role  Mapper接口层
 * @author Administrator
 *
 */
@Mapper
public interface MovieRoleMapper {

	//查询所有角色
	List<MovieRole> selectRoleAll();

}
