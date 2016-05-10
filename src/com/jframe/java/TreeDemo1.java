package com.jframe.java;
import java.awt.GridLayout;

import javax.swing.JEditorPane;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTree;

import javax.swing.SwingUtilities;

import javax.swing.UIManager;

import javax.swing.event.TreeSelectionEvent;

import javax.swing.event.TreeSelectionListener;

import javax.swing.tree.DefaultMutableTreeNode;

import javax.swing.tree.TreeSelectionModel;

public class TreeDemo1 extends JFrame implements TreeSelectionListener {

private static final long serialVersionUID = 1L;

private JPanel jContentPane = null;

private JTree jTree = null;

private JEditorPane jEditorPane = null;

private JScrollPane jScrollPane = null;

public JScrollPane getjScrollPane() {

if(jScrollPane==null){

jScrollPane = new JScrollPane();

jScrollPane.setViewportView(getJTree());

}

return jScrollPane;

}

DefaultMutableTreeNode top = null; // @jve:decl-index=0:

/**

 * This is the default constructor

 */

public TreeDemo1() {

super();

initialize();

}

/**

 * This method initializes this

 * 

 * @return void

 */

private void initialize() {

this.setSize(438, 309);

this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

this.setContentPane(getJContentPane());

this.setTitle("JFrame");

}

/**

 * This method initializes jContentPane

 * 

 * @return javax.swing.JPanel

 */

private JPanel getJContentPane() {

if (jContentPane == null) {

GridLayout gridLayout = new GridLayout();

gridLayout.setRows(1);

gridLayout.setColumns(2);

jContentPane = new JPanel();

jContentPane.setLayout(gridLayout);

jContentPane.add(getjScrollPane(), null);

jContentPane.add(getJEditorPane(), null);

}

return jContentPane;

}

/**

 * This method initializes jTree

 * 

 * @return javax.swing.JTree

 */

private JTree getJTree() {

if (jTree == null) {

top = new DefaultMutableTreeNode("黄山");

createNodes(top);

jTree = new JTree(top);

jTree.getSelectionModel().setSelectionMode(

TreeSelectionModel.SINGLE_TREE_SELECTION);

jTree.addTreeSelectionListener(this);

}

return jTree;

}

private void createNodes(DefaultMutableTreeNode top) {

DefaultMutableTreeNode jingdian = null, jiaotong = null, zhusu = null, binguan = null, luying = null, jiesu = null;

jingdian = new DefaultMutableTreeNode("景点");

jingdian.add(new DefaultMutableTreeNode("景点1"));

jingdian.add(new DefaultMutableTreeNode("景点2"));

jiaotong = new DefaultMutableTreeNode("交通");

jiaotong.add(new DefaultMutableTreeNode("路线1"));

jiaotong.add(new DefaultMutableTreeNode("路线2"));

jiaotong.add(new DefaultMutableTreeNode("路线3"));

zhusu = new DefaultMutableTreeNode("住宿");

zhusu.add(new DefaultMutableTreeNode("A住宿"));

zhusu.add(new DefaultMutableTreeNode("B住宿"));

zhusu.add(new DefaultMutableTreeNode("C住宿"));

binguan = new DefaultMutableTreeNode("宾馆");

binguan.add(new DefaultMutableTreeNode("X宾馆"));

binguan.add(new DefaultMutableTreeNode("Y宾馆"));

binguan.add(new DefaultMutableTreeNode("Z宾馆"));

binguan.add(new DefaultMutableTreeNode("XYZ宾馆"));

luying = new DefaultMutableTreeNode("露营");

luying.add(new DefaultMutableTreeNode("方式1"));

luying.add(new DefaultMutableTreeNode("方式2"));

jiesu = new DefaultMutableTreeNode("借宿");

jiesu.add(new DefaultMutableTreeNode("借宿1"));

jiesu.add(new DefaultMutableTreeNode("借宿2"));

jiesu.add(new DefaultMutableTreeNode("借宿3"));

top.add(jingdian);

top.add(jiaotong);

top.add(zhusu);

top.add(binguan);

top.add(luying);

top.add(jiesu);

}

/**

 * This method initializes jEditorPane

 * 

 * @return javax.swing.JEditorPane

 */

private JEditorPane getJEditorPane() {

if (jEditorPane == null) {

jEditorPane = new JEditorPane();

}

return jEditorPane;

}

@Override

public void valueChanged(TreeSelectionEvent e) {

DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree

.getLastSelectedPathComponent();

if (node == null)

// Nothing is selected.

return;

if(node.isRoot()){

jEditorPane.setText("黄山的简介");

}

}

public static void main(String[] args) {

SwingUtilities.invokeLater(new Runnable() {

@Override

public void run() {

try {

UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

}catch(Exception e){

e.printStackTrace();

}

new TreeDemo1().setVisible(true);

}

});

}

}