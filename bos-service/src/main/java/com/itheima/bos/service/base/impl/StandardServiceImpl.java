package com.itheima.bos.service.base.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.base.StandardDao;
import com.itheima.bos.domain.base.Standard;
import com.itheima.bos.service.base.StandardService;
import com.itheima.bos.service.impl.BaseServiceImpl;

@Service
@Transactional  //事务做在业务层
public class StandardServiceImpl extends BaseServiceImpl<Standard> implements StandardService {
	
	//注入dao
	private StandardDao standardDao;
	
	@Resource
	public void setStandardDao(StandardDao standardDao) {
		this.standardDao = standardDao;
		//把StandardDao赋值给baseDao
		super.setBaseDao(standardDao);
	}
	
}
