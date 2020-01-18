package com.shixun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shixun.entity.MovieAdminUser;
import com.shixun.entity.MovieUser;
/**
 * 
 * @author Administrator
 *
 */
@Mapper
public interface MovieAdminUserMapper {

	//查询管理员用户
	List<MovieAdminUser> selectAdminUser(@Param("aname") String aname);
	//管理员登录
	MovieAdminUser adminLogin(@Param("auserName") String auserName,
			@Param("auserPassword") String auserPassword);
	//修改用户状态  停用
	int ablockup(@Param("auserId") long auserId);
	//修改用户状态  启用
	int astartusing(@Param("auserId") long auserId);
	//根据id查管理员询用户信息
	MovieAdminUser selectAdminId(@Param("auserId") long auserId);
	//根据id修改管理员用户信息
	int updateAdmin(@Param("movieAdminUser") MovieAdminUser movieAdminUser);
	//根据id修改管理员用户密码
	int updatePassword(@Param("password") String password,@Param("auserId") long auserId);
	//删除
	int deleteAdmin(@Param("auserId") long auserId);
	//添加用户
	int adminAdd(@Param("movieAdminUser") MovieAdminUser movieAdminUser);
	//根据加入时间段和用户名或手机号或电子邮箱查询管理员用户
	List<MovieAdminUser> selectAdminLike(
			@Param("createTime") String createTime,
			@Param("createTime2") String createTime2,
			@Param("user") String user
	);
}
