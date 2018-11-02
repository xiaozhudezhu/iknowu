package com.swinginwind.iknowu.service;

import java.util.List;

import com.swinginwind.iknowu.model.BaseMaster;
import com.swinginwind.iknowu.pager.BaseMasterPager;

public interface BaseMasterService {
	
	BaseMaster selectByPrimaryKey(String tid);
	
	List<BaseMaster> select(BaseMasterPager pager);

}
