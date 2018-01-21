package com.itheima.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.bos.dao.base.StandardDao;
import com.itheima.bos.domain.base.Standard;

/**
 * 演示JPASpecificationExecutor接口的用法
 * 
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StandardDaoTest6 {

	@Resource
	private StandardDao standardDao;

	/**
	 * 组合条件查询 - 1个
	 */
	@Test
	public void test1() {
		// 模拟用户表单name
		final String name = "";

		// Specification: spring data jpa提供的用于封装组合条件的对象
		// Specification，这是接口，开发者提供Specification接口的实现类，通常匿名内部类
		Specification<Standard> spec = new Specification<Standard>() {

			/**
			 * Predicate: 用于封装查询条件的对象 ( where name = ? ) root: 根对象，代表当前查询的实体对象
			 * 例如 Standard 用于查询对象的属性 query： 拼接简单的条件，用法比较麻烦 类似 Hibernate的Criteria
			 * （一般不同） cb： 用于直接构建查询条件 > >= < <= = like cb的方法返回Predicate
			 */
			// select * from t_stadard s where s.name = ?
			@Override
			public Predicate toPredicate(Root<Standard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 完成组合条件的拼装
				Predicate pre = null;
				// 需求：查询name为10-20斤 where name = ?
				if (name != null && !name.equals("")) {
					// where name = ?
					pre = cb.equal(root.get("name"), name);
				}
				return pre;
			}
		};

		List<Standard> list = standardDao.findAll(spec);
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}

	/**
	 * 组合条件查询 - 多个
	 */
	@Test
	public void test2() {
		//模拟用户填写的条件    where name = ? and minWeight = ?
		final String name = "";
		final Long minWeight = 10L;

		Specification<Standard> spec = new Specification<Standard>() {
			@Override
			public Predicate toPredicate(Root<Standard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> preList = new ArrayList<Predicate>();
				
				//名称
				if(name!=null && !name.equals("")){
					preList.add(  cb.equal(root.get("name"), name)  );
				}
				
				//最小重量
				if(minWeight!=null){
					preList.add(  cb.equal(root.get("minWeight"), minWeight)  );
				}
				
				Predicate[] preArray = new Predicate[preList.size()];
				return cb.and(preList.toArray(preArray));
			}
		};

		List<Standard> list = standardDao.findAll(spec);
		for (Standard standard : list) {
			System.out.println(standard);
		}
	}

}
