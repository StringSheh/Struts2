package com.itheima.web.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class LoginRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("执行授权操作");
		
		SimpleAuthorizationInfo info  = new SimpleAuthorizationInfo();
		info.addStringPermission("user:edit");
		
		info.addRole("admin");
		
		return info;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证操作");
		
		//模拟数据库的用户
		String name = "eric";
		String password = "123456";
		
		//判断用户名是否正确
		UsernamePasswordToken userToken = (UsernamePasswordToken)token;
		if(!userToken.getUsername().equals(name)){
			//用户名不存在
			return null;
		}
		
		//判断密码
		return new SimpleAuthenticationInfo(name,password,name);
	}

}
