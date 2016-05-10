package com.learn.java;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Demo5 {

	/**
	 * @param args
	 * GUI界面+SQL语句。
	 */
	private JLabel la,la1;
	private JTextField bTextField;
	private JTextField cTextField;
	private JTextField dTextField;

	Demo5() throws Exception{
		
		    JFrame jf=new JFrame("信息中心");  
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mysql";
			String name="root";
			String pass="root";
			final Connection con= DriverManager.getConnection(url, name, pass);
			final Statement stat=con.createStatement();
		    
		    
			final JTable jt=new JTable();
		    String header[]={"id","username","password","status"};
			final DefaultTableModel md=new DefaultTableModel(header,0);
			JScrollPane scrollPane=new JScrollPane(jt);
			jt.setModel(md);
	         ////////////////////////
			   jt.setRowSorter(new TableRowSorter<DefaultTableModel>(md));//设置表格的排序器
			   jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			   
			   jt.addMouseListener(new MouseAdapter(){
				   public void mouseClicked(MouseEvent e){
					   int selectedRow=jt.getSelectedRow();
					   Object oa=md.getValueAt(selectedRow, 0);
					   Object ob=md.getValueAt(selectedRow, 1);
					   Object oa1=md.getValueAt(selectedRow, 2);
					   Object ob1=md.getValueAt(selectedRow, 3);
					   la.setText(oa.toString());//将值赋值给文本框
					   bTextField.setText(ob.toString());//将值赋值给文本框
					   cTextField.setText(oa1.toString());//将值赋值给文本框
					   dTextField.setText(ob1.toString());//将值赋值给文本框
				   }
			   });
			   scrollPane.setViewportView(jt);
			  
			   
			 Container cont=jf.getContentPane();
			 cont.add(scrollPane,BorderLayout.CENTER);
			 //JPane1
			 final JPanel panel=new JPanel();
			 cont.add(panel,BorderLayout.SOUTH);
			 la1=new JLabel("提示信息",10);
			 panel.add(la1);
			 panel.add(new JLabel("id:"));
			 la=new JLabel("",10);
			 panel.add(la);
			 panel.add(new JLabel("username:"));
			 bTextField=new JTextField("test",10);
			 panel.add(bTextField);
			 panel.add(new JLabel("password:"));
			 cTextField =new JTextField("test",10);
			 panel.add(cTextField);
			 panel.add(new JLabel("status:"));
			 dTextField=new JTextField("0",10);
			 panel.add(dTextField);
			 
			 //add update delete
			 
			 final JButton addButton=new JButton("add");
			 addButton.addActionListener(new ActionListener(){
		     @Override
			 public void actionPerformed(ActionEvent e) {
		    	 String[]rowValues={la.getText(),bTextField.getText(),cTextField.getText(),dTextField.getText()};//创建表格行数组
					md.addRow(rowValues);//向表格模型中添加一行
					//int rowCount =jt.getRowCount()+1;
					//System.out.println(rowCount);
					 PreparedStatement ps = null;
						try {
							ps = con
							.prepareStatement("insert into t_user (username,password,status) values (?,?,?)");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 try {
							ps.setString(1, bTextField.getText());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 try {
							ps.setString(2, cTextField.getText());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 try {
							ps.setString(3, dTextField.getText());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 int t = 0;
						try {
							t = ps.executeUpdate();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 if (t > 0) {
						 System.out.println("插入成功");
						 la1.setText("数据插入成功！");
						 //获取最新插入数据的id
						 String search_id="select max(id) from t_user where username='"+bTextField.getText()+"'";
						  ResultSet rs = null;
						 try {
							rs = stat.executeQuery(search_id);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 try {
							 
							 while(rs.next()){//接收数据库中的内容
								 la.setText(rs.getInt(1)+"");
								}	
							 System.out.println(la.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// la1=rs.getInt("id");
						}else{
							la1.setText("数据插入失败！");
						}
					
				}   
			   });
			 panel.add(addButton);
			 final JButton updButton=new JButton("update");
			 updButton.addActionListener(new ActionListener(){
		  
				@Override
				public void actionPerformed(ActionEvent e) {
					 int selectedRow =jt.getSelectedRow();//获取被选中行的索引
//				
						//预编译 ，提高效率
						if(selectedRow!=1){
							md.setValueAt(bTextField.getText(),selectedRow,0);
							md.setValueAt(cTextField.getText(),selectedRow,1);
							md.setValueAt(cTextField.getText(),selectedRow,2);
						 }
					 String s="update t_user set username='111',password='222',status='c'where id=40";
					   String ss="update t_user set username"+"=?,password"+"=? ,status"+"=? where id=? ";
					 PreparedStatement ps = null;
						try {
							ps = con
							.prepareStatement(ss);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					  
					   try {
							ps.setString(1, bTextField.getText());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 try {
							ps.setString(2, cTextField.getText());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 try {
							ps.setString(3, dTextField.getText());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 try {
								ps.setString(4, la.getText());
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						 int t = 0;
						try {
							t = ps.executeUpdate();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 if (t > 0) {
							 
						 System.out.println("更新成功");
						 la1.setText("数据更新成功！");
						 }
				}
			
				   
			   });
			   panel.add(updButton);
			   final JButton delButton=new JButton("delete");
			   delButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					int selectedRow=jt.getSelectedRow();
					if(selectedRow!=-1){
						md.removeRow(selectedRow);
					}
					int t = 0;
					try {
						t = stat.executeUpdate("delete from t_user where id="+la.getText()+"");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					 if (t > 0) {
					 System.out.println("数据删除成功");
					 la1.setText("数据删除成功！");
					 }else{
					 System.out.println("数据删除失败");
					 la1.setText("数据删除失败！");
					 }
					
				}
				   
				   
			   });panel.add(delButton);
			   
			   
			   final JButton selButton=new JButton("刷新数据信息");
			   selButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					int selectedRow=jt.getSelectedRow();
					if(selectedRow!=-1){
						md.removeRow(selectedRow);//holder
					}
                   System.out.println(selectedRow);
                   System.out.println(md.getColumnCount()+"屬性/列");
                   System.out.println(md.getRowCount());//受影響的行數信息行數
                   if(md.getRowCount()>0){
                	  // md.removeRow(md.getRowCount()-1);
                	  // md.
                	   
                   }//有数据  刷新  把上一次数据 删除 ，从数据库中再次查询
					 String sql="select * from t_user";
					   ResultSet rs = null;
					   int temp=0;
					  /* System.out.println("size"+v.size());
	                     if(v.size()>0){
	                    	// v.clear();
	                    	// md.removeRow(v.size());
	                     }*/
					try {
						rs = stat.executeQuery(sql);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					} Vector v=null;
					    try {
							while(rs.next()){//接收数据库中的内容
							    v=new Vector();
							   v.addElement(rs.getInt("id"));
							   v.addElement(rs.getString("username"));
							   v.addElement(rs.getString("password"));
							   v.addElement(rs.getString("status"));
							   md.addRow(v);
							  
							}
						} catch (SQLException e1) {
							temp=v.size();
							 System.out.println(v.size());
							la1.setText("显示全部数据！");
							e1.printStackTrace();
						}
				}  
			   });panel.add(selButton);
			 // cont.setLayout(new FlowLayout(FlowLayout.LEADING));
			 jf.setSize(300,200);
	         jf.setVisible(true);
	 }

	public static void main(String[] args) throws Exception {
         new Demo5();
	   
	}
}
