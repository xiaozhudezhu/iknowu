package com.swinginwind.iknowu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swinginwind.core.pager.JSONResponse;
import com.swinginwind.core.pager.JqgridResponse;
import com.swinginwind.iknowu.model.Resource;
import com.swinginwind.iknowu.pager.ResourcePager;
import com.swinginwind.iknowu.service.ResourceService;

@Controller
@RequestMapping("resource")
public class ResourceController {
	
	@Autowired
	ResourceService resService;
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse create(@RequestBody Resource resource, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		resService.insert(resource);
		res.setMsg("create success!");
		res.put("resource", resource);
		return res;
	}
	
	@RequestMapping("search")
	@ResponseBody
	public JqgridResponse<Resource> search(@RequestBody ResourcePager pager) {
		resService.select(pager);
		JqgridResponse<Resource> res = new JqgridResponse<Resource>(pager);
		return res;
	}

}
