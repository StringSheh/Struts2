package com.itheima.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.bos.dao.base.StandardDao;
import com.itheima.bos.domain.base.Standard;
/**
 * 演示CrudRepository接口的用法
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StandardDaoTest3 {

	@Resource
	private StandardDao standardDao;
	
	/**
	 * 添加
	 */
	@Test
	public void test1(){
		Standard s = new Standard();
		s.setName("30-40斤");
		standardDao.save(s);
	}
	
	/**
	 * 更新
	 */
	@Test
	public void test2(){
		Standard s = new Standard();
		s.setId(4L);
		s.setName("40-50斤");
		standardDao.save(s);
	}
	
	/**
	 * 查询所有
	 */
	@Test
	public void test3(){
		//必须进行类型转换
		List<Standard> list = (List<Standard>)standardDao.findAll();
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}
	
	/**
	 * 查询一个
	 */
	@Test
	public void test4(){
		Standard standard = standardDao.findOne(3L);
		System.out.println(standard);
	}
	
	/**
	 * 删除
	 */
	@Test
	public void test5(){
		standardDao.delete(4L);
	}
	
}
