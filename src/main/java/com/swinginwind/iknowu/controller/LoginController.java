package com.swinginwind.iknowu.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swinginwind.core.pager.JSONResponse;
import com.swinginwind.core.session.SessionService;
import com.swinginwind.core.utils.Identities;
import com.swinginwind.iknowu.model.SysUser;
import com.swinginwind.iknowu.service.SysUserService;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private SysUserService userService;
	
	@Resource(name = "wxMpService")
    private WxMpService wxMpService;
	
	@Autowired
	private SessionService sessionService;
	
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
			String loginToken = Identities.uuid();
			res.put("loginToken", loginToken);
			sessionService.setSession(loginToken, user1);
		}
			
		return res;
	}
	
	
	@RequestMapping("/wxLogin")
    @ResponseBody
    public JSONResponse wxLogin(HttpServletRequest request, @RequestParam("code") String code,
                           @RequestParam("state") String state) {
    	JSONResponse res = new JSONResponse();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        WxMpUser wxUser = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            wxUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            e.printStackTrace();
            //抛出异常 自定义的  方便处理  可自己定义    
        }
        if(wxUser != null) {
        	SysUser user;
			try {
				user = userService.wechatLogin(wxUser);
				String loginToken = Identities.uuid();
				res.put("loginToken", loginToken);
				sessionService.setSession(loginToken, user);
				res.put("user", user);
			} catch (Exception e) {
				e.printStackTrace();
				res.setStatusAndMsg(false, "注册失败！");
			}
        	
        }
        else {
        	System.out.println("WEB微信用户信息获取失败,code:" + code + ";token:" + wxMpOAuth2AccessToken );
        	res.setStatusAndMsg(false, "微信用户信息获取失败！");
        }
        return res;
    }
	
	
	@RequestMapping("register")
	@ResponseBody
	public JSONResponse register(@RequestBody SysUser user) {
		JSONResponse res = new JSONResponse();
		try {
			userService.register(user, false);
			res.setMsg("注册成功");
		} catch (Exception e) {
			res.setStatusAndMsg(false, "注册失败," + e.getMessage());
		}
		
		return res;
	}
	

}
