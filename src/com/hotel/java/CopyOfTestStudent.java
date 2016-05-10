package com.hotel.java;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import javax.swing.table.*;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class CopyOfTestStudent extends JFrame {
	
	CopyOfTestStudent(){
		JTable jt=new JTable();
	    String header[]={"ID","Name","JapScore","JavaScore","Sum"};
		DefaultTableModel md=new DefaultTableModel(header,0);
		JScrollPane scrollPane=new JScrollPane(jt);
		jt.setModel(md);
		
		StudentClass sClass = new StudentClass("对日软件开发班",n);
		students = new Student[n];
		for (int i = 0; i < n; i++){
			students[i] =  getStudent( i + 1);
		}
		sClass. setStudent( students);
			
		System.out.println( sClass);
		for(int j=0;j<n;j++){
			Vector v=new Vector();
			 v.addElement(students[j].getId());
			 v.addElement(students[j].getName());
			 v.addElement(students[j].getJapScore());
			 v.addElement(students[j].getJavaScore());
			 v.addElement(students[j].getSum());
			md.addRow(v);	
		}

		   this.getContentPane().add(scrollPane,BorderLayout.CENTER);
		   this.setSize(300,200);
           this.setVisible(true);
      }

	public static Random rn=new Random();
	public static int n=40;//班级人员，默认初始值为40.
	public static Student students[];
	 //顺序查找 search
    public static  int  search( String id){
    	for (int i = 0; i <n; i++) {
    	   if (students[i]. getId(). equals(id)) 
    	   { 
    		   //System.out.print("存在！");
    		   return 0;
    	   } 
    	   
    	}
    	//System.out.print("不存在！");
		return -1;
		
    } 

    public static boolean del( String id){
    	int pos = search( id);//0 wei 存在，-1 不存在
    	if (pos== -1) {return false; }
    	for (int i = pos+1; i<n; i++) {
    		 students[i-1] =  students[i];}
    	   n--;		
    	return true;
    }	
	   public static Student getStudent( int i){
	       //1)
		    while(true){
				Student student = new Student( "00"+i, "mr.li"+i, rn.nextInt(50)+50, rn.nextInt(100));
				return student; 
			   }
		    
			}
	   public void selectionSort(){//用选择排序方法按总成绩从高到低排序

			Student temp;
			for (int i=0; i<n-1; i++)
			  for (int j=i+1;j<n; j++)
			    if (students[j]. compare( students[i])>0) {
			    	temp =  students[i];
			    	students[i] =  students[j];
			    	students[j]  = temp;
			    }
	 }

	public static void main(String[] args) {
		CopyOfTestStudent copy=new CopyOfTestStudent();
		StudentClass sClass = new StudentClass("对日软件开发班",n);
		students = new Student[n];
		for (int i = 0; i < n; i++){
			students[i] =  getStudent( i + 1);
		}
		sClass. setStudent( students);
			
		System.out.println( sClass);
		System.out.println( search("005"));	
		//System.out.println( add(gtStudent(7)));
		//search("006");
		System.out.println( del("005"));
		System.out.println( search("005"));	
		}
	
	  
	}

//1)
//Scanner scanner = new Scanner( System.in);
//Student student;
//System.out.println("输入第"+i+"个学生信息");
//System.out.println("学号：");
//String id = scanner. nextLine();//读取键盘输入的一行（以回车换行为结束输入）
//System.out.println("姓名：");
//String name = scanner. nextLine();
//System.out.println("日语成绩：");
//int japScore = scanner. nextInt();
//System.out.println( "Java成绩：");
//int javaScore = scanner. nextInt();
//student = new Student( id, name, japScore, javaScore);
//return student;
