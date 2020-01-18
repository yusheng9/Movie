package com.shixun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.shixun.entity.MovieUser;
import com.shixun.mapper.MovieUserMapper;
import com.shixun.service.UserService;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	//注入MovieUser
	@Resource
	private MovieUserMapper movieUserMapper;

	//查询
	public List<MovieUser> selectUser() {
		// TODO Auto-generated method stub
		return movieUserMapper.selectUser();
	}

	//删除
	public int deleteUser(long userId) {
		// TODO Auto-generated method stub
		return movieUserMapper.deleteUser(userId);
	}

	//添加用户
	public int userAdd(MovieUser movieUser) {
		// TODO Auto-generated method stub
		return movieUserMapper.userAdd(movieUser);
	}

	//修改用户状态  停用
	public int blockup(long userId) {
		// TODO Auto-generated method stub
		return movieUserMapper.blockup(userId);
	}

	//修改用户状态  启用
	public int startusing(long userId) {
		// TODO Auto-generated method stub
		return movieUserMapper.startusing(userId);
	}

	//根据id查询用户信息
	public MovieUser selectUserId(long userId) {
		// TODO Auto-generated method stub
		return movieUserMapper.selectUserId(userId);
	}

	//根据id修改用户信息
	public int updateUser(MovieUser movieUser) {
		// TODO Auto-generated method stub
		return movieUserMapper.updateUser(movieUser);
	}

	//根据id修改用户密码
	public int updatePassword(String password, long userId) {
		// TODO Auto-generated method stub
		return movieUserMapper.updatePassword(password, userId);
	}

	//根据加入时间段和用户名或手机号或电子邮箱查询用户
	public List<MovieUser> selectUserLike(String createTime, String createTime2, String user) {
		// TODO Auto-generated method stub
		return movieUserMapper.selectUserLike(createTime, createTime2, user);
	}


}
