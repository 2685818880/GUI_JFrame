package com.java.test;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Frame f = new Frame("d");
		f.setLayout(new BorderLayout(5,5));
		f.add(new Button("f"),BorderLayout.SOUTH);
		f.add(new Button("f"),BorderLayout.NORTH);
		f.add(new Button("d"));
		f.add(new Button("s"),BorderLayout.EAST);
		f.add(new Button("d"),BorderLayout.WEST);
		//���ô���Ϊ��Ѵ�С
		f.pack();
		f.setVisible(true);
	}
}