package com.java.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
 class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
 }
public class Examle extends JFrame{
   public Examle(){
	   final JToolBar tool=new JToolBar("gongjulan");
	   tool.setFloatable(false);
       getContentPane().add(tool,BorderLayout.NORTH);
       final JButton b1=new JButton("1");
       b1.addActionListener(new ButtonListener());
       tool.add(b1);
       tool.addSeparator();
       final JButton b2=new JButton("2");
       b2.addActionListener(new ButtonListener());
       tool.add(b2);
       tool.addSeparator();
       final JButton b3=new JButton("3");
       b3.addActionListener(new ButtonListener());
       tool.add(b3);
       tool.addSeparator();
   }
   public static void main(String[] args) {
	    Examle ex=new Examle();
	    ex.setVisible(true);
	    ex.setSize(400,300);
	    
}
}
