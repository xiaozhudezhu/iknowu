package com.swinginwind.iknowu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swinginwind.core.utils.Identities;
import com.swinginwind.iknowu.dao.BaseFileMapper;
import com.swinginwind.iknowu.dao.BaseOrderMapper;
import com.swinginwind.iknowu.model.BaseFile;
import com.swinginwind.iknowu.model.BaseOrder;
import com.swinginwind.iknowu.pager.BaseOrderPager;
import com.swinginwind.iknowu.service.BaseOrderService;

@Service
public class BaseOrderServiceImpl implements BaseOrderService {
	
	@Autowired
	private BaseOrderMapper orderMapper;
	
	@Autowired
	private BaseFileMapper fileMapper;

	@Override
	public int insert(BaseOrder order) {
		order.setDate(new Date());
		order.setOid(Identities.uuid());
		order.setState("0");
		if(order.getFilesQuestion() != null && order.getFilesQuestion().size() > 0) {
			for(int i = 0; i < order.getFilesQuestion().size(); i ++) {
				BaseFile file = order.getFilesQuestion().get(i);
				file.setSortCode(i + 1);
				file.setRecordType("ORDER_Q");
				file.setRecordId(order.getOid());
				fileMapper.updateByPrimaryKeySelective(file);
			}
		}
		return orderMapper.insert(order);
	}

	@Override
	public List<BaseOrder> select(BaseOrderPager pager) {
		List<BaseOrder> orderList = orderMapper.select(pager);
		if(orderList != null && orderList.size() > 0) {
			for(BaseOrder order : orderList) {
				order.setFilesQuestion(fileMapper.selectByRecord(order.getOid(), "ORDER_Q"));
				order.setFilesAnswer(fileMapper.selectByRecord(order.getOid(), "ORDER_A"));
			}
		}
		return orderList;
	}
	
	
	@Override
	public int answer(BaseOrder order) {
		BaseOrder orderNew = new BaseOrder();
		orderNew.setOid(order.getOid());
		orderNew.setAnswerUser(order.getAnswerUser());
		orderNew.setDeldate(new Date());
		orderNew.setDelprocess(order.getDelprocess());
		orderNew.setState("1");
		if(order.getFilesAnswer() != null && order.getFilesAnswer().size() > 0) {
			for(int i = 0; i < order.getFilesAnswer().size(); i ++) {
				BaseFile file = order.getFilesAnswer().get(i);
				file.setSortCode(i + 1);
				file.setRecordType("ORDER_A");
				file.setRecordId(order.getOid());
				fileMapper.updateByPrimaryKeySelective(file);
			}
		}
		
		return orderMapper.updateByPrimaryKeySelective(orderNew);
	}
	
	@Override
	public int evaluate(BaseOrder order) {
		BaseOrder orderNew = new BaseOrder();
		orderNew.setOid(order.getOid());
		orderNew.setCusContent(order.getCusContent());
		orderNew.setCusResult(order.getCusResult());
		orderNew.setState("2");
		return orderMapper.updateByPrimaryKeySelective(orderNew);
	}
	
	

}
