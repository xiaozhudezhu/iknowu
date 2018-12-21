package com.swinginwind.iknowu.pager;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.swinginwind.core.pager.Page;
import com.swinginwind.iknowu.model.Resource;

public class ResourcePager extends Page<Resource> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 提问开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	
	/**
	 * 提问结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	
	/**
	 * 提问用户ID
	 */
	private Integer createUser;
	
	/**
	 * 资源状态，1：有效；2：暂停；3：失效
	 */
	private List<String> states;
	
	/**
	 * 资源类别
	 */
	private List<String> types;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public List<String> getStates() {
		return states;
	}

	public void setStates(List<String> states) {
		this.states = states;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
