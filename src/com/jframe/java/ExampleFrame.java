package com.jframe.java;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class ExampleFrame extends JFrame{
	public static void main(String[] args) {
		ExampleFrame frame=new ExampleFrame();
		frame.setVisible(true);
	}
	public ExampleFrame(){
		super();
		setTitle("∑÷∏Ó√Ê∞Â");
		setBounds(100,100,500,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JSplitPane hs=new JSplitPane();
		hs.setDividerLocation(40);
		getContentPane().add(hs,BorderLayout.CENTER);
		hs.setLeftComponent(new JLabel("  1"));
		final JSplitPane vs=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vs.setDividerLocation(30);
		vs.setDividerSize(8);
		vs.setOneTouchExpandable(true);
		vs.setContinuousLayout(true);
		hs.setRightComponent(vs);
		vs.setLeftComponent(new JLabel("    2"));
		vs.setRightComponent(new JLabel("   3"));
	}
}
