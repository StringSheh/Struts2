package com.itheima.web.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/user")
public class UserAction extends ActionSupport{

	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 登录方法
	 */
	@Action(value="login",results={
			@Result(name="success",location="/index.jsp",type="redirect"),
			@Result(name="error",location="/error.jsp",type="dispatcher")
	})
	public String login(){
		
		//1.获取Subject
		Subject subject = SecurityUtils.getSubject();
		
		//封装用户的数据
		AuthenticationToken token = new UsernamePasswordToken(name, password); 
		
		try {
			//2.执行登录操作
			subject.login(token);
			return SUCCESS;
		} catch (UnknownAccountException e) {
			ActionContext.getContext().put("msg", "用户名不存在");
			return ERROR;
		}catch (IncorrectCredentialsException e) {
			ActionContext.getContext().put("msg", "密码错误");
			return ERROR;
		}catch (Exception e) {
			ActionContext.getContext().put("msg", e.getMessage());
			return ERROR;
		}
	}
}
