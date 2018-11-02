package com.swinginwind.iknowu.pager;

import com.swinginwind.core.pager.Page;
import com.swinginwind.iknowu.model.BaseMaster;

public class BaseMasterPager extends Page<BaseMaster> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2594610780445156482L;


	private String mastername;
	
	private String newTecher;
	
	private String popTecher;
	
	
	public String getMastername() {
		return mastername;
	}

	public void setMastername(String mastername) {
		this.mastername = mastername;
	}

	public String getNewTecher() {
		return newTecher;
	}

	public void setNewTecher(String newTecher) {
		this.newTecher = newTecher;
	}

	public String getPopTecher() {
		return popTecher;
	}

	public void setPopTecher(String popTecher) {
		this.popTecher = popTecher;
	}
	

}
