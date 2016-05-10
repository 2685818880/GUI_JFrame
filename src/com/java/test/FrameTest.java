package com.java.test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class FrameTest extends JFrame 
{
    private JButton btn = new JButton("打开子窗口");
     
    public FrameTest()
    {
        setTitle("主窗口");
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
        setTitle("子窗口");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }
}