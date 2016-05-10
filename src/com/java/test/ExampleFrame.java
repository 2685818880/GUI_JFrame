package com.java.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;

import com.Main.java.Bx_mast;
import com.Main.java.Login;
import com.Main.java.Project_mast;

class ItemListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuitem = (JMenuItem) e.getSource();
		System.out.println("你点击的菜单项：" + menuitem.getText());
		if("部门基本信息".equals(menuitem.getText())){
			try {
				new Project_mast();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("人员基本信息".equals(menuitem.getText())){
			try {
				new Help();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("退出".equals(menuitem.getText())){
			System.exit(1);
		}
	}

}

public class ExampleFrame extends JFrame {
	public static void main(String[] args) {
		ExampleFrame frame = new ExampleFrame();
		frame.setVisible(true);
	}

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu;
	private JMenuItem menuitem1, menuitem2, menuitem3;

	public ExampleFrame() {
		super();

		setTitle("分割面板");
		setBounds(100, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JSplitPane hs = new JSplitPane();
		hs.setDividerLocation(200);// 左边的宽度为40
		getContentPane().add(hs, BorderLayout.CENTER);// 在水平面板左侧添加一个标签组件
		hs.setLeftComponent(new JLabel("  1"));
		final JSplitPane vs = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vs.setDividerLocation(30);
		vs.setDividerSize(8);// 分割条的宽度为8像素
		vs.setOneTouchExpandable(true);// 提供UI小部件
		vs.setContinuousLayout(true);
		hs.setRightComponent(vs);// 添加到水平面板的右侧
		// vs.setLeftComponent(new JLabel("    2"));//在垂直面板上方添加一个标签组件
		JLabel label = new JLabel("   3");// //在垂直面板xia方添加一个标签组件
		vs.setRightComponent(label);
		label.setText("操作人员："
				+ Login.s
				+ "操作时间"
				+ new SimpleDateFormat("yyyy--MM--ddd HH:mm:ss")
						.format(new Date()));

		setJMenuBar(menuBar);
		menu = new JMenu("菜单名称");
		menuBar.add(menu);
		menuitem1 = new JMenuItem("部门基本信息");
		menuitem1.addActionListener(new ItemListener());
		menuitem2 = new JMenuItem("人员基本信息");
		menuitem2.addActionListener(new ItemListener());
		menuitem3 = new JMenuItem("退出");
		menuitem3.addActionListener(new ItemListener());
		menu.add(menuitem1);
		menu.add(menuitem2);
		menu.add(menuitem3);
		menuBar.setVisible(true);
		setVisible(true);
		
	}
}

