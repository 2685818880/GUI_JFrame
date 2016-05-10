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
		System.out.println("�����Ĳ˵��" + menuitem.getText());
		if("���Ż�����Ϣ".equals(menuitem.getText())){
			try {
				new Project_mast();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("��Ա������Ϣ".equals(menuitem.getText())){
			try {
				new Help();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("�˳�".equals(menuitem.getText())){
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

		setTitle("�ָ����");
		setBounds(100, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JSplitPane hs = new JSplitPane();
		hs.setDividerLocation(200);// ��ߵĿ��Ϊ40
		getContentPane().add(hs, BorderLayout.CENTER);// ��ˮƽ���������һ����ǩ���
		hs.setLeftComponent(new JLabel("  1"));
		final JSplitPane vs = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vs.setDividerLocation(30);
		vs.setDividerSize(8);// �ָ����Ŀ��Ϊ8����
		vs.setOneTouchExpandable(true);// �ṩUIС����
		vs.setContinuousLayout(true);
		hs.setRightComponent(vs);// ��ӵ�ˮƽ�����Ҳ�
		// vs.setLeftComponent(new JLabel("    2"));//�ڴ�ֱ����Ϸ����һ����ǩ���
		JLabel label = new JLabel("   3");// //�ڴ�ֱ���xia�����һ����ǩ���
		vs.setRightComponent(label);
		label.setText("������Ա��"
				+ Login.s
				+ "����ʱ��"
				+ new SimpleDateFormat("yyyy--MM--ddd HH:mm:ss")
						.format(new Date()));

		setJMenuBar(menuBar);
		menu = new JMenu("�˵�����");
		menuBar.add(menu);
		menuitem1 = new JMenuItem("���Ż�����Ϣ");
		menuitem1.addActionListener(new ItemListener());
		menuitem2 = new JMenuItem("��Ա������Ϣ");
		menuitem2.addActionListener(new ItemListener());
		menuitem3 = new JMenuItem("�˳�");
		menuitem3.addActionListener(new ItemListener());
		menu.add(menuitem1);
		menu.add(menuitem2);
		menu.add(menuitem3);
		menuBar.setVisible(true);
		setVisible(true);
		
	}
}

