package com.jframe.java;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		
		List list1=new ArrayList();
		list1.add(0, "a");
		list1.add(1, "b");
		list1.add(2, "c");
		list1.add(3, "d");
		
		
		
		List list2=new ArrayList();
		list2.addAll(list1);
		
		
		System.out.println(list2);
		Object rawData =  list2.get(0);
		
		System.out.println(rawData);
		}
	
}
