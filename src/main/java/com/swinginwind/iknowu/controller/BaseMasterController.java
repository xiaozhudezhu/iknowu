package com.swinginwind.iknowu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swinginwind.core.pager.JSONResponse;
import com.swinginwind.core.pager.JqgridResponse;
import com.swinginwind.iknowu.model.BaseMaster;
import com.swinginwind.iknowu.pager.BaseMasterPager;
import com.swinginwind.iknowu.service.BaseMasterService;
import com.swinginwind.iknowu.service.SysUserService;

@Controller
@RequestMapping("master")
public class BaseMasterController {
	
	@Autowired
	BaseMasterService baseMasterService;
	
	@Autowired
	private SysUserService userService;
	
	@RequestMapping("search")
	@ResponseBody
	public JqgridResponse<BaseMaster> search(@RequestBody BaseMasterPager pager) {
		baseMasterService.select(pager);
		JqgridResponse<BaseMaster> res = new JqgridResponse<BaseMaster>(pager);
		return res;
	}
	
	@RequestMapping("searchAll")
	@ResponseBody
	public JqgridResponse<BaseMaster> searchAll(@RequestBody BaseMasterPager pager) {
		baseMasterService.selectAll(pager);
		JqgridResponse<BaseMaster> res = new JqgridResponse<BaseMaster>(pager);
		return res;
	}
	
	@RequestMapping("register")
	@ResponseBody
	public JSONResponse register(@RequestBody BaseMaster master) {
		JSONResponse res = new JSONResponse();
		master = baseMasterService.register(master);
		res.put("master", master);
		return res;
	}
	
	@RequestMapping("getRegInfo")
	@ResponseBody
	public JSONResponse getRegInfo(@RequestBody BaseMaster master) {
		JSONResponse res = new JSONResponse();
		if(master == null || master.getUserId() == null) {
			master = baseMasterService.getRegInfo();
			res.put("master", master);
		}
		else {
			if(userService.isAdmin() || userService.getCurrentUser().getId().equals(master.getUserId())) {
				master = baseMasterService.getRegInfo(master.getUserId());
				res.put("master", master);
			}
			else {
				res.setStatusAndMsg(false, "非法操作！");
			}
		}
		return res;
	}
	
	@RequestMapping("audit")
	@ResponseBody
	public JSONResponse audit(@RequestBody BaseMaster master) {
		JSONResponse res = new JSONResponse();
		if(userService.isAdmin()) {
			baseMasterService.audit(master);
			res.setMsg("审核成功！");
		}
		else {
			res.setStatusAndMsg(false, "非法操作！");
		}
		return res;
	}
	
	

}
