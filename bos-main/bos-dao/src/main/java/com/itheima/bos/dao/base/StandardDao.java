package com.itheima.bos.dao.base;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.itheima.bos.dao.BaseDao;
import com.itheima.bos.domain.base.Standard;
/**
 * 泛型一：当前操作的实体类类型
 * 泛型二：实体类的OID类型
 * @author lenovo
 *
 */
public interface StandardDao extends BaseDao<Standard>{
	
	//一、1）基于方法命名规则匹配查询
	//需求：查询name为“10-20斤”的数据
	public List<Standard> findByNameIs(String name);
	
	public List<Standard> findByNameAndMinWeight(String name,Long minWeigtht);
	
	public List<Standard> findByNameLike(String name);
	
	@Query("from Standard where name = ?")
	public List<Standard> findName(String name);
	
	@Query("update Standard set minLength = ? where id = ?")
	@Modifying
	public void updateMinLength(Long minLength,Long id);
	
}
