package com.jframe.java;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Demo3 {
	private JTextArea text;
	private JButton button1,button2,button3,button4,button5;
	private JLabel label1,label2;
	Demo3(){
		   JFrame jf=new JFrame("读取写入文本信息");
	       Container ct=jf.getContentPane();
	       ct.setLayout(new FlowLayout());
	       text =new JTextArea(20,50);
	       JScrollPane sp=new JScrollPane(text);
	       button5 = new JButton("清空文件源");
	       button3 = new JButton("重置");
	       button4 = new JButton("退出");
	       button1 = new JButton("写入");
	       button2 = new JButton("读取");
	       label1 =new JLabel("提示信息：");
	       button5.addActionListener(new ActionListener()
	        {
				public void actionPerformed(ActionEvent e) 
				{

					String str = "";
					FileOutputStream os = null;
					try {
						os = new FileOutputStream ("D://66.txt" , false);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						os . write ( str. getBytes());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						os . close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} //关闭资源
				}
			});
	       button3.addActionListener(new ActionListener()
	        {
				public void actionPerformed(ActionEvent e) 
				{
//					text.getText();
					text.setText("");//文本清空
					text.requestFocus();//焦点回到文本框
					label1.setText("提示信息：文本已清空！");
				}
			});
	       button4.addActionListener(new ActionListener()
	        {
				public void actionPerformed(ActionEvent e) 
				{

			      System.exit(0);
				}
			});
	       button1.addActionListener(new ActionListener()
	        {
				public void actionPerformed(ActionEvent e) 
				{
//					text.getText();
					String str = text.getText();
					File file=new File("D://66.txt");
					//BufferedWriter  os=new BufferedWriter (new FileWriter(("D:\\1.txt"),true));
					BufferedWriter  os = null;
					try {
						os = new BufferedWriter (new FileWriter(file,true));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
			
						e1.printStackTrace();
					}
					try {
							//str=s.readLine().trim();
							//if(s.equals("exit"))break;
							os.write(str);
							os.newLine();
							//os.flush();
					
	
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						 os.write("wirte time:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						os . close();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						
						//e1.printStackTrace();
					} //关闭资源
					finally
					{
						//System.exit(0);
						label1.setText("提示信息：写入成功！");
					}
				}


			});
	       button2.addActionListener(new ActionListener()
	        {
				public void actionPerformed(ActionEvent e) 
				{
//					text.getText();
					String str = text.getText();
					File file=new File("D://66.txt");
					FileInputStream is = null;
					try {
						is = new FileInputStream (file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					byte[] bs=new byte[(int) file.length()];
					try {
						is.read(bs);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String sss=new String(bs);
					text.setText(sss);
					//String shuchu
				    // is .read(bs, off , length); 
					try {
						label1.setText("提示信息：读取成功！");
						is .close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} //关闭资源
				}
			});
	       ct.add(sp);
	       ct.add(button5);
	       ct.add(button3);
		   ct.add(button4);
		   ct.add(button1);
		   ct.add(button2);
	       ct.add(label1);
		   jf.setSize(600,500);
		   jf.setVisible(true);}
 
	public static void main(String[] args) {
		
		new Demo3();
	}

}
