package com.jframe.java;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/***
 * 桌面面板和内部窗体
 * ***/
@SuppressWarnings("serial")
public class test extends JFrame {
	JDesktopPane desktopPane = null;
    InternalFrame plnFrame=null;
    InternalFrame rlnFrame=null;
    InternalFrame tlnFrame=null;
    public static void main(String[] args) {
		test t=new test();
		t.setVisible(true);
		//t.setSize(800, 600);
		//t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    public test(){
    	super();
    	setTitle("报销");
    	setBounds(100,100,570,470);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	desktopPane=new JDesktopPane();//创建桌面面板
    	desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);//设置内部窗体的拖拽方式
    	getContentPane().add(desktopPane,BorderLayout.CENTER);//为桌面面板添加背景图片
    	/*final JButton addButton1 = new JButton("Project_mast");
		addButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Project_mast();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		final JButton addButton2 = new JButton("Bx_mast");
		addButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Bx_mast();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		desktopPane.add(addButton1,new Integer(Integer.MIN_VALUE));
		desktopPane.add(addButton2,new Integer(Integer.MIN_VALUE));*/
    	
    	final JLabel backLabel=new JLabel();
    	URL resource =this.getClass().getResource("/image/1.jpg");
    	ImageIcon icon=new ImageIcon(resource);//创建背景图片对象
    	backLabel.setIcon(icon);
    	backLabel.setBounds(0, 0, 800, 700);
    	desktopPane.add(backLabel,new Integer(Integer.MIN_VALUE));
    	///添加按钮的代码
    	
		
    }
}
class BAListener implements ActionListener{
	JDesktopPane desktopPane = null;
	InternalFrame inFrame;
	String title;
	public BAListener(InternalFrame inFrame,String title){
		this.inFrame=inFrame;
		this.title=title;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(inFrame==null||inFrame.isClosable()){
			JInternalFrame[]allFrames=desktopPane.getAllFrames();
			int titleBarHight=30*allFrames.length;
			int x=10+titleBarHight,y=x;
			int width=250,height=180;
			inFrame=new InternalFrame(title);
			inFrame.setBounds(x, y, width, height);
			inFrame.setVisible(true);
			desktopPane.add(inFrame);
		}
		try {
			inFrame.setSelected(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
@SuppressWarnings("serial")
class InternalFrame extends JInternalFrame{
	public InternalFrame(String title){
		super();
		setTitle(title);//设置内部窗体的标题
		setResizable(true);//设置准许自由调整大小
		setClosable(true);//设置提供“关闭”按钮
		setIconifiable(true);//设置提供“最小化”按钮
		setMaximizable(true);//设置提供“最大化”按钮
		URL resource =this.getClass().getResource("/image/1.jpg");//获得图片的路径
		ImageIcon icon=new ImageIcon(resource);//创建图片对象
		setFrameIcon(icon);//设置窗体图标
	}
}