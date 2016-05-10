package com.java.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

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
    	
    	 final JToolBar tool=new JToolBar("gongjulan");
  	     tool.setFloatable(false);
         getContentPane().add(tool,BorderLayout.NORTH);
         final JButton b1=new JButton("Project_mast");
         b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new one("11");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
         tool.add(b1);
         tool.addSeparator();
         
         
         final JButton b2=new JButton("Bx_mast");
         b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new two();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
         tool.add(b2);
         tool.addSeparator();
        final JLabel timeLabel=new JLabel();
    	timeLabel.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    	tool.add(timeLabel);
    	tool.addSeparator();
    	final JLabel backLabel=new JLabel();
    	URL resource =this.getClass().getResource("/image/1.jpg");
    	ImageIcon icon=new ImageIcon(resource);//创建背景图片对象
    	backLabel.setIcon(icon);
    	backLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
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
class one extends InternalFrame{
	
	one(String title){
		super(title);
		  JFrame jf=new JFrame("Simple JFrame application");
		  Container cp=jf.getContentPane();
		  jf.setSize(200,300);
		  jf.setVisible(true);
		  //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class two {

	two(){
		  JFrame jf=new JFrame("Simple JFrame application");
		  Container cp=jf.getContentPane();
		  jf.setSize(200,300);
		  jf.setVisible(true);
		  //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		two de=new two();
	}

}