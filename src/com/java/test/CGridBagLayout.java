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
        //��������������ں�����������  
        gbc.fill = GridBagConstraints.BOTH; 
        //��GridBagConstraints���Ƶ�GUI��������
        gbc.anchor = GridBagConstraints.WEST;
        //��GridBagConstraints���Ƶ�GUI������򡢺��������Ȩ����1 
        gbc.weighty = 1; 
        gbc.weightx = 1;
        //��GridBagConstraints���Ƶ�GUI����������һ�������������������  
        gbc.gridwidth = 1; gbc.gridheight = 1;    
        gb.setConstraints(btn[0], gbc);  
        f.add(btn[0]);  
        //��GridBagConstraints���Ƶ�GUI�����������������������һ������  
        gbc.gridwidth = 1; gbc.gridheight = 1;  
        gb.setConstraints(btn[1], gbc);  
        f.add(btn[1]);  
        //��GridBagConstraints���Ƶ�GUI����������һ�������������������
        gbc.gridwidth = 1; gbc.gridheight = 1;
        //��GridBagConstraints���Ƶ�GUI��������Ϊ�������һ�����  
        gbc.gridwidth = GridBagConstraints.REMAINDER;  
        gb.setConstraints(btn[2], gbc);  
        f.add(btn[2]); 
        
        
        gbc.gridx = 1; gbc.gridy = 1;//�ڶ��У��ڶ���
        //��GridBagConstraints���Ƶ�GUI�����������������������һ������
        gbc.gridwidth = 2; gbc.gridheight = 1;
        gb.setConstraints(btn[3], gbc);  
        f.add(btn[3]); 
        gbc.gridwidth = 2; gbc.gridheight = 1;
        gb.setConstraints(btn[4], gbc);  
        f.add(btn[4]); 
        gbc.gridwidth = 2; gbc.gridheight = 1;
        gb.setConstraints(btn[5], gbc);  
        f.add(btn[5]); 
        
        
        
        gbc.gridx = 0; gbc.gridy = 2;//�����У���һ��
        //��GridBagConstraints���Ƶ�GUI����������һ�������������������  
        gbc.gridwidth = 1; gbc.gridheight = 1;    
        gb.setConstraints(btn[4], gbc);  
        f.add(btn[4]); 
        gbc.gridx = 1; gbc.gridy = 2;//�����У��ڶ���
        //��GridBagConstraints���Ƶ�GUI��������򡢺����һ������  
        gbc.gridwidth = 1; gbc.gridheight = 1;  
        gb.setConstraints(btn[5], gbc);  
        f.add(btn[5]);
        gbc.gridx = 2; gbc.gridy = 2;//�����У�������
        gb.setConstraints(btn[6], gbc);  
        f.add(btn[6]); 
        gbc.gridx = 3; gbc.gridy = 2;//�����У�������
        //��GridBagConstraints���Ƶ�GUI����������һ�������������������
        gbc.gridwidth = 1; gbc.gridheight = 1;
        //��GridBagConstraints���Ƶ�GUI��������Ϊ�������һ�����  
        gbc.gridwidth = GridBagConstraints.REMAINDER;  
        gb.setConstraints(btn[7], gbc);  
        f.add(btn[7]); 
        gbc.gridx = 1; gbc.gridy = 2;//�����У��ڶ���
        //��GridBagConstraints���Ƶ�GUI������������������
        gbc.gridwidth = 1; gbc.gridheight = 1;
        gb.setConstraints(btn[8], gbc);  
        f.add(btn[8]);
        gbc.gridx = 2; gbc.gridy = 3;//�����У�������
        gb.setConstraints(btn[9], gbc);  
        f.add(btn[9]);
        f.pack();  
        f.setVisible(true);  
	}
}