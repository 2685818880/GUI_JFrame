package com.jframe.java;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Login extends JFrame{
	  static //User u=new User("admin","admin");
	  Login l=null;
	  private JTextField textfield1,textfield2;
	  private JLabel label,label2;
	  private JButton button;
	  private static String a;
	  public Login(){//
	        super("user login");//���� 
	        Container container = getContentPane();
	        container.setLayout(new FlowLayout());
	        label = new JLabel("username��");
	        textfield1 = new JTextField(10);
	        label2 = new JLabel("userpass��");
	        textfield2= new JTextField(10);
	        button = new JButton("enter");
	        button.addActionListener(new ActionListener()
	        {
				public void actionPerformed(ActionEvent e) 
				{
					if(new User().getName().equals(textfield1.getText())&&new User().getPassword().equals(textfield2.getText()))
						{
						user();
						//new HomePage();
						new CopyOfAccountManager();
						}
				}


			});
	        //System.exit(0);//�˳�
	        container.add(label);
	        container.add(textfield1);
	        container.add(label2);
	        container.add(textfield2);
		    container.add(button);
	        setSize(250,300);
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	  }
		public String user() {
			// TODO Auto-generated method stub
			return new User().getName();
		}
      public static void main(String[]args){
    	   l=new Login();
    	  
     }


}

