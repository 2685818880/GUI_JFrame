package com.hotel.java;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
 public class Student_Message extends JFrame{
    public Student_Message(){
		JTable jt=new JTable();
	    String header[]={"name","math"};
		DefaultTableModel md=new DefaultTableModel(header,0);
		JScrollPane scrollPane=new JScrollPane(jt);
		jt.setModel(md);
		for (int i=0;i<10 ;i++ )
		{  Vector v=new Vector();
		   v.addElement("stu"+i);
		   v.addElement((int)(10*Math.random())+80);
		      md.addRow(v);	
		}
		   this.getContentPane().add(scrollPane,BorderLayout.CENTER);
		   this.setSize(300,200);
           this.setVisible(true);}
 public static void main(String[] args){
         new Student_Message();}}