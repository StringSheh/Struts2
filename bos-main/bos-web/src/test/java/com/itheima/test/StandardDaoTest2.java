package com.itheima.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.base.StandardDao;
import com.itheima.bos.domain.base.Standard;
/**
 * 演示Repository接口的用法
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StandardDaoTest2 {

	@Resource
	private StandardDao standardDao;
	
	@Test
	public void test1(){
		List<Standard> list = standardDao.findByNameIs("10-20斤");
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}
	@Test
	public void test2(){
		List<Standard> list = standardDao.findByNameAndMinWeight("10-20斤", 10L);
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}
	
	@Test
	public void test3(){
		//模糊通配符： % : 任意个字符  _: 一个字符
		List<Standard> list = standardDao.findByNameLike("%斤%");
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}
	
	@Test
	public void test4(){
		List<Standard> list = standardDao.findName("10-20斤");
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void test5(){
		standardDao.updateMinLength(400L, 2L);
	}
	
}
