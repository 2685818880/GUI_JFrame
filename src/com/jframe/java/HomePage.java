package com.jframe.java;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HomePage extends JFrame{
	private JLabel label;
	private JComboBox cbox;

	HomePage(){ 
	super("homepage");//∏∏¿‡
    Container container = getContentPane();
    container.setLayout(new FlowLayout());
    
    cbox = new JComboBox();
    cbox.addItem("  ");
    cbox.addItem("exit1");
    cbox.addItemListener(new ItemListener()
    {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			 System.exit(1);
			 System.out.println("home");
		}
    	
    });

    label = new JLabel("username£∫");
    label.setText("”√ªß£∫"+new Login().user()+"-----------"+new SimpleDateFormat("yyyy--MM--ddd HH:mm:ss").format(new Date()));
    Account c=new Account();

    container.add(label);
    container.add(cbox);

    setSize(800,600);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HomePage();
	}

}
