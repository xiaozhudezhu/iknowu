package com.swinginwind.iknowu.service;

import com.swinginwind.iknowu.model.SysUser;

public interface SysUserService {
	
	public SysUser checkLogin(SysUser user);
	
	public void register(SysUser user) throws Exception;

}
