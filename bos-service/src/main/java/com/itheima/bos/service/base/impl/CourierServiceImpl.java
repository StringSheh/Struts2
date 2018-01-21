package com.itheima.bos.service.base.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.base.CourierDao;
import com.itheima.bos.domain.base.Courier;
import com.itheima.bos.service.base.CourierService;
import com.itheima.bos.service.impl.BaseServiceImpl;

@Service
@Transactional  //事务做在业务层
public class CourierServiceImpl extends BaseServiceImpl<Courier> implements CourierService {
	
	//注入dao
	private CourierDao courierDao;
	
	@Resource
	public void setCourierDao(CourierDao courierDao) {
		this.courierDao = courierDao;
		//把CourierDao赋值给baseDao
		super.setBaseDao(courierDao);
	}
	
}
