package com.java.test;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.java.test.DateChooserJButton.DateChooser;

public class BorderLayoutTest1 {
	static JButton button;
	BorderLayoutTest1(){

	  JFrame jf=new JFrame("Simple JFrame application");
	  Container cp=jf.getContentPane();
	  jf.setSize(200,300);
	  jf.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame f = new JFrame("报销单汇总输入");
		
		JPanel jp=new JPanel();
		JLabel j1=new JLabel();
		j1.setText("G160225150026");
		jp.add(j1,BorderLayout.EAST);
		
		JLabel j2=new JLabel();
		j2.setText("报销单汇总输入");
		jp.add(j2,BorderLayout.CENTER);
		f.add(jp,BorderLayout.NORTH);//bei
		
		DateChooserJButton dj1=new DateChooserJButton ();
		DateChooserJButton dj2=new DateChooserJButton ();
		DateChooserJButton dj3=new DateChooserJButton ();
		JPanel p = new JPanel();
		p.add(new JLabel("出差起始日"));
		p.add(new JPanel().add(dj1));
		p.add(new JLabel("出差到达日"));
		p.add(new JPanel().add(dj2));
		p.add(new JLabel("报销日期"));
		p.add(new JPanel().add(dj3));
		p.add(new JLabel("天"));
		//默认添加到中间区域
		//f.add(p);
		/*System.out.println(dj1);
        System.out.println(dj1.getText());
        System.out.println(dj2.getText());
        System.out.println(dj3.getText());
		JPanel p1 = new JPanel();
		p1.add(new JLabel("出差起始日"));
		p1.add(new JPanel().add(dj1));
		p1.add(new JLabel("出差到达日"));
		p1.add(new JPanel().add(dj2));
		p1.add(new JLabel("报销日期"));
		p1.add(new JPanel().add(dj3));
		p1.add(new JLabel("天"));*/
		//f.add(new Button("3"),BorderLayout.EAST);//deng
		//设置窗口为最佳大小
		//f.pack();
		//f.setVisible(true);
		
		button = new JButton("enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {
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
*/
			}

		});

		
		System.out.println(dj1.getDate());
		f.add(p,BorderLayout.NORTH);
		//f.add(p1,BorderLayout.NORTH);
		
		//f.setLayout(new BorderLayout(30,5));
		//f.add(new Button("1"),BorderLayout.SOUTH);//nan
		f.add(button,BorderLayout.NORTH);
		
		f.setBounds(300,100,500,500);
		f.setSize(650,600);
		f.setVisible(true);
	}
}