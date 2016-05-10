package com.java.test;
import java.awt.*;

public class CGridBagLayout {

	public static void main(String[] args) {
		Frame f = new Frame("a");  
        GridBagLayout gb = new GridBagLayout();  
        GridBagConstraints gbc = new GridBagConstraints();  
        Button[] btn = new Button[15];
        f.setLayout(gb);   
        for (int i = 0; i < btn.length; ++i)  
        {  
            btn[i] = new Button("bt"+i);  
        }
        //所有组件都可以在横向、纵向扩大  
        gbc.fill = GridBagConstraints.BOTH; 
        //该GridBagConstraints控制的GUI组件左对齐
        gbc.anchor = GridBagConstraints.WEST;
        //该GridBagConstraints控制的GUI组件纵向、横向扩大的权重是1 
        gbc.weighty = 1; 
        gbc.weightx = 1;
        //该GridBagConstraints控制的GUI组件将横向跨一个网格，纵向跨两个网格  
        gbc.gridwidth = 1; gbc.gridheight = 1;    
        gb.setConstraints(btn[0], gbc);  
        f.add(btn[0]);  
        //该GridBagConstraints控制的GUI组件将横向跨两个网格，纵向跨一个网格  
        gbc.gridwidth = 1; gbc.gridheight = 1;  
        gb.setConstraints(btn[1], gbc);  
        f.add(btn[1]);  
        //该GridBagConstraints控制的GUI组件将横向跨一个网格，纵向跨两个网格
        gbc.gridwidth = 1; gbc.gridheight = 1;
        //该GridBagConstraints控制的GUI组件将会成为横向最后一个组件  
        gbc.gridwidth = GridBagConstraints.REMAINDER;  
        gb.setConstraints(btn[2], gbc);  
        f.add(btn[2]); 
        
        
        gbc.gridx = 1; gbc.gridy = 1;//第二行，第二列
        //该GridBagConstraints控制的GUI组件将横向跨两个网格，纵向跨一个网格
        gbc.gridwidth = 2; gbc.gridheight = 1;
        gb.setConstraints(btn[3], gbc);  
        f.add(btn[3]); 
        gbc.gridwidth = 2; gbc.gridheight = 1;
        gb.setConstraints(btn[4], gbc);  
        f.add(btn[4]); 
        gbc.gridwidth = 2; gbc.gridheight = 1;
        gb.setConstraints(btn[5], gbc);  
        f.add(btn[5]); 
        
        
        
        gbc.gridx = 0; gbc.gridy = 2;//第三行，第一列
        //该GridBagConstraints控制的GUI组件将横向跨一个网格，纵向跨两个网格  
        gbc.gridwidth = 1; gbc.gridheight = 1;    
        gb.setConstraints(btn[4], gbc);  
        f.add(btn[4]); 
        gbc.gridx = 1; gbc.gridy = 2;//第三行，第二列
        //该GridBagConstraints控制的GUI组件将纵向、横向跨一个网格  
        gbc.gridwidth = 1; gbc.gridheight = 1;  
        gb.setConstraints(btn[5], gbc);  
        f.add(btn[5]);
        gbc.gridx = 2; gbc.gridy = 2;//第三行，第三列
        gb.setConstraints(btn[6], gbc);  
        f.add(btn[6]); 
        gbc.gridx = 3; gbc.gridy = 2;//第三行，第四列
        //该GridBagConstraints控制的GUI组件将横向跨一个网格，纵向跨两个网格
        gbc.gridwidth = 1; gbc.gridheight = 1;
        //该GridBagConstraints控制的GUI组件将会成为横向最后一个组件  
        gbc.gridwidth = GridBagConstraints.REMAINDER;  
        gb.setConstraints(btn[7], gbc);  
        f.add(btn[7]); 
        gbc.gridx = 1; gbc.gridy = 2;//第四行，第二列
        //该GridBagConstraints控制的GUI组件将纵向跨两个网格
        gbc.gridwidth = 1; gbc.gridheight = 1;
        gb.setConstraints(btn[8], gbc);  
        f.add(btn[8]);
        gbc.gridx = 2; gbc.gridy = 3;//第三行，第三列
        gb.setConstraints(btn[9], gbc);  
        f.add(btn[9]);
        f.pack();  
        f.setVisible(true);  
	}
}