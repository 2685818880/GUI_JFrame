package com.java.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import com.java.dao.Dao;
import com.java.dao.DaoImpl;

@SuppressWarnings("serial")
public class Login  extends JApplet{
	static Login l = null;
	private JTextField textfield1, textfield2;
	private JLabel label, label2;
	private JButton button;
	String sql = "";
	public static String s="";
	Dao dao=new DaoImpl();
	  @Override
		public void init() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		label = new JLabel("username：");
		textfield1 = new JTextField(10);
		label2 = new JLabel("userpass：");
		textfield2 = new JTextField(10);
		new JLabel("提示信息");
	   
		button = new JButton("enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dao.getLogin(textfield1.getText(),textfield2.getText())){
							
							s=textfield1.getText();
							test t=new test();
							t.setVisible(true);
							System.out.println("having");
							//System.exit(0);
						}else{
							System.out.println("not having");
						}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		
		container.add(label);
		container.add(textfield1);
		container.add(label2);
		container.add(textfield2);
		container.add(button);
		setBounds(400,100,570,470);
		setSize(250, 150);
		setVisible(true);
	}



}
