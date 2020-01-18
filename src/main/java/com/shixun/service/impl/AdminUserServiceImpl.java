package com.shixun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.shixun.entity.MovieAdminUser;
import com.shixun.entity.MovieUser;
import com.shixun.mapper.MovieAdminUserMapper;
import com.shixun.service.AdminUserService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	//注入MovieUser
	@Resource
	private MovieAdminUserMapper movieAdminUserMapper;

	//查询管理员用户
	public List<MovieAdminUser> selectAdminUser(String aname) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.selectAdminUser(aname);
	}

	//管理员用户登录
	public MovieAdminUser adminLogin(String auserName, String auserPassword) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.adminLogin(auserName, auserPassword);
	}
	
	//修改管理员用户状态  停用
	public int ablockup(long auserId) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.ablockup(auserId);
	}

	//修改管理员用户状态  启用
	public int astartusing(long auserId) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.astartusing(auserId);
	}

	//根据id查询管理员用户信息
	public MovieAdminUser selectAdminId(long auserId) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.selectAdminId(auserId);
	}

	//根据id修改管理员用户信息
	public int updateAdmin(MovieAdminUser movieAdminUser) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.updateAdmin(movieAdminUser);
	}

	//根据id修改管理员用户密码
	public int updatePassword(String password, long auserId) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.updatePassword(password, auserId);
	}
	
	//删除管理员用户
	public int deleteAdmin(long auserId) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.deleteAdmin(auserId);
	}

	//添加管理员用户
	public int adminAdd(MovieAdminUser movieAdminUser) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.adminAdd(movieAdminUser);
	}

	//根据加入时间段和用户名或手机号或电子邮箱查询管理员用户
	public List<MovieAdminUser> selectAdminLike(String createTime, String createTime2, String user) {
		// TODO Auto-generated method stub
		return movieAdminUserMapper.selectAdminLike(createTime, createTime2, user);
	}




}
