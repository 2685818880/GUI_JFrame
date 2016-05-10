package com.applet.java;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;
 
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameUI;
 
/**
 * MDIFrame is a frame using JInternalFrame to implements MDI as Word on
 * Windows.
 *
 * @author Cheng
 * @version 1.0.0 for GPF MDI test
 */
@SuppressWarnings("serial")
public class MDIFrame extends JFrame {
 
    /** The desktop pane. */
    final JDesktopPane desktopPane = new JDesktopPane();
 
    /** The operation pane with restore and close buttons. */
    final JPanel opPane = new JPanel();
 
    /**
     * Instantiates a new mDI frame.
     */
    public MDIFrame() {
        setTitle("MDI Frame");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        final JMenuBar bar = new JMenuBar();
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
 
        });
        bar.add(exit);
        // operation pane with two button, set invisible at first
        opPane.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JButton restore = new JButton("#");
        restore.setMargin(new Insets(0, 0, 0, 0));
        restore.setPreferredSize(new Dimension(15, 15));
        restore.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                InnerFrame i = (InnerFrame) desktopPane.getSelectedFrame();
                try {
                    // notice this method, when JInternalFrame set maximun false
                    // this internal frame will be set as old size
                    i.setMaximum(false);
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }
                i.showNorthPanel();
                opPane.setVisible(false);
            }
 
        });
        opPane.add(restore);
        JButton close = new JButton("X");
        close.setMargin(new Insets(0, 0, 0, 0));
        close.setPreferredSize(new Dimension(15, 15));
        close.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame i = desktopPane.getSelectedFrame();
                i.dispose();
                opPane.setVisible(false);
            }
 
        });
        opPane.add(close);
        bar.add(opPane);
        opPane.setVisible(false);
        setJMenuBar(bar);
 
        Container content = getContentPane();
        content.add(desktopPane, BorderLayout.CENTER);
        final JPanel ctrlPane = new JPanel();
        JButton add = new JButton("add");
        add.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                InnerFrame iFrame = new InnerFrame();
                iFrame.setVisible(true);
                desktopPane.add(iFrame);
            }
 
        });
        ctrlPane.add(add);
        content.add(ctrlPane, BorderLayout.SOUTH);
        setVisible(true);
    }
 
    /**
     * The Class InnerFrame.
     */
    class InnerFrame extends JInternalFrame {
 
        /** The is hidden. */
        boolean isHidden = false;
 
        /** The old ui. */
        BasicInternalFrameUI oldUi = null;
 
        /**
         * Instantiates a new inner frame.
         */
        public InnerFrame() {
            oldUi = (BasicInternalFrameUI) getUI();
            setSize(200, 200);
            maximizable = true;
            closable = true;
            addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    InnerFrame selectedFrame = (InnerFrame) e.getSource();
                    if (selectedFrame.isMaximum()) {
                        selectedFrame.hideNorthPanel();
                        opPane.setVisible(true);
                        try {
                            selectedFrame.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
        }
 
        /**
         * Hide north panel.
         */
        public void hideNorthPanel() {
            ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
            this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
            isHidden = true;
        }
 
        /**
         * Show north panel.
         */
        public void showNorthPanel() {
            this.setUI(oldUi);
            this.putClientProperty("JInternalFrame.isPalette", Boolean.FALSE);
            isHidden = false;
        }
 
        /*
         * (non-Javadoc)
         *
         * @see javax.swing.JInternalFrame#updateUI()
         */
        public void updateUI() {
            super.updateUI();
            if (isHidden) {
                hideNorthPanel();
            }
        }
    }
 
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
 
            @Override
            public void run() {
                new MDIFrame();
            }
 
        });
    }
}