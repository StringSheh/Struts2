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
import com.itheima.bos.domain.base.FixedArea;
import com.itheima.bos.domain.base.Standard;
import com.itheima.bos.service.base.FixedAreaService;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/fixedArea")
public class FixedAreaAction extends BaseAction<FixedArea> {

	private FixedAreaService fixedAreaService;

	@Resource
	public void setFixedAreaService(FixedAreaService fixedAreaService) {
		this.fixedAreaService = fixedAreaService;
		// 给BaseAction的baseService赋值
		super.setBaseService(fixedAreaService);
	}

	@Override
	protected Specification<FixedArea> buildSpecification() {
		final FixedArea model = this.getModel();
		// 创建Specification对象
		Specification<FixedArea> spec = new Specification<FixedArea>() {

			@Override
			public Predicate toPredicate(Root<FixedArea> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> preList = new ArrayList<Predicate>();

				
				
				Predicate[] preArray = new Predicate[preList.size()];
				return cb.and(preList.toArray(preArray));
			}
		};
		return spec;
	}

}
