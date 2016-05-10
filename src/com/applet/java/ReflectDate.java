package com.applet.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReflectDate {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class cc=Class.forName("java.util.Date");
		Object o1=cc.newInstance();
		if(o1 instanceof Date)
		{
		Date t=(Date)o1;
		System.out.println(new SimpleDateFormat("yyyy--MM--dd HH:mm:ss SSS").format(t));

	   }
		
		
		
	/*	
		Class c = Class.forName("java.util.Date");

		//获取父类
		Class superClass = c.getSuperclass();

		System.out.println("父类"+superClass.getName());

		//获取父接口
		Class[] ins = c.getInterfaces();

		for(Class in:ins){
			System.out.println("父类接口"+in.getName());
		}*/

	}
}
