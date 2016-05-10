package com.learn.java;

import java.awt.*;

import javax.swing.*;

public class Demo_01 {

	Demo_01(){
		  JFrame jf=new JFrame("Simple JFrame application");
		  Container cp=jf.getContentPane();
		  JLabel jl=new JLabel("gefdsfadsf");
		  jf.add(jl);
		  jf.setSize(200,300);
		  jf.setVisible(true);
		  //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Demo_01 de=new Demo_01();
	}

}
