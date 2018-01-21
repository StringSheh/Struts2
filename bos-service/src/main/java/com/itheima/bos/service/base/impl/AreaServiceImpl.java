package com.itheima.bos.service.base.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.base.AreaDao;
import com.itheima.bos.domain.base.Area;
import com.itheima.bos.service.base.AreaService;
import com.itheima.bos.service.impl.BaseServiceImpl;

@Service
@Transactional  //事务做在业务层
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService {
	
	//注入dao
	private AreaDao areaDao;
	
	@Resource
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
		//把AreaDao赋值给baseDao
		super.setBaseDao(areaDao);
	}
	
}
