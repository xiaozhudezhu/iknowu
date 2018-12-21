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
import com.swinginwind.iknowu.model.BaseOrder;
import com.swinginwind.iknowu.model.SysUser;
import com.swinginwind.iknowu.pager.BaseOrderPager;
import com.swinginwind.iknowu.service.BaseOrderService;

@Controller
@RequestMapping("order")
public class BaseOrderController {
	
	@Autowired
	BaseOrderService orderService;
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse create(@RequestBody BaseOrder order, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		orderService.insert(order);
		res.setMsg("create success!");
		res.put("order", order);
		return res;
	}
	
	@RequestMapping("search")
	@ResponseBody
	public JqgridResponse<BaseOrder> search(@RequestBody BaseOrderPager pager) {
		orderService.select(pager);
		JqgridResponse<BaseOrder> res = new JqgridResponse<BaseOrder>(pager);
		return res;
	}
	
	@RequestMapping(value = "answer", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse answer(@RequestBody BaseOrder order, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		if(user != null)
			order.setAnswerUser(user.getId());
		orderService.answer(order);
		res.setMsg("answer success!");
		return res;
	}
	
	@RequestMapping(value = "evaluate", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse evaluate(@RequestBody BaseOrder order, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		if(user != null)
			order.setAnswerUser(user.getId());
		orderService.evaluate(order);
		res.setMsg("evaluate success!");
		return res;
	}
	

}
