package com.itheima.bos.web.base.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.itheima.bos.action.BaseAction;
import com.itheima.bos.domain.base.Standard;
import com.itheima.bos.service.base.StandardService;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/standard")
public class StandardAction extends BaseAction<Standard> {

	private StandardService standardService;

	@Resource
	public void setStandardService(StandardService standardService) {
		this.standardService = standardService;
		// 给BaseAction的baseService赋值
		super.setBaseService(standardService);
	}

	@Override
	protected Specification<Standard> buildSpecification() {
		final Standard model = this.getModel();
		// 创建Specification对象
		Specification<Standard> spec = new Specification<Standard>() {

			@Override
			public Predicate toPredicate(Root<Standard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> preList = new ArrayList<Predicate>();

				// 名称
				if (model.getName() != null && !model.getName().trim().equals("")) {
					// .as(String.class): 因为like查询必须是字符串类型的查询，所以必须强制声明为String类型
					preList.add(cb.like(root.get("name").as(String.class), "%" + model.getName() + "%"));
				}

				// 最小重量
				if (model.getMinWeight() != null) {
					preList.add(cb.equal(root.get("minWeight"), model.getMinWeight()));
				}

				// 最小长度
				if (model.getMinLength() != null) {
					preList.add(cb.equal(root.get("minLength"), model.getMinLength()));
				}

				Predicate[] preArray = new Predicate[preList.size()];
				return cb.and(preList.toArray(preArray));
			}
		};
		return spec;
	}

}
