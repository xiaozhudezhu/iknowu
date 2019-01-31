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
import com.swinginwind.iknowu.model.OrderDialog;
import com.swinginwind.iknowu.pager.BaseOrderPager;
import com.swinginwind.iknowu.service.BaseOrderService;
import com.swinginwind.iknowu.service.SysUserService;

@Controller
@RequestMapping("order")
public class BaseOrderController {
	
	@Autowired
	BaseOrderService orderService;
	
	@Autowired
	private SysUserService userService;
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse create(@RequestBody BaseOrder order, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		orderService.insert(order);
		res.setMsg("create success!");
		res.put("order", order);
		return res;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse delete(@RequestBody BaseOrder order, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		if(userService.isAdmin() || userService.getCurrentUser().getId().equals(order.getCreateUser())) {
			orderService.delete(order);
			res.setMsg("delete success!");
		}
		else {
			res.setStatusAndMsg(false, "非法操作！");
		}
		return res;
	}
	
	@RequestMapping("search")
	@ResponseBody
	public JqgridResponse<BaseOrder> search(@RequestBody BaseOrderPager pager) {
		orderService.select(pager);
		JqgridResponse<BaseOrder> res = new JqgridResponse<BaseOrder>(pager);
		return res;
	}
	
	@Deprecated
	@RequestMapping(value = "answer", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse answer(@RequestBody BaseOrder order, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		orderService.answer(order);
		res.setMsg("answer success!");
		return res;
	}
	
	@RequestMapping(value = "dialog", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse dialog(@RequestBody OrderDialog dialog, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		orderService.dialog(dialog);
		res.setMsg("dialog success!");
		return res;
	}
	
	@RequestMapping(value = "delDialog", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse delDialog(@RequestBody OrderDialog dialog, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		dialog = orderService.selectDialogById(dialog.getId());
		if(userService.isAdmin() || userService.getCurrentUser().getId().equals(dialog.getCreateUser())) {
			orderService.delDialog(dialog);
			res.setMsg("delete success!");
		}
		else {
			res.setStatusAndMsg(false, "非法操作！");
		}
		
		return res;
	}
	
	@RequestMapping(value = "evaluate", method = RequestMethod.POST)
	@ResponseBody
	public JSONResponse evaluate(@RequestBody BaseOrder order, HttpServletRequest request) {
		JSONResponse res = new JSONResponse();
		orderService.evaluate(order);
		res.setMsg("evaluate success!");
		return res;
	}
	

}
