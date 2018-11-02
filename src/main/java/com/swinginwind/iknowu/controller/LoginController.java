package com.swinginwind.iknowu.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swinginwind.core.pager.JSONResponse;
import com.swinginwind.core.spring.mvc.bind.annotation.RequestJsonParam;
import com.swinginwind.iknowu.model.SysUser;
import com.swinginwind.iknowu.service.SysUserService;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private SysUserService userService;
	
	@RequestMapping("login")
	@ResponseBody
	public JSONResponse login(@RequestBody SysUser user, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		SysUser user1 = userService.checkLogin(user);
		if(user1 == null) {
			res.setStatusAndMsg(false, "用户名或密码错误");
		}
		else {
			res.put("user", user1);
			request.getSession().setAttribute("user", user1);
		}
			
		return res;
	}
	
	
	@RequestMapping("register")
	@ResponseBody
	public JSONResponse register(SysUser user) {
		JSONResponse res = new JSONResponse();
		try {
			userService.register(user);
		} catch (Exception e) {
			res.setStatusAndMsg(false, "注册失败");
		}
		res.setMsg("注册成功");
		return res;
	}
	

}
