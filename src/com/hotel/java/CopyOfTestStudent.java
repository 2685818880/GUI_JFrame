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
		
		StudentClass sClass = new StudentClass("�������������",n);
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
	public static int n=40;//�༶��Ա��Ĭ�ϳ�ʼֵΪ40.
	public static Student students[];
	 //˳����� search
    public static  int  search( String id){
    	for (int i = 0; i <n; i++) {
    	   if (students[i]. getId(). equals(id)) 
    	   { 
    		   //System.out.print("���ڣ�");
    		   return 0;
    	   } 
    	   
    	}
    	//System.out.print("�����ڣ�");
		return -1;
		
    } 

    public static boolean del( String id){
    	int pos = search( id);//0 wei ���ڣ�-1 ������
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
	   public void selectionSort(){//��ѡ�����򷽷����ܳɼ��Ӹߵ�������

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
		StudentClass sClass = new StudentClass("�������������",n);
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
//System.out.println("�����"+i+"��ѧ����Ϣ");
//System.out.println("ѧ�ţ�");
//String id = scanner. nextLine();//��ȡ���������һ�У��Իس�����Ϊ�������룩
//System.out.println("������");
//String name = scanner. nextLine();
//System.out.println("����ɼ���");
//int japScore = scanner. nextInt();
//System.out.println( "Java�ɼ���");
//int javaScore = scanner. nextInt();
//student = new Student( id, name, japScore, javaScore);
//return student;
