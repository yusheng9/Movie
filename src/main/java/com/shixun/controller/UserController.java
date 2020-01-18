package com.shixun.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shixun.entity.MovieUser;
import com.shixun.service.UserService;
import com.shixun.utils.MD5Util;
import com.shixun.utils.RandomValidateCode;

/**
 * 用户控制层
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	UserService userService;

	/**
	 * 用户列表页面
	 * @return
	 */
	@RequestMapping(value = "/userlist")
	public String selectUser(Model model) {
		List<MovieUser> list = userService.selectUser();
		model.addAttribute("list", list);
		return "backstage/user_list";
	}

	/**
	 * 用户添加页面
	 * @return
	 */
	@RequestMapping(value = "/useradd")
	public String useradd() {
		return "backstage/user_add";
	}

	/**
	 * 用户修改页面
	 * @return
	 */
	@RequestMapping(value = "/usermodify/{userId}")
	public String usermodify(@PathVariable("userId") long userId, Model model) {
		System.out.println(userId);
		MovieUser movieUser=userService.selectUserId(userId);//根据id查询用户信息
		model.addAttribute("movieUser", movieUser);
		return "backstage/user_modify";
	}
	
	/**
	 * 用户信息页面
	 * @return
	 */
	@RequestMapping(value = "/usershow/{userId}")
	public String userShow(@PathVariable("userId") long userId, Model model) {
		MovieUser movieUser=userService.selectUserId(userId);//根据id查询用户信息
		model.addAttribute("movieUser", movieUser);
		return "backstage/user_show";
	}
	
	/**
	 * 用户修改密码页面
	 * @return
	 */
	@RequestMapping(value = "/changePassword/{userId}")
	public String changePassword(@PathVariable("userId") long userId, Model model) {
		MovieUser movieUser=userService.selectUserId(userId);//根据id查询用户信息
		model.addAttribute("movieUser", movieUser);
		return "backstage/change_password";
	}

	/**
	 * 	添加用户
	 * @param movieUser
	 * @return
	 */
	@RequestMapping(value = "/addUser")
	@ResponseBody
	public int addUser(MovieUser movieUser) {
		String passwordByMd5=MD5Util.MD5(movieUser.getUserPassword());
		movieUser.setUserPassword(passwordByMd5);
		System.out.println("加密后密码："+passwordByMd5);
		//获取当前系统时间
		Date date=new Date();
		//格式化时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);
		movieUser.setCreateTime(time);
		int x = userService.userAdd(movieUser);
		return x;
	}
	
	/**
	 * 修改用户信息
	 * @param movieUser
	 * @return
	 */
	@RequestMapping(value = "/updateUser")
	@ResponseBody
	public int updateUser(MovieUser movieUser) {;
		int x = userService.updateUser(movieUser);
		return x;
	}

	/**
	 * 删除用户 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/deleteuser/{userId}")
	@ResponseBody
	public int deleteUser(@PathVariable("userId") long userId) {
		int x = userService.deleteUser(userId);
		return x;
	}

	/**
	 * 批量删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delBatch", method = RequestMethod.POST)
	@ResponseBody
	public String delBatch(HttpServletRequest request) {
		String items = request.getParameter("ids");
		String[] item = items.split(",");
		for (int i = 0; i < item.length; i++) {
			userService.deleteUser(Integer.parseInt(item[i]));
		}
		return "success";
	}

	/**
	 * 停用
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/blockup/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public int blockup(@PathVariable("userId") long userId) {
		int x = userService.blockup(userId);
		return x;
	}

	/**
	 * 启用
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/startusing/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public int startUsing(@PathVariable("userId") long userId) {
		int x = userService.startusing(userId);
		return x;
	}
	
	/**
	 * 修改用户密码
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/updatePassword/{userId}")
	@ResponseBody
	public int updatePassword(@RequestParam("password") String password,
			@PathVariable("userId") long userId) 
	{
		String passwordByMd5=MD5Util.MD5(password);
		int x = userService.updatePassword(passwordByMd5, userId);
		System.out.println(x);
		return x;
	}
	
	/**
	 * //根据加入时间段和用户名或手机号或电子邮箱查询用户
	 * @return
	 */
	@RequestMapping(value = "/selectUserLike")
	public String selectUserLike(@RequestParam("createTime") String createTime,
			@RequestParam("createTime2") String createTime2,
			@RequestParam("user") String user,Model model) 
	{
		System.out.println("111"+createTime);
		List<MovieUser> list = userService.selectUserLike(createTime, createTime2, user);
		model.addAttribute("list", list);
		return "backstage/user_list";
	}


	/**
	 * 获取生成验证码显示到 UI界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkCode")
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置相应类型,告诉浏览器输出的内容为图片
		response.setContentType("image/jpeg");
		// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		try {
			randomValidateCode.getRandcode(request, response);// 输出图片方法
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
