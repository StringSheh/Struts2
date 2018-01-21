package com.itheima.bos.service.base.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.base.FixedAreaDao;
import com.itheima.bos.domain.base.FixedArea;
import com.itheima.bos.service.base.FixedAreaService;
import com.itheima.bos.service.impl.BaseServiceImpl;

@Service
@Transactional  //事务做在业务层
public class FixedAreaServiceImpl extends BaseServiceImpl<FixedArea> implements FixedAreaService {
	
	//注入dao
	private FixedAreaDao fixedAreaDao;
	
	@Resource
	public void setFixedAreaDao(FixedAreaDao fixedAreaDao) {
		this.fixedAreaDao = fixedAreaDao;
		//把FixedAreaDao赋值给baseDao
		super.setBaseDao(fixedAreaDao);
	}
	
}
