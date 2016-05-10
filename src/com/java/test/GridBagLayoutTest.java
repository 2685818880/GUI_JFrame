package com.java.test;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Frame f = new Frame("1");
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		Button[] bs = new Button[10];
		
		f.setLayout(gb);
		for (int i = 0; i < bs.length; ++i)
		{
			bs[i] = new Button("an"+i);
		}
		//所有组件都可以在横向、纵向扩大
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gb.setConstraints(bs[0], gbc);
		f.add(bs[0]);
		gb.setConstraints(bs[1], gbc);
		f.add(bs[1]);
		gb.setConstraints(bs[2], gbc);
		f.add(bs[2]);
		//该GridBagConstraints控制的GUI组件将会成为横向最后一个组件
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(bs[3], gbc);
		f.add(bs[3]);
		//该GridBagConstraints控制的GUI组件将在横向不会扩大
		gbc.weightx = 0;
		gb.setConstraints(bs[4], gbc);
		f.add(bs[4]);
		//该GridBagConstraints控制的GUI组件将横跨两个网格
		gbc.gridwidth = 2;
		gb.setConstraints(bs[5], gbc);
		f.add(bs[5]);
		//该GridBagConstraints控制的GUI组件将横跨一个网格
		gbc.gridwidth = 1;
		//该GridBagConstraints控制的GUI组件将纵跨两个网格
		gbc.gridheight = 2;
		//该GridBagConstraints控制的GUI组件将会成为横向最后一个组件
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(bs[6], gbc);
		f.add(bs[6]);
		//该GridBagConstraints控制的GUI组件将横向跨一个网格，纵向跨两个网格
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		//该GridBagConstraints控制的GUI组件纵向扩大的权重是1
		gbc.weighty = 1;
		gb.setConstraints(bs[7], gbc);
		f.add(bs[7]);
		//设置下面的按钮在纵向不会扩大
		gbc.weighty = 0;
		//该GridBagConstraints控制的GUI组件将会成为横向最后一个组件
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		//该GridBagConstraints控制的GUI组件将纵向跨一个网格
		gbc.gridheight = 1;
		gb.setConstraints(bs[8], gbc);
		f.add(bs[8]);
		gb.setConstraints(bs[9], gbc);
		f.add(bs[9]);
		f.pack();
		f.setVisible(true);
	}
}