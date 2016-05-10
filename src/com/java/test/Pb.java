package com.java.test;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.geom.*;
import java.io.*;
class Point implements Serializable
{     int x,y;
    Color col;
    int tool;
    int boarder;   
    Point(int x, int y, Color col, int tool, int boarder)
    {     //this.t=t;
        this.x = x;
        this.y = y;
        this.col = col;
        this.tool = tool;
        this.boarder = boarder;
    }
}
class paintboard extends Frame implements ActionListener,MouseMotionListener,MouseListener,ItemListener
{     int t=0;
    double t1;
    double t2;
    double t3;
    double dou1;
    String s;
    int x = -1;
    int y = -1;
    int con = 1;//画笔大小
    int Econ = 5;//橡皮大小     
    int toolFlag = 0;//toolFlag:工具标记
    //toolFlag工具对应表：
    //（0--画笔）；（1--橡皮）；（2--清除）； （3--直线）；（4--圆）；（5--矩形）；     
    Color c = new Color(0,0,0); //画笔颜色
    BasicStroke size = new BasicStroke(con,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);//画笔粗细
    Point cutflag = new Point(-1, -1, c, 6, con);//截断标志     
    Vector paintInfo = null;//点信息向量组
    int n = 1;     
    FileInputStream picIn = null;
    FileOutputStream picOut = null;
    ObjectInputStream VIn = null;
    ObjectOutputStream VOut = null;
    MenuBar bar;
    Menu B,C,D;
    // *工具面板--画笔，直线，圆，矩形，多边形,橡皮，清除*/
    Panel toolPanel;
    MenuItem pen,drLine,drCircle,drRect;
    Button clear ,eraser;
    Choice ColChoice,SizeChoice,EraserChoice;
    Button colchooser;
    Label 颜色,大小B,大小E;
    MenuItem newPic,openPic,savePic,exitPic;
    FileDialog newPicture,openPicture,savePicture;
    MenuItem Calculator,Clock;
    paintboard(String s)
    {     super(s);
        addMouseMotionListener(this);
        addMouseListener(this);        
        paintInfo = new Vector();        
        /*各工具按钮及选择项*/
        //颜色选择
        ColChoice = new Choice();
        ColChoice.add("black");
        ColChoice.add("red");
        ColChoice.add("blue");
        ColChoice.add("green");
        ColChoice.addItemListener(this);
        //画笔大小选择
        SizeChoice = new Choice();
        SizeChoice.add("1");
        SizeChoice.add("3");
        SizeChoice.add("5");
        SizeChoice.add("7");
        SizeChoice.add("9");
        SizeChoice.addItemListener(this);
        //橡皮大小选择
        EraserChoice = new Choice();
        EraserChoice.add("5");
        EraserChoice.add("9");
        EraserChoice.add("13");
        EraserChoice.add("17");
        EraserChoice.addItemListener(this);
        toolPanel = new Panel();         
        clear = new Button("清除");
        eraser = new Button("橡皮");
        pen = new MenuItem("画笔");
        drLine = new MenuItem("画直线");
        drCircle = new MenuItem("画圆形");
        drRect = new MenuItem("画矩形");
        bar=new MenuBar();
        B=new Menu("文件");
        C=new Menu("工具");
        D=new Menu("操作");   
        newPic=new MenuItem("新建画图");
        openPic = new MenuItem("打开图画");
        savePic = new MenuItem("保存图画");
        exitPic = new MenuItem("退出画图");
        Calculator =new MenuItem("计算器");
        Clock=new MenuItem("时钟");        
        colchooser = new Button("显示调色板");        
        //各组件事件监听
        clear.addActionListener(this);
        eraser.addActionListener(this);
        pen.addActionListener(this);
        drLine.addActionListener(this);
        drCircle.addActionListener(this);
        drRect.addActionListener(this);
        openPic.addActionListener(this);
        savePic.addActionListener(this);
        colchooser.addActionListener(this);
        newPic.addActionListener(this);
        exitPic.addActionListener(this);
        Calculator.addActionListener(this);
        Clock.addActionListener(this);        
        颜色 = new Label("画笔颜色",Label.CENTER);
        大小B = new Label("画笔大小",Label.CENTER);
        大小E = new Label("橡皮大小",Label.CENTER);
        //面板添加组件
        setMenuBar(bar);
        bar.add(B);
        B.add(newPic);
        B.add(openPic);
        B.add(savePic);
        B.add(exitPic);
        bar.add(C);
        C.add(pen);
        C.add(drLine);
        C.add(drCircle);
        C.add(drRect);
        bar.add(D);
        D.add(Calculator);
        D.add(Clock);
        toolPanel.add(颜色); toolPanel.add(ColChoice);
        toolPanel.add(大小B); toolPanel.add(SizeChoice);
        toolPanel.add(colchooser);         
        toolPanel.add(eraser);
        toolPanel.add(大小E); toolPanel.add(EraserChoice);         
        toolPanel.add(clear);
        //工具面板到APPLET面板     
        add(toolPanel,BorderLayout.NORTH);         
        setBounds(60,60,900,600); setVisible(true);
        validate();
        newPicture = new FileDialog(this,"新建图画",FileDialog.LOAD);
        newPicture.setVisible(false);
        openPicture = new FileDialog(this,"打开图画",FileDialog.LOAD);
        openPicture.setVisible(false);
        savePicture = new FileDialog(this,"保存图画",FileDialog.SAVE);
        savePicture.setVisible(false);
        openPicture.addWindowListener(new WindowAdapter()
        {     public void windowClosing(WindowEvent e)
            { openPicture.setVisible(false); }
        });
        savePicture.addWindowListener(new WindowAdapter()
        {     public void windowClosing(WindowEvent e)
            { savePicture.setVisible(false); }
        });
        addWindowListener(new WindowAdapter()
        {
        public void windowClosing(WindowEvent e)
        { System.exit(0);}
        });
    }
    private void MenuBar(MenuBar bar2) {// TODO Auto-generated method stub        
    }
    private void setButton(Button bar2) {// TODO Auto-generated method stub        
    }
    public void paint(Graphics g)
    {     Graphics2D g2d = (Graphics2D)g;
        Point p1,p2;         
        n = paintInfo.size();
        if(toolFlag==2)
        g.clearRect(0,0,getSize().width,getSize().height);//清除         
        for(int i=0; i<n ;i++)
        {     p1 = (Point)paintInfo.elementAt(i);
            p2 = (Point)paintInfo.elementAt(i+1);
            size = new BasicStroke(p1.boarder,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);            
            g2d.setColor(p1.col);
            g2d.setStroke(size);     
            if(p1.tool==p2.tool)
            {     switch(p1.tool)
                {     case 0://画笔            
                    Line2D line1 = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
                    g2d.draw(line1);
                    break;            
                    case 1://橡皮
                    g.clearRect(p1.x, p1.y, p1.boarder, p1.boarder);
                    break;
                    case 3://画直线
                    Line2D line2 = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
                    g2d.draw(line2);
                    break;            
                    case 4://画圆
                    Ellipse2D ellipse = new Ellipse2D.Double(p1.x, p1.y, Math.abs(p2.x-p1.x) , Math.abs(p2.y-p1.y));
                    g2d.draw(ellipse);
                    break;                     
                    case 5://画矩形
                    Rectangle2D rect = new Rectangle2D.Double(p1.x, p1.y, Math.abs(p2.x-p1.x) , Math.abs(p2.y-p1.y));
                    g2d.draw(rect);
                    break;                     
                    case 6://截断，跳过
                    i=i+1;
                    break;
                    default :
                }//end switch
            }//end if
        }//end for
    }     
    public void itemStateChanged(ItemEvent e)
    {     if(e.getSource()==ColChoice)//预选颜色
        {     String name = ColChoice.getSelectedItem();            
            if(name=="black")
            {c = new Color(0,0,0); }
            else if(name=="red")
                {c = new Color(255,0,0);}
                else if(name=="green")
                    {c = new Color(0,255,0);}
                    else if(name=="blue")
                        {c = new Color(0,0,255);}
        }
        else if(e.getSource()==SizeChoice)//画笔大小
            {     String selected = SizeChoice.getSelectedItem();               
                if(selected=="1")
                { con = 1; size = new BasicStroke(con,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL); }
                else if(selected=="3")
                    {con = 3; size = new BasicStroke(con,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);}
                    else if(selected=="5")
                        {con = 5; size = new BasicStroke(con,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL); }
                        else if(selected=="7")
                                {con = 7;size = new BasicStroke(con,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);}
                            else if(selected=="9")
                                {con = 9;size = new BasicStroke(con,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);}
            }//end画笔  
            else if(e.getSource()==EraserChoice)//橡皮大小
                {String Esize = EraserChoice.getSelectedItem();                 
                if(Esize=="5")
                { Econ = 5*2; }
                    else if(Esize=="9")
                        { Econ = 9*2; }
                        else if(Esize=="13")
                            { Econ = 13*2; }
                            else if(Esize=="17")
                                { Econ = 17*3; }
                }//end 橡皮擦大小
    }     
    public void mouseDragged(MouseEvent e)
    {     Point p1 ;
        switch(toolFlag)
        {     case 0://画笔
            x = (int)e.getX();
            y = (int)e.getY();
            p1 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p1);
            repaint();
            break;            
            case 1://橡皮
            x = (int)e.getX();
            y = (int)e.getY();
            p1 = new Point(x, y, null, toolFlag, Econ);
            paintInfo.addElement(p1);
            repaint();
            break;   
            default :
        }
    }
    public void mouseMoved(MouseEvent e) {}     
    public void update(Graphics g)
    { paint(g);}
    public void mousePressed(MouseEvent e)
    {     Point p2;
        switch(toolFlag)
        {     case 3://直线
            x = (int)e.getX();
            y = (int)e.getY();
            p2 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p2);
            break;
                        case 4: //圆
            x = (int)e.getX();
            y = (int)e.getY();
            p2 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p2);
            break;
            case 5: //矩形
            x = (int)e.getX();
            y = (int)e.getY();
            p2 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p2);
            break;
            
            default :
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        Point p3;
        switch(toolFlag)
        {
            case 0://画笔
            paintInfo.addElement(cutflag);
            break;
            
            case 1: //eraser
            paintInfo.addElement(cutflag);
            break;
   
            case 3://直线
            x = (int)e.getX();
            y = (int)e.getY();
            p3 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p3);
            paintInfo.addElement(cutflag);
            repaint();
            break;
   
            case 4: //圆
            x = (int)e.getX();
            y = (int)e.getY();
            p3 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p3);
            paintInfo.addElement(cutflag);
            repaint();
            break;

            case 5: //矩形
            x = (int)e.getX();
            y = (int)e.getY();
            p3 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p3);
            paintInfo.addElement(cutflag);
            repaint();
            break;
   
            default:
        }
    }

    public void mouseEntered(MouseEvent e){}   
    public void mouseExited(MouseEvent e){}     
    public void mouseClicked(MouseEvent e){}
   
    public void actionPerformed(ActionEvent e)
    {     if(e.getSource()==pen)//画笔
        {toolFlag = 0;}        
        if(e.getSource()==eraser)//橡皮
        {toolFlag = 1;}         
        if(e.getSource()==clear)//清除
        {toolFlag = 2;
        paintInfo.removeAllElements();
        repaint();
        }

        if(e.getSource()==drLine)//画线
        {toolFlag = 3;}        
        if(e.getSource()==drCircle)//画圆
        {toolFlag = 4;}        
        if(e.getSource()==drRect)//画矩形
        {toolFlag = 5;}
   
        if(e.getSource()==colchooser)//调色板
        {Color newColor = JColorChooser.showDialog(this,"调色板",c);    c= newColor;}
   
        if(e.getSource()==newPic)//新建画图------个人添加
        {    int n = JOptionPane.showConfirmDialog(null, "是否先保存所做的更改?新建后请先在操作中先选定画笔在操作", "新建画图框", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                savePicture.setVisible(true);
                try{
                    File fileout = new File(savePicture.getDirectory(),savePicture.getFile());
                    picOut = new FileOutputStream(fileout);
                    VOut = new ObjectOutputStream(picOut);
                    VOut.writeObject(paintInfo);
                    VOut.close();
                    }
                catch(IOException IOe)
                {
                System.out.println("can not write object"); }
                toolFlag = 2;
                paintInfo.removeAllElements();
                repaint();
                //清除
                toolFlag = 2;
                paintInfo.removeAllElements();
                repaint();
                }
             else if (n == JOptionPane.NO_OPTION)
             {     toolFlag = 2;
                paintInfo.removeAllElements();
                repaint();
            }     
        }
        
        if(e.getSource()==openPic)//打开图画
        {    //打开
            openPicture.setVisible(true);
            if(openPicture.getFile()!=null)
            {     //清除
                toolFlag = 2;
                paintInfo.removeAllElements();
                repaint();//打开
                int tempflag;
                tempflag = toolFlag;
                toolFlag = 2 ;
                repaint();                 
                try    {paintInfo.removeAllElements();
                    File filein = new File(openPicture.getDirectory(),openPicture.getFile());
                    picIn = new FileInputStream(filein);
                    VIn = new ObjectInputStream(picIn);
                    paintInfo = (Vector)VIn.readObject();
                    VIn.close();
                    repaint();
                    toolFlag = tempflag;}                 
                catch(ClassNotFoundException IOe2)
                {repaint();
                toolFlag = tempflag;
                System.out.println("can not read object");}
                catch(IOException IOe)
                {repaint();
                toolFlag = tempflag;
                System.out.println("can not read file");}
            }     
        }
        
        if(e.getSource()==savePic)//保存图画
        {
            savePicture.setVisible(true);
            try
            {
                File fileout = new File(savePicture.getDirectory(),savePicture.getFile());
                picOut = new FileOutputStream(fileout);
                VOut = new ObjectOutputStream(picOut);
                VOut.writeObject(paintInfo);
                VOut.close();
            }
            catch(IOException IOe)
            {
                System.out.println("can not write object");
            }
        }
        
        if(e.getSource()==exitPic)//退出画图
        {
        int n = JOptionPane.showConfirmDialog(null, "确认退出吗?", "确认退出框", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            System.exit(1);
        } else if (n == JOptionPane.NO_OPTION) {
        } }
        //时钟
        if(e.getSource()==Clock)
        {Clock.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Calendar c=Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int date=c.get(Calendar.DATE);
                int hour=c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.MINUTE);
                int month2 = month+1;
                    String a=year+"年"+month2+"月"+date+"日"+hour+":"+minute;
                     int n = JOptionPane.showConfirmDialog(null, a, "当前时间为",JOptionPane.OK_CANCEL_OPTION);
                       }
           });}
        //计算器程序
        if(e.getSource()==Calculator){
            Frame f=new Frame("计算器");
            Panel mp;
            final TextField text=new  TextField();
            class button1a implements ActionListener{               
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+1; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button2a implements ActionListener{                                
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+2; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button3a implements ActionListener{


                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+3; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button4a implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+4; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button5a implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+5; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button6a implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+6; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button7a implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+7; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button8a implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+8; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button9a implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+9; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class button0a implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    double dou1 = 0;
                    String s=text.getText();
                    try{dou1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    dou1=dou1*10+0; s=Double.toString(dou1);
                    text.setText(s);
                }}
            class buttonjiaa implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    t=1;
                    String s=text.getText();
                    try{t1=Double.valueOf(s).doubleValue();  }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    double dou1=0;s=Double.toString(dou1);
                    text.setText(s);
                    
                }}
            class buttonjiana implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    t=2;
                    String s=text.getText();
                    try{t1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    double dou1=0;s=Double.toString(dou1);
                    text.setText(s);
                }}
            class buttonchena implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    t=3;
                    String s=text.getText();
                    try{t1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                    double dou1=0;s=Double.toString(dou1);
                    text.setText(s);
                }}
            class buttonchua implements ActionListener{
               
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    //if(doul=0){}
                    //int t=4;double t1;
                    t=4;
                    String s=text.getText();
                    try{t1=Double.valueOf(s).doubleValue();   }
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("请输入数字");}
                    double dou1=0;s=Double.toString(dou1);
                    text.setText(s);
                }}
            class buttondenga implements ActionListener{
               
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    switch(t){
                    case 0:text.setText("");;break;
                     case 1:String s=text.getText();
                         try{t2=Double.valueOf(s).doubleValue();   }
                        catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                        double t3=t1+t2;s=Double.toString(t3);text.setText(s);break;
                     case 2:String s1=text.getText();
                             try{t2=Double.valueOf(s1).doubleValue();   }
                        catch(NumberFormatException lexicalXSDInt ){System.out.println("请输入数字");}
                        double t31=t1-t2;s1=Double.toString(t31);text.setText(s1);break;
                     case 3:String s11=text.getText();
                         try{t2=Double.valueOf(s11).doubleValue();   }
                        catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                        double t311=t1*t2;s11=Double.toString(t311);text.setText(s11);break;
                     case 4:String s111=text.getText();
                         try{t2=Double.valueOf(s111).doubleValue();   }
                        catch(NumberFormatException lexicalXSDInt ){System.out.println("");}
                        double t3111=t1/t2;s111=Double.toString(t3111);text.setText(s111);break;
                     default:break;
                     }
                }

                }
            class buttonqca implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    text.setText("");
                }}   
            //定义按钮，以及注册监听器
            Button button7=new Button("7");
            button7.addActionListener(new button7a());
            Button button8=new Button("8");
            button8.addActionListener(new button8a());
            Button button9=new Button("9");
            button9.addActionListener(new button9a());
            Button buttonjia=new Button("+");
            buttonjia.addActionListener(new buttonjiaa());
            Button button4=new Button("4");
            button4.addActionListener(new button4a());
            Button button5=new Button("5");
            button5.addActionListener(new button5a());
            Button button6=new Button("6");
            button6.addActionListener(new button6a());
            Button buttonjian=new Button("-");
            buttonjian.addActionListener(new buttonjiana());
            Button button1=new Button("1");
            button1.addActionListener(new button1a());
            Button button2=new Button("2");
            button2.addActionListener(new button2a());
            Button button3=new Button("3");
            button3.addActionListener(new button3a());
            Button buttonchen=new Button("*");
            buttonchen.addActionListener(new buttonchena());
            Button buttonqc=new Button("清除");
            buttonqc.addActionListener(new buttonqca());
            Button button0=new Button("0");
            button0.addActionListener(new button0a());
            Button buttondeng=new Button("=");
            buttondeng.addActionListener(new buttondenga());
            Button buttonchu=new Button("/");
            buttonchu.addActionListener(new buttonchua());
            //添加按钮以及文本框
            mp=new Panel();            
            f.add("North",text);
            mp.setLayout(new GridLayout(5,5));
            add("Center",mp);
            mp.add(button7);
            mp.add(button8);
            mp.add(button9);
            mp.add(buttonjia);
            mp.add(button4);
            mp.add(button5);
            mp.add(button6);
            mp.add(buttonjian);
            mp.add(button1);
            mp.add(button2);
            mp.add(button3);
            mp.add(buttonchen);
            mp.add(buttonqc);
            mp.add(button0);
            mp.add(buttondeng);
            mp.add(buttonchu);
            //设置对话框
            f.add(mp);
            f.setSize(250,250);
            f.setVisible(true);
            text.setText("");
            String s=text.getText();            
            f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){System.exit(0);}
            });            
        }//end calculator            
    }//end actionPerformed
}//end paintboard
public class Pb
{
    public static void main(String args[])
     { new paintboard("画图程序"); }
} 