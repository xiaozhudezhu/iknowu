package com.swinginwind.iknowu.service;

import java.util.List;

import com.swinginwind.iknowu.model.BaseOrder;
import com.swinginwind.iknowu.pager.BaseOrderPager;

public interface BaseOrderService {
	
	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	public int insert(BaseOrder order);
	
	/**
	 * 搜索
	 * @param pager
	 * @return
	 */
	public List<BaseOrder> select(BaseOrderPager pager);
	
	/**
	 * 回答
	 * @param order
	 * @return
	 */
	public int answer(BaseOrder order);

	/**
	 * 客户评价
	 * @param order
	 * @return
	 */
	public int evaluate(BaseOrder order);

	

}
