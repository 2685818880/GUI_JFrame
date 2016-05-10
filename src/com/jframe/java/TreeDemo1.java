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

top = new DefaultMutableTreeNode("��ɽ");

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

jingdian = new DefaultMutableTreeNode("����");

jingdian.add(new DefaultMutableTreeNode("����1"));

jingdian.add(new DefaultMutableTreeNode("����2"));

jiaotong = new DefaultMutableTreeNode("��ͨ");

jiaotong.add(new DefaultMutableTreeNode("·��1"));

jiaotong.add(new DefaultMutableTreeNode("·��2"));

jiaotong.add(new DefaultMutableTreeNode("·��3"));

zhusu = new DefaultMutableTreeNode("ס��");

zhusu.add(new DefaultMutableTreeNode("Aס��"));

zhusu.add(new DefaultMutableTreeNode("Bס��"));

zhusu.add(new DefaultMutableTreeNode("Cס��"));

binguan = new DefaultMutableTreeNode("����");

binguan.add(new DefaultMutableTreeNode("X����"));

binguan.add(new DefaultMutableTreeNode("Y����"));

binguan.add(new DefaultMutableTreeNode("Z����"));

binguan.add(new DefaultMutableTreeNode("XYZ����"));

luying = new DefaultMutableTreeNode("¶Ӫ");

luying.add(new DefaultMutableTreeNode("��ʽ1"));

luying.add(new DefaultMutableTreeNode("��ʽ2"));

jiesu = new DefaultMutableTreeNode("����");

jiesu.add(new DefaultMutableTreeNode("����1"));

jiesu.add(new DefaultMutableTreeNode("����2"));

jiesu.add(new DefaultMutableTreeNode("����3"));

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

jEditorPane.setText("��ɽ�ļ��");

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