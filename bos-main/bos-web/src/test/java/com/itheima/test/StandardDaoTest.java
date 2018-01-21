package com.itheima.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.base.StandardDao;
import com.itheima.bos.domain.base.Standard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StandardDaoTest {

	@Resource
	private StandardDao standardDao;
	
	@Test
	@Transactional // 事务管理
	@Rollback(false) //取消自动回滚
	public void test1(){
		Standard s= new Standard();
		s.setName("20-30斤");
		s.setMinWeight(10L);
		s.setMaxWeight(20L);
		s.setMinLength(300L);
		s.setMaxLength(500L);
		standardDao.save(s);
	}
	
	@Test
	public void test2(){
		System.out.println(standardDao.getClass());
	}
}
