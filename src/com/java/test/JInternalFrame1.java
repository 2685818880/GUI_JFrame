package com.java.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

public class JInternalFrame1 extends JFrame implements ActionListener{
     
    JDesktopPane desktopPane;
    int count = 1;
     
    public JInternalFrame1() {
        super("JInternalFrame1");
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
         
        JButton b = new JButton("Create New Internal Frames");
        b.addActionListener(this);//���û����°�ťʱ��������actionPerformed()�еĳ���
        contentPane.add(b, BorderLayout.SOUTH);
        /*����һ���µ�JDesktopPane��������contentPane��
         */
        desktopPane = new JDesktopPane(); 
        contentPane.add(desktopPane); 
 
        setSize(350, 350); 
        show(); 
         
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    /*����һ���ɹرա��ɸı��С�����б��⡢���������С����Internal Frame.
     */
    public void actionPerformed(ActionEvent e)
    {
        JInternalFrame internalFrame = new JInternalFrame(
        "Internal Frame "+(count++), true, true, true, true);  
 
        internalFrame.setLocation( 20,20);
        internalFrame.setSize(200,200); 
        internalFrame.setVisible(true);
        //ȡ��JInternalFrame��Content Pane,���Լ����µ������
        Container icontentPane = internalFrame.getContentPane();
        JTextArea textArea = new JTextArea();
        JButton b = new JButton("Internal Frame Button");
        /*��JTextArea��JButton�������JInternalFrame�С��ɴ˴�֪��JInteranlFrame�������
         *�ķ�ʽ��JFrame��һģһ����
         */
        icontentPane.add(textArea,"Center");
        icontentPane.add(b,"South");
        //��JInternalFrame����JDesktopPane�У����һ������ʹ�����ܶ�JInternalFrame,JDesktopPaneҲ
        //�ܽ�����֮��Ĺ�ϵ������൱���á�
        desktopPane.add(internalFrame);  
         
        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
          System.out.println("Exception while selecting");
        }
    }
 
    public static void main(String[] args) {
        new JInternalFrame1();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}