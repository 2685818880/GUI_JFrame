package com.java.test;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Frame f = new Frame("1");
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		Button[] bs = new Button[10];
		
		f.setLayout(gb);
		for (int i = 0; i < bs.length; ++i)
		{
			bs[i] = new Button("an"+i);
		}
		//��������������ں�����������
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gb.setConstraints(bs[0], gbc);
		f.add(bs[0]);
		gb.setConstraints(bs[1], gbc);
		f.add(bs[1]);
		gb.setConstraints(bs[2], gbc);
		f.add(bs[2]);
		//��GridBagConstraints���Ƶ�GUI��������Ϊ�������һ�����
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(bs[3], gbc);
		f.add(bs[3]);
		//��GridBagConstraints���Ƶ�GUI������ں��򲻻�����
		gbc.weightx = 0;
		gb.setConstraints(bs[4], gbc);
		f.add(bs[4]);
		//��GridBagConstraints���Ƶ�GUI����������������
		gbc.gridwidth = 2;
		gb.setConstraints(bs[5], gbc);
		f.add(bs[5]);
		//��GridBagConstraints���Ƶ�GUI��������һ������
		gbc.gridwidth = 1;
		//��GridBagConstraints���Ƶ�GUI������ݿ���������
		gbc.gridheight = 2;
		//��GridBagConstraints���Ƶ�GUI��������Ϊ�������һ�����
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(bs[6], gbc);
		f.add(bs[6]);
		//��GridBagConstraints���Ƶ�GUI����������һ�������������������
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		//��GridBagConstraints���Ƶ�GUI������������Ȩ����1
		gbc.weighty = 1;
		gb.setConstraints(bs[7], gbc);
		f.add(bs[7]);
		//��������İ�ť�����򲻻�����
		gbc.weighty = 0;
		//��GridBagConstraints���Ƶ�GUI��������Ϊ�������һ�����
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		//��GridBagConstraints���Ƶ�GUI����������һ������
		gbc.gridheight = 1;
		gb.setConstraints(bs[8], gbc);
		f.add(bs[8]);
		gb.setConstraints(bs[9], gbc);
		f.add(bs[9]);
		f.pack();
		f.setVisible(true);
	}
}