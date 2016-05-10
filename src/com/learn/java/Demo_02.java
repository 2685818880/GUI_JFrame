package com.learn.java;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo_02 {
	public Demo_02(){
	      JFrame jf=new JFrame("Simple JFrame application");
		  Icon icon=new ImageIcon("1.png");
		  JLabel label=new JLabel("Õº∆¨œ‘ æ",icon,JLabel.CENTER);
		  JButton button=new JButton("πÿ±’");
		  //label.setVerticalTextPosition(JLabel.BOTTOM);
		  Container cp=jf.getContentPane();
		  cp.add(label,BorderLayout.CENTER);
		  cp.add(button,BorderLayout.SOUTH);
		  button.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent ae){
				  System.exit(0);}});
				jf.setBounds(200,100,400,300);
				jf.setVisible(true);}				
	public static void main(String[] args) 
	{    Demo_02 a=new Demo_02();}}
