package com.shixun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shixun.entity.MovieUser;

/**
 * user  Mapper接口层
 * @author Administrator
 *
 */
@Mapper
public interface MovieUserMapper {

	//查询
	List<MovieUser> selectUser();
	//删除
	int deleteUser(@Param("userId") long userId);
	//添加用户
	int userAdd(@Param("movieUser") MovieUser movieUser);
	//修改用户状态  停用
	int blockup(@Param("userId") long userId);
	//修改用户状态  启用
	int startusing(@Param("userId") long userId);
	//根据id查询用户信息
	MovieUser selectUserId(@Param("userId") long userId);
	//根据id修改用户信息
	int updateUser(@Param("movieUser") MovieUser movieUser);
	//根据id修改用户密码
	int updatePassword(@Param("password") String password,@Param("userId") long userId);
	//根据加入时间段和用户名或手机号或电子邮箱查询用户
	List<MovieUser> selectUserLike(
			@Param("createTime") String createTime,
			@Param("createTime2") String createTime2,
			@Param("user") String user
	);
}
