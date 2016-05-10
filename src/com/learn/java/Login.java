package com.learn.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame {
	static// User u=new User("admin","admin");
	Login l = null;
	private JTextField textfield1, textfield2;
	private JLabel label, label2;
	private JButton button;
	String sql = "";
	public Login() throws Exception {//
		super("user login");// 父类
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
					if(getLogin(textfield1.getText(),textfield2.getText())){
						if(regist(textfield1.getText(),textfield2.getText())>0){
							new Demo5();
							System.out.println("having");
							//System.exit(0);
						}else{
							System.out.println("not having");
						}
						// Demo5();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		// System.exit(0);//退出
		container.add(label);
		container.add(textfield1);
		container.add(label2);
		container.add(textfield2);
		container.add(button);
		setSize(250, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
    public int regist (String text1, String text2) throws Exception{
    	Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String name = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url, name, pass);
		sql = "select count(*) from t_user where username='" + text1 + "'and password='"
				+ text2 + "'";
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		rs.next();
		int count = rs.getInt(1); //总条数
		
		/*int count=0;
		while(rs.next()){
			++count;
		}
		*/
		
		System.out.println(count); 
		//System.out.println(rs.getRow());//当前是哪一行，并非行数
		//return rs.getRow();
		return count;
    }
	public boolean getLogin(String text1, String text2) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String name = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url, name, pass);
		//SQL注入
		/*sql = "select * from t_user where username='" + text1 + "'and password='"
				+ text2 + "'";
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(sql);*/

		sql = "select * from t_user where username=? and password=?";		
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, text1);
		pstat.setString(2, text2);
		ResultSet rs = pstat.executeQuery();
		
		return rs.next();
	}

	public static void main(String[] args) throws Exception {
		l = new Login();

	}

}
