package com.swinginwind.iknowu.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swinginwind.iknowu.dao.BaseFileMapper;
import com.swinginwind.iknowu.model.BaseFile;
import com.swinginwind.iknowu.service.BaseFileService;

@Service
public class BaseFileServiceImpl implements BaseFileService {

	@Autowired
	private BaseFileMapper baseFileMapper;

	@Override
	public int insertBatch(List<BaseFile> fileList) {
		for (BaseFile file : fileList) {
			baseFileMapper.insert(file);
		}
		return fileList.size();
	}

	@Override
	public int insert(BaseFile file) {
		return baseFileMapper.insert(file);
	}

	@Override
	public BaseFile selectById(int id) {
		return baseFileMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BaseFile> selectByRecord(String recordId, String recordType) {
		return baseFileMapper.selectByRecord(recordId, recordType);
	}

}
