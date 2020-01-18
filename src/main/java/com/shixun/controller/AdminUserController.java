package com.shixun.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shixun.entity.MovieAdminUser;
import com.shixun.entity.MovieRole;
import com.shixun.service.AdminUserService;
import com.shixun.service.RoleService;
import com.shixun.utils.MD5Util;
/**
 * 管理员用户控制层
 * @author Y
 *
 */
@Controller
@RequestMapping(value="admin")
public class AdminUserController {
	//注入AdminUserService
	@Resource
	AdminUserService adminUserService;
	//注入RoleService
	@Resource
	RoleService roleService;
	
	/**
	 * 跳转登录页面
	 * @return
	 */
	@RequestMapping(value = "login")
	public String alogin() {
		
		return "backstage/login";
	}
	
	/**
	 * 实现登录
	 * @return
	 */
	@RequestMapping(value = "/adminLogin")
	@ResponseBody
	public int adminLogin(@RequestParam("auserName") String auserName,
			@RequestParam("userPassword") String userPassword,
			@RequestParam("code") String code,
			HttpServletRequest request) 
	{
		String passwordByMd5=MD5Util.MD5(userPassword);//密码加密md5
		MovieAdminUser adminUser=adminUserService.adminLogin(auserName, passwordByMd5);
		System.out.println(adminUser);//将对象及数据打印到控制台
		HttpSession session=request.getSession();//获取session
		String rand_code=(String) session.getAttribute("randomcode_key");//获取保存在session里面的验证码
		if(!code.toLowerCase().equals(rand_code.toLowerCase())) {//判断页面输入的验证码和后台生成的验证码是否相等
			return 1;//不相等返回1到前台做判断   相等则继续判断下面的对象
		}else if(adminUser!=null) {//判断adminUser对象是否为空  
			//不为空则表示登录成功  将当前对象保存到session中  方便后面要用到
			session.setAttribute("adminUser", adminUser);
			return 0;//不为空返回0 到前台做判断
		}else {
			return 2;//否则返回3 到前台做判断
		}
		
	}
	
	/**
	 * 后台退出功能
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.removeAttribute("adminUser");//清空session信息
		//session.invalidate();//清除 session 中的所有信息
		return "redirect:alogin";
	}
	
	/**
	 *	 管理员信息页面
	 * @return
	 */
	@RequestMapping(value = "/adminshow/{auserId}")
	public String adminShow(@PathVariable("auserId") long auserId,Model model) {
		System.out.println("进来");
		MovieAdminUser movieAdminUser=adminUserService.selectAdminId(auserId);//根据id查询管理员用户信息
		model.addAttribute("mau", movieAdminUser);
		return "backstage/admin_show";
	}
	
	/**
	 * 跳转后台首页
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String indexalogin() {
		return "backstage/index";
	}
	
	/**
	 * 欢迎页面
	 * @return
	 */
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "backstage/welcome";
	}
	
	/**
	 * 	添加管理员页面
	 * @return
	 */
	@RequestMapping(value = "/adminadd")
	public String adminAdd(Model model) {
		List<MovieRole> list=roleService.selectRoleAll();
		model.addAttribute("list", list);
		return "backstage/admin_add";
	}
	
	/**
	 * 	管理员修改页面
	 * @return
	 */
	@RequestMapping(value = "/usermodify/{auserId}")
	public String usermodify(@PathVariable("auserId") long auserId, Model model) {
		MovieAdminUser movieAdminUser=adminUserService.selectAdminId(auserId);//根据id查询管理员用户信息
		model.addAttribute("mau", movieAdminUser);
		List<MovieRole> list=roleService.selectRoleAll();//查询所有角色
		model.addAttribute("list", list);
		return "backstage/admin_modify";
	}
	
	/**
	 * 修改管理员信息
	 * @param movieUser
	 * @return
	 */
	@RequestMapping(value = "/updateAdmin")
	@ResponseBody
	public int updateAdmin(MovieAdminUser movieAdminUser) {
		int x = adminUserService.updateAdmin(movieAdminUser);
		return x;
	}
	
	/**
	 * 管理员用户列表页面
	 * @return
	 */
	@RequestMapping(value = "/adminlist")
	public String selectUser(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();//获取session
		//获取保存在session里面的对象
		MovieAdminUser adminUser=(MovieAdminUser) session.getAttribute("adminUser");
		System.out.println("用户名"+adminUser.getAuserName());
		//查询所有管理员并用List存起来
		List<MovieAdminUser> list=adminUserService.selectAdminUser(adminUser.getAuserName());
		//把list保存到model里   到前台页面遍历出来
		model.addAttribute("list", list);
		return "backstage/admin_list";//返回管理员列表页面
	}
	
	/**
	 * 管理员用户修改密码页面
	 * @return
	 */
	@RequestMapping(value = "/changeAdPassword/{auserId}")
	public String changeAdPassword(@PathVariable("auserId") long auserId, Model model) {
		System.out.println("id"+auserId);
		MovieAdminUser movieAdminUser=adminUserService.selectAdminId(auserId);//根据id查询管理员用户信息
		model.addAttribute("movieAdminUser", movieAdminUser);
		return "backstage/change_oneself_password";
	}
	
	/**
	 * 修改管理员密码
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/updatePassword/{auserId}")
	@ResponseBody
	public int updatePassword(@RequestParam("password") String password,
			@RequestParam("rawpassword") String rawpassword,
			@PathVariable("auserId") long auserId,
			HttpServletRequest request) 
	{
		HttpSession session=request.getSession();//获取session
		//获取保存在session里面的对象
		MovieAdminUser adminUser=(MovieAdminUser) session.getAttribute("adminUser");
		if(auserId==adminUser.getAuserId()) {
			String passwordMd5=MD5Util.MD5(rawpassword);
			if(passwordMd5.equals(adminUser.getAuserPassword())) {
				String passwordByMd5=MD5Util.MD5(password);
				adminUserService.updatePassword(passwordByMd5, auserId);
				session.removeAttribute("adminUser");//清空session信息
				//session.invalidate();//清除 session 中的所有信息
				return 1;
			}else {
				return 0;
			}
		}else {
			String passwordByMd5=MD5Util.MD5(password);
			adminUserService.updatePassword(passwordByMd5, auserId);
			return 1;
		}
		
	}
	
	/**
	 * 修改管理员自己的密码
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/updateRawPassword/{auserId}")
	@ResponseBody
	public int updateRawPassword(@RequestParam("password") String password,
			@RequestParam("rawpassword") String rawpassword,
			@PathVariable("auserId") long auserId) 
	{
		MovieAdminUser movieAdminUser=adminUserService.selectAdminId(auserId);//根据id查询管理员用户信息
		String passwordMd5=MD5Util.MD5(rawpassword);
		if(passwordMd5.equals(movieAdminUser.getAuserPassword())) {
			String passwordByMd5=MD5Util.MD5(password);
			adminUserService.updatePassword(passwordByMd5, auserId);
			return 1;
		}else {
			return 0;
		}
		
	}
	
	/**
	 * 停用
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/ablockup/{auserId}", method = RequestMethod.GET)
	@ResponseBody
	public int blockup(@PathVariable("auserId") long auserId) {
		int x = adminUserService.ablockup(auserId);
		return x;
	}

	/**
	 * 启用
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/astartusing/{auserId}", method = RequestMethod.GET)
	@ResponseBody
	public int astartUsing(@PathVariable("auserId") long auserId) {
		int x = adminUserService.astartusing(auserId);
		return x;
	}
	
	/**
	 * 	删除用户 
	 * @param auserId
	 * @return
	 */
	@RequestMapping(value = "/deleteaddmin/{auserId}")
	@ResponseBody
	public int deleteAdmin(@PathVariable("auserId") long auserId) {
		int x = adminUserService.deleteAdmin(auserId);
		return x;
	}

	/**
	 * 批量删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBatch(HttpServletRequest request) {
		String items = request.getParameter("ids");
		String[] item = items.split(",");
		for (int i = 0; i < item.length; i++) {
			adminUserService.deleteAdmin(Integer.parseInt(item[i]));
		}
		return "success";
	}
	
	/**
	 * 	添加管理员用户
	 * @param movieUser
	 * @return
	 */
	@RequestMapping(value = "/addAdmin")
	@ResponseBody
	public int addAdmin(MovieAdminUser movieAdminUser) {
		String passwordByMd5=MD5Util.MD5(movieAdminUser.getAuserPassword());
		movieAdminUser.setAuserPassword(passwordByMd5);
		System.out.println("加密后密码："+passwordByMd5);
		//获取当前系统时间
		Date date=new Date();
		//格式化时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);
		movieAdminUser.setCreateTime(time);
		int x = adminUserService.adminAdd(movieAdminUser);
		return x;
	}
	
	/**
	 * //根据加入时间段和用户名或手机号或电子邮箱查询用户
	 * @return
	 */
	@RequestMapping(value = "/selectAdminLike")
	public String selectAdminLike(@RequestParam("createTime") String createTime,
			@RequestParam("createTime2") String createTime2,
			@RequestParam("user") String user,Model model) 
	{
		//获取当前系统时间
		Date date=new Date();
		//格式化时间
		SimpleDateFormat sdf=new SimpleDateFormat();
		String tn=" 00:00:00";
		String ti=" 23:59:59";

        System.out.println("time:"+ti);
		List<MovieAdminUser> list = adminUserService.selectAdminLike(createTime+tn, createTime2+ti, user);
		model.addAttribute("list", list);
		return "backstage/admin_list";
	}
	
}
