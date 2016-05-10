package com.java.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.bean.MovieInfo;
import com.java.bean.w_bas_team;
import com.java.getconn.GetConnection;

public class comboBox {
	private JComboBox combobox;
	private JComboBox combobox1;
	private TextField dTextField;
	comboBox() throws Exception {
		super();
		JFrame jf = new JFrame("user_mast");
		//ResultSet rs = null;
		final Connection con = GetConnection.getConnection();

		Container cont = jf.getContentPane();

		final JPanel panel = new JPanel();
		cont.add(panel, BorderLayout.SOUTH);
		
		combobox =new JComboBox();
		panel.add(combobox);
		combobox1 =new JComboBox();
		panel.add(combobox1);
		
		dTextField=new TextField();
		panel.add(dTextField);
		
		
		String str="select * from w_bas_team";

		PreparedStatement stat =con.prepareStatement(str);
		ResultSet res = stat.executeQuery();
		String s1=null;
		String s2=null;
		List list =new ArrayList();
		
		try {
			while (res.next()) {
				int size = list.size();
				s1=res.getString("teamNo");
				s2=res.getString("teamName");
				w_bas_team team=new w_bas_team(s1,s2);
				list.add(team);
				combobox.addItem(list.get(size));
				//combobox.setSelectedItem(list.get(0));
				System.out.println(s1+"---"+s2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		  
       combobox1.addItem(0);
       combobox1.addItem(1);

		
		
		
		
        System.out.println(list);
	
		
		cont.setLayout(new FlowLayout(FlowLayout.LEADING));
		jf.setSize(900, 520);
		jf.setVisible(true);
	}
	public static void main(String[] args) throws Exception {
		new comboBox();
	}
}