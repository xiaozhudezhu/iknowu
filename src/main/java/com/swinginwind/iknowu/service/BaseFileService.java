package com.swinginwind.iknowu.service;

import java.util.List;

import com.swinginwind.iknowu.model.BaseFile;

public interface BaseFileService {
	
	public int insertBatch(List<BaseFile> fileList);
	
	public BaseFile selectById(int id);

	int insert(BaseFile file);

	List<BaseFile> selectByRecord(String recordId, String recordType);

}
