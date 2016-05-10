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
	label.setText("��ע:");
	Container c=jf.getContentPane();
	c.add(label,BorderLayout.WEST);
	
	final JScrollPane scrollPane=new JScrollPane();
	c.add(scrollPane,BorderLayout.CENTER);
	JTextArea textArea=new JTextArea();
	textArea.addKeyListener(new KeyListener(){
		@Override
		public void keyPressed(KeyEvent e) {//����������ʱ������
			String keyText=KeyEvent.getKeyText(e.getKeyCode());
			if(e.isActionKey()){
				System.out.print("������"+keyText+"");
			}
			else{
				System.out.print("�Ƕ�����"+keyText+"");
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
		public void keyTyped(KeyEvent e) {//���������¼�ʱ������
			
			System.out.print("�������"+e.getKeyChar());
		}
		@Override
		public void keyReleased(KeyEvent e) {//�������ͷ�ʱ��������
			String keyText=KeyEvent.getKeyText(e.getKeyCode());
			System.out.print("�������"+keyText);
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
