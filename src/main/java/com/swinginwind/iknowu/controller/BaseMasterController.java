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

@Controller
@RequestMapping("master")
public class BaseMasterController {
	
	@Autowired
	BaseMasterService baseMasterService;
	
	@RequestMapping("search")
	@ResponseBody
	public JqgridResponse<BaseMaster> search(@RequestBody BaseMasterPager pager) {
		baseMasterService.select(pager);
		JqgridResponse<BaseMaster> res = new JqgridResponse<BaseMaster>(pager);
		return res;
	}
	

}
