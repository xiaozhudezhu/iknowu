package com.swinginwind.iknowu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swinginwind.iknowu.dao.BaseMasterMapper;
import com.swinginwind.iknowu.model.BaseMaster;
import com.swinginwind.iknowu.pager.BaseMasterPager;
import com.swinginwind.iknowu.service.BaseMasterService;

@Service
public class BaseMasterServiceImpl implements BaseMasterService {
	
	@Autowired
	private BaseMasterMapper baseMasterMapper;

	@Override
	public BaseMaster selectByPrimaryKey(String tid) {
		// TODO Auto-generated method stub
		return baseMasterMapper.selectByPrimaryKey(tid);
	}

	@Override
	public List<BaseMaster> select(BaseMasterPager pager) {
		// TODO Auto-generated method stub
		return baseMasterMapper.select(pager);
	}

}
