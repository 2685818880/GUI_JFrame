package com.java.test;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.getconn.GetConnection;


@SuppressWarnings("serial")
public class Project_mast extends JFrame{
	/**
	 * @param args
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	public Project_mast() throws Exception{
		super("��Ŀ��������w_bas_project_mast");
		setBounds(300,100,570,470);
		JTable jt=new JTable();
	    String header[]={"��Ŀ���","��Ŀ����"};
		DefaultTableModel md=new DefaultTableModel(header,0);
		JScrollPane scrollPane=new JScrollPane(jt);
		jt.setModel(md);
		String sql="select * from w_bas_project";
		ResultSet rs = null;
		final Connection con= GetConnection.getConnection();
		final Statement stat=con.createStatement();
		    
		  rs = stat.executeQuery(sql);
	      Vector<Comparable> v=null;
				while(rs.next()){//�������ݿ��е�����
				   v=new Vector<Comparable>();
				   v.addElement(rs.getString("proNo"));
				   v.addElement(rs.getString("proName"));
				   md.addRow(v);
		   this.getContentPane().add(scrollPane,BorderLayout.CENTER);
		   this.setSize(1024,768);
           this.setVisible(true);
		}
   }

}
