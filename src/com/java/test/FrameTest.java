package com.java.test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class FrameTest extends JFrame 
{
    private JButton btn = new JButton("���Ӵ���");
     
    public FrameTest()
    {
        setTitle("������");
        setSize(400, 300);
        setLayout(new FlowLayout());
        add(btn);
        btn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    new SubFrame();
                }
            });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }
     
    public static void main(String[] args)
    {
        new FrameTest();
    }
}
 
class SubFrame extends JFrame
{
    public SubFrame()
    {
        setTitle("�Ӵ���");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }
}