package com.shixun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shixun.entity.MovieUser;

public interface UserService {

	//查询
	List<MovieUser> selectUser();
	//删除
	int deleteUser(long userId);
	//添加用户
	int userAdd(MovieUser movieUser);
	//修改用户状态  停用
	int blockup(long userId);
	//修改用户状态  启用
	int startusing(long userId);
	//根据id查询用户信息
	MovieUser selectUserId(long userId);
	//根据id修改用户信息
	int updateUser(MovieUser movieUser);
	//根据id修改用户密码
	int updatePassword(String password,long userId);
	//根据加入时间段和用户名或手机号或电子邮箱查询用户
	List<MovieUser> selectUserLike(String createTime,String createTime2,String user);
}
