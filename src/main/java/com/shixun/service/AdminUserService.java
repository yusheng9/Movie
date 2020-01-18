package com.shixun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shixun.entity.MovieAdminUser;
import com.shixun.entity.MovieUser;

public interface AdminUserService {

	//查询所有管理员用户
	List<MovieAdminUser> selectAdminUser(String aname);
	//管理员登录
	MovieAdminUser adminLogin(String auserName,String auserPassword);
	//修改管理员用户状态  停用
	int ablockup(long userId);
	//修改管理员用户状态  启用
	int astartusing(long userId);
	//根据id查管理员询用户信息
	MovieAdminUser selectAdminId(long auserId);
	//根据id修改管理员用户信息
	int updateAdmin(MovieAdminUser movieAdminUser);
	//根据id修改管理员用户密码
	int updatePassword(String password,long auserId);
	//删除
	int deleteAdmin(@Param("auserId") long auserId);
	//添加用户
	int adminAdd(@Param("movieAdminUser") MovieAdminUser movieAdminUser);
	//根据加入时间段和用户名或手机号或电子邮箱查询管理员用户
	List<MovieAdminUser> selectAdminLike(String createTime,String createTime2,String user);
}
