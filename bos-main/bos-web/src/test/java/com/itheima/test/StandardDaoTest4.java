package com.itheima.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.bos.dao.base.StandardDao;
import com.itheima.bos.domain.base.Standard;
/**
 * 演示PagingAndSortingRepository接口的用法
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StandardDaoTest4 {

	@Resource
	private StandardDao standardDao;
	
	/**
	 * 排序 - 1个
	 */
	@Test
	public void test1(){
		//需求：按照id倒序
		//Sort对象，spring data jpa提供的封装排序规则的对象
		// order by id desc
		Sort sort = new Sort(  new Order(Direction.DESC,"id") );
		
		List<Standard> list = (List<Standard>)standardDao.findAll(sort);
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}
	
	/**
	 * 排序 - 多个
	 */
	@Test
	public void test2(){
		//需求：按照id倒序
		//Sort对象，spring data jpa提供的封装排序规则的对象
		// order by id desc
		Sort sort = new Sort(  new Order(Direction.DESC,"id"), new Order(Direction.ASC,"minWeight") );
		
		List<Standard> list = (List<Standard>)standardDao.findAll(sort);
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}
	
	/**
	 * 分页
	 */
	@Test
	public void test3(){
		//Pageable: spring data jpa提供的用于封装前台的分页条件（当前页码，页面大小，排序条件）
		int page = 1; // 当前页码索引，从0开始，代表0是第一页
		int pageSize = 2;//页面大小
		Pageable pageable = new PageRequest(page,pageSize);
		
		//Page: spring data jpa提供的用于封装后台数据的查询结果
		Page<Standard> pageBean = standardDao.findAll(pageable);
	
		System.out.println(pageBean.getTotalElements());// 总记录数
		//当前页数据列表
		List<Standard> list = pageBean.getContent();
		for (Standard standard : list) {
			System.out.println(standard);
		}
		System.out.println(pageBean.getTotalPages());//总页数
	}
	
}
