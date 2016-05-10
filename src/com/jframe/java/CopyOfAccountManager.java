package com.jframe.java;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class CopyOfAccountManager extends JFrame {
	 private JTextField textfield1;
	  private JButton button;

	public static Map<String ,Account>ms;
	//接口 Map<K,V>类型参数： K - 此映射所维护的键的类型 V - 映射值的类型
	

	public CopyOfAccountManager() {
		super();  int n=10;
		ms=new HashMap <String ,Account>();
		//类 HashMap<K,V>类型参数：K - 此映射所维护的键的类型 V - 所映射值的类型

		Account a;
		JTable jt=new JTable();
	    String header[]={"ID","Name","Price"};
		DefaultTableModel md=new DefaultTableModel(header,0);//头 
		JScrollPane scrollPane=new JScrollPane(jt); //制表
		jt.setModel(md);
//		 textfield1 = new JTextField(10);//text
		for(int i=0;i<=n;i++){
			
			a=new Account(i+1+"","mr.li"+i,Math.random()*100);
			ms.put(a.getId(), a);
			Vector<Comparable> v=new Vector<Comparable>();
			 v.addElement(a.getId());
			 v.addElement(a.getName());
			 v.addElement(a.getPrice());

			 md.addRow(v);
		}
//		 button = new JButton("enter");
//	        button.addActionListener(new ActionListener()
//	        {
//				public void actionPerformed(ActionEvent e) 
//				{
//
//
//				}
//
//
//			});
	        
	       
		  this.getContentPane().add(scrollPane,BorderLayout.CENTER);
//		  this.getContentPane().add(textfield1);
//		  this.getContentPane().add(button);
		  this.setSize(300,200);
          this.setVisible(true);
	}
	public  Collection<Account> All(){
		return ms.values();
	}
    Account add(Account a){
    	return ms.put(a.getId(), a);
    }
    Account remove(String id){
    	return ms.remove(id);
    }
   double search (String name){
	   for(Account a :All()){
		   if(a.getName().equals(name)){
			   return a.getPrice();
		   }
		   
	   }
	return 0;
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOfAccountManager acc=new CopyOfAccountManager();
		acc.add(new Account(5+"","mr.zhang",Math.random()*100));
		System.out.println(acc.All());
		//Scanner sca=new Scanner(System.in);
		//String n=sca.next();
		//acc.remove(n);
		System.out.println(acc.All());
		System.out.print(acc.search("mr.li10"));
       
	}


}
