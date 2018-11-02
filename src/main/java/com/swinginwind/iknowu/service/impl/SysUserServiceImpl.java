package com.swinginwind.iknowu.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swinginwind.blockchain.util.Web3jUtil;
import com.swinginwind.core.utils.MD5Util;
import com.swinginwind.iknowu.dao.BaseMasterMapper;
import com.swinginwind.iknowu.dao.SysUserMapper;
import com.swinginwind.iknowu.model.SysUser;
import com.swinginwind.iknowu.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private BaseMasterMapper masterMapper;

	@Autowired
	private Web3jUtil web3jUtil;

	@Override
	public SysUser checkLogin(SysUser user) {
		user.setPwd(MD5Util.encrypt(user.getPwd()));
		user = userMapper.checkLogin(user);
		if(user != null) {
			user.setMasterInfo(masterMapper.selectByUserId(user.getId()));
		}
		return user;
	}

	@Override
	public void register(SysUser user) throws Exception {
		user.setWalletPwd(user.getPwd());
		user.setPwd(MD5Util.encrypt(user.getPwd()));
		user.setStatus("1");
		user.setCreateTime(new Date());
		String account = web3jUtil.newAccount(user.getWalletPwd());
		user.setWalletAccount(account);
		//初始化余额
		web3jUtil.sendUFOTransaction(web3jUtil.getAdminAccount(), account, web3jUtil.getAdminPwd(),
				web3jUtil.getUserInitBalance());
		userMapper.insert(user);
	}

}
