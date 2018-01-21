package com.itheima.test.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseAction<T> {

	private T model;
	
	//创建model对象
	//获取到StandardAction(子类）的Standard类型
	public BaseAction(){
		//使用反射代码获取StandardAction(子类）的Standard类型
		
		//1.获取StandardAction类型
		//System.out.println(this.getClass());
		
		Class clz = this.getClass();
		
		//2.获取父类
		//getSuperclass()： 获取普通父类（不带泛型）
		//System.out.println(clz.getSuperclass());
		
		//getGenericSuperclass():获取泛型父类
		//System.out.println(clz.getGenericSuperclass());
		
		Type type = clz.getGenericSuperclass();
		
		//3.获取泛型父类里面的泛型
		//转换为参数化类型：List<T>
		ParameterizedType pt = (ParameterizedType)type;
		
		//getActualTypeArguments():获取参数化类型中实际参数　List<T>的T
		System.out.println(pt.getActualTypeArguments()[0]);
				
	}
	
	
	
}
