package com.learn.java;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Demo3 {

	Demo3(){
	JFrame jf=new JFrame();
	final JLabel label=new JLabel();
	label.setText("备注:");
	Container c=jf.getContentPane();
	c.add(label,BorderLayout.WEST);
	
	final JScrollPane scrollPane=new JScrollPane();
	c.add(scrollPane,BorderLayout.CENTER);
	JTextArea textArea=new JTextArea();
	textArea.addKeyListener(new KeyListener(){
		@Override
		public void keyPressed(KeyEvent e) {//按键被按下时被触发
			String keyText=KeyEvent.getKeyText(e.getKeyCode());
			if(e.isActionKey()){
				System.out.print("动作键"+keyText+"");
			}
			else{
				System.out.print("非动作键"+keyText+"");
				int keyCode=e.getKeyCode();
				switch(keyCode){
				case KeyEvent.VK_CONTROL://ctrl
				System.out.print("ctrl");
				break;
				case KeyEvent.VK_ALT://ctrl
				System.out.print("ctrl");
				break;
				case KeyEvent.VK_SHIFT://ctrl
				System.out.print("ctrl");
				break;
				}
				
				System.out.println();
				
				
			}
			
		}
		@Override
		public void keyTyped(KeyEvent e) {//发生击键事件时被触发
			
			System.out.print("输入的是"+e.getKeyChar());
		}
		@Override
		public void keyReleased(KeyEvent e) {//按键被释放时被触发。
			String keyText=KeyEvent.getKeyText(e.getKeyCode());
			System.out.print("输入的是"+keyText);
			System.out.println();
		}
		
	});
	textArea.setLineWrap(true);
	textArea.setRows(3);
	textArea.setColumns(15);
	scrollPane.setViewportView(textArea);
	jf.setVisible(true);
	jf.setSize(300, 350);
	}
	public static void main(String[] args) {
	new	Demo3();

	}

}
