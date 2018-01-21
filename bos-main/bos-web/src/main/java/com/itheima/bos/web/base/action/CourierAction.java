package com.itheima.bos.web.base.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.itheima.bos.action.BaseAction;
import com.itheima.bos.domain.base.Courier;
import com.itheima.bos.domain.base.Standard;
import com.itheima.bos.service.base.CourierService;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/courier")
public class CourierAction extends BaseAction<Courier> {

	private CourierService courierService;

	@Resource
	public void setCourierService(CourierService courierService) {
		this.courierService = courierService;
		// 给BaseAction的baseService赋值
		super.setBaseService(courierService);
	}

	@Override
	protected Specification<Courier> buildSpecification() {
		final Courier model = this.getModel();
		// 创建Specification对象
		Specification<Courier> spec = new Specification<Courier>() {

			@Override
			public Predicate toPredicate(Root<Courier> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> preList = new ArrayList<Predicate>();

				//工号
				if(model.getCourierNum()!=null && !model.getCourierNum().trim().equals("")){
					preList.add( cb.like(root.get("courierNum").as(String.class), "%"+model.getCourierNum()+"%")  );
				}
				
				//姓名
				if(model.getName()!=null && !model.getName().trim().equals("")){
					preList.add( cb.like(root.get("name").as(String.class), "%"+model.getName()+"%")  );
				}
				
				//电话
				if(model.getTelephone()!=null && !model.getTelephone().trim().equals("")){
					preList.add( cb.like(root.get("telephone").as(String.class), "%"+model.getTelephone()+"%")  );
				}
				
				//取派标准
				if(model.getStandard()!=null && model.getStandard().getId()!=null){
					//多表查询  
					//sql: select * from t_courier c inner join t_standard s on s.id=c.standard_id where s.id=?
					Join<Courier, Standard> join = root.join("standard", JoinType.INNER);
					preList.add(  cb.equal(  join.get("id"), model.getStandard().getId()  )  );
				}
				
				Predicate[] preArray = new Predicate[preList.size()];
				return cb.and(preList.toArray(preArray));
			}
		};
		return spec;
	}

}
