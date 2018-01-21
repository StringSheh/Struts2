package com.itheima.web.action;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.itheima.bos.action.BaseAction;
import com.itheima.bos.utils.MailUtils;
import com.itheima.bos.utils.SmsUtils;
import com.itheima.crm.domain.Customer;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/customer")
public class CustomerAction extends BaseAction<Customer>{

	@Override
	protected Specification<Customer> buildSpecification() {
		return null;
	}
	
	/**
	 * 发送短信
	 * @throws Exception 
	 */
	@Action("sendSms")
	public void sendSms() throws Exception{
		Customer customer = this.getModel();
		
		//系统随机生成4位数字的字符串
		String validCode = RandomStringUtils.randomNumeric(4);
		
		System.out.println("验证码："+validCode);
		//调用工具类
		try {
			boolean flag = SmsUtils.sendSms(
					customer.getTelephone(), 
					"物流系统", 
					"SMS_100735040", 
					"{\"code\":\""+validCode+"\"}");
			
			if(flag){
				result.put("success", true);
			}else{
				result.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
		}
		writeJson(result);
	}
	
	/**
	 * 注册方法
	 * @throws Exception 
	 */
	@Action("regist")
	public void regist() throws Exception{
		try {
			Customer customer = this.getModel();
			
			
			String mailTitle = "BOS系统的激活邮件";
			String mailContent = "尊敬的用户，<br/>恭喜你在我们平台注册用户，请通过以下链接完成最后一步激活操作。<br>"
					+"<a href=''>激活链接</a>";
			//发送激活邮件
			MailUtils.sendMail(
					customer.getEmail(), 
					mailTitle, 
					mailContent);
			
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		writeJson(result);
	}

}
