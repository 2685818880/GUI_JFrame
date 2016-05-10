package com.japplet.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;


@SuppressWarnings("serial")
public class JAP extends JApplet {

	  Container c;
	  JPanel p1,p2;
	  JButton button1,button2,button3;
	  JLabel label;
	  @Override
	public void init() {
		// TODO Auto-generated method stub
        c=getContentPane();
        p1=new JPanel(new FlowLayout());
        p2=new JPanel(new FlowLayout());
        ImageIcon icon =new ImageIcon("image/1.jpg");
        button1=new JButton(icon);
        button2=new JButton(new ImageIcon("image/2.jpg"));
        button3=new JButton(new ImageIcon("image/3.jpg"));
        label=new JLabel("Í¼Ïñ±êÇ©",new ImageIcon("image/4.jpg"),SwingConstants.CENTER);
        c.setBackground(new Color(255,255,204));
        p1.setBackground(new Color(255,255,204));
        p2.setBackground(new Color(255,255,204));
        
        button1.setToolTipText("up");
        button2.setToolTipText("redir");
        button3.setToolTipText("down");
        c.add(p1,BorderLayout.NORTH);
        c.add(p2,BorderLayout.SOUTH);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(label);
	  }
	
}
