package com.java.test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.java.main.Bx_mast;
import com.java.main.Project_mast;

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
				new Bx_mast();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if("退出".equals(menuitem.getText())){
			System.exit(1);
		}
	}

}

public class main extends JFrame {
	public static void main(String[] args) {
		main frame = new main();
		frame.setVisible(true);
	}

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu,menu1;
	private JMenuItem menuitem1, menuitem2, menuitem3;

	public main() {
		super();
		

		setTitle("AccountManager");
		setBounds(100, 100, 780, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JSplitPane hs = new JSplitPane();
		hs.setDividerLocation(200);// 左边的宽度为40
		getContentPane().add(hs, BorderLayout.CENTER);// 在水平面板左侧添加一个标签组件t
		
		
		DefaultMutableTreeNode root =new DefaultMutableTreeNode("ROOT");
		DefaultMutableTreeNode node1=new DefaultMutableTreeNode("11");
		root.add(node1);
		DefaultMutableTreeNode node2=new DefaultMutableTreeNode("111",false);//创建不润许有子节点的二级节点
		node1.add(node2);
		DefaultMutableTreeNode node3=new DefaultMutableTreeNode("22");
		root.add(node3);
		DefaultMutableTreeNode node4=new DefaultMutableTreeNode("222",false);//创建不润许有子节点的二级节点
		node3.add(node4);
		
		JTree treeRoot=new JTree(root);
		getContentPane().add(treeRoot,BorderLayout.WEST);
		DefaultTreeModel treemodel =new DefaultTreeModel(root);
		/*JTree treedefault =new JTree(treemodel);
		getContentPane().add(treedefault,BorderLayout.CENTER);
		DefaultTreeModel treemodel2=new DefaultTreeModel(root,true);
		JTree treepont =new JTree(treemodel2);
		getContentPane().add(treepont,BorderLayout.EAST);*/
		
		//定制树
		JTree tree=new JTree();
		tree.setRootVisible(false);
		tree.setRowHeight(20);
		tree.setFont(new Font("宋体",Font.BOLD,14));
		tree.putClientProperty("JTree.lineStyle", "None");
		DefaultTreeCellRenderer treerd;
		treerd=(DefaultTreeCellRenderer) tree.getCellRenderer();
		treerd.setLeafIcon(null);
		treerd.setClosedIcon(null);
		treerd.setOpenIcon(null);
		Enumeration<?>enume=root.preorderEnumeration();
		while(enume.hasMoreElements()){
			DefaultMutableTreeNode nodes;
			nodes=(DefaultMutableTreeNode) enume.nextElement();
			if(!nodes.isLeaf()){
				TreePath path=new TreePath(nodes.getPath());
				tree.expandPath(path);
			}
		}
		
	
		
		hs.setLeftComponent(tree);
		final JSplitPane vs = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vs.setDividerLocation(30);
		vs.setDividerSize(8);// 分割条的宽度为8像素
		//vs.setOneTouchExpandable(true);// 提供UI小部件
		//vs.setContinuousLayout(true);
		hs.setRightComponent(vs);// 添加到水平面板的右侧
	    vs.setLeftComponent(new JLabel("    2"));//在垂直面板上方添加一个标签组件
		JLabel label = new JLabel("   3");// //在垂直面板xia方添加一个标签组件
		//vs.setRightComponent(label);
		/*label.setText("操作人员："
				+ Login.s
				+ "操作时间："
				+ new SimpleDateFormat("yyyy--MM--dd HH:mm:ss")
						.format(new Date()));*/

		setJMenuBar(menuBar);
		menu = new JMenu("菜单名称");
		menu1=new JMenu("操作人员:"+Login.s+"    "+"操作时间："
				+ new SimpleDateFormat("yyyy--MM--dd HH:mm:ss")
		.format(new Date()));
		menuBar.add(menu);
		menuBar.add(menu1);
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
