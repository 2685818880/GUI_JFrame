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
    int con = 1;//���ʴ�С
    int Econ = 5;//��Ƥ��С     
    int toolFlag = 0;//toolFlag:���߱��
    //toolFlag���߶�Ӧ��
    //��0--���ʣ�����1--��Ƥ������2--������� ��3--ֱ�ߣ�����4--Բ������5--���Σ���     
    Color c = new Color(0,0,0); //������ɫ
    BasicStroke size = new BasicStroke(con,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);//���ʴ�ϸ
    Point cutflag = new Point(-1, -1, c, 6, con);//�ضϱ�־     
    Vector paintInfo = null;//����Ϣ������
    int n = 1;     
    FileInputStream picIn = null;
    FileOutputStream picOut = null;
    ObjectInputStream VIn = null;
    ObjectOutputStream VOut = null;
    MenuBar bar;
    Menu B,C,D;
    // *�������--���ʣ�ֱ�ߣ�Բ�����Σ������,��Ƥ�����*/
    Panel toolPanel;
    MenuItem pen,drLine,drCircle,drRect;
    Button clear ,eraser;
    Choice ColChoice,SizeChoice,EraserChoice;
    Button colchooser;
    Label ��ɫ,��СB,��СE;
    MenuItem newPic,openPic,savePic,exitPic;
    FileDialog newPicture,openPicture,savePicture;
    MenuItem Calculator,Clock;
    paintboard(String s)
    {     super(s);
        addMouseMotionListener(this);
        addMouseListener(this);        
        paintInfo = new Vector();        
        /*�����߰�ť��ѡ����*/
        //��ɫѡ��
        ColChoice = new Choice();
        ColChoice.add("black");
        ColChoice.add("red");
        ColChoice.add("blue");
        ColChoice.add("green");
        ColChoice.addItemListener(this);
        //���ʴ�Сѡ��
        SizeChoice = new Choice();
        SizeChoice.add("1");
        SizeChoice.add("3");
        SizeChoice.add("5");
        SizeChoice.add("7");
        SizeChoice.add("9");
        SizeChoice.addItemListener(this);
        //��Ƥ��Сѡ��
        EraserChoice = new Choice();
        EraserChoice.add("5");
        EraserChoice.add("9");
        EraserChoice.add("13");
        EraserChoice.add("17");
        EraserChoice.addItemListener(this);
        toolPanel = new Panel();         
        clear = new Button("���");
        eraser = new Button("��Ƥ");
        pen = new MenuItem("����");
        drLine = new MenuItem("��ֱ��");
        drCircle = new MenuItem("��Բ��");
        drRect = new MenuItem("������");
        bar=new MenuBar();
        B=new Menu("�ļ�");
        C=new Menu("����");
        D=new Menu("����");   
        newPic=new MenuItem("�½���ͼ");
        openPic = new MenuItem("��ͼ��");
        savePic = new MenuItem("����ͼ��");
        exitPic = new MenuItem("�˳���ͼ");
        Calculator =new MenuItem("������");
        Clock=new MenuItem("ʱ��");        
        colchooser = new Button("��ʾ��ɫ��");        
        //������¼�����
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
        ��ɫ = new Label("������ɫ",Label.CENTER);
        ��СB = new Label("���ʴ�С",Label.CENTER);
        ��СE = new Label("��Ƥ��С",Label.CENTER);
        //���������
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
        toolPanel.add(��ɫ); toolPanel.add(ColChoice);
        toolPanel.add(��СB); toolPanel.add(SizeChoice);
        toolPanel.add(colchooser);         
        toolPanel.add(eraser);
        toolPanel.add(��СE); toolPanel.add(EraserChoice);         
        toolPanel.add(clear);
        //������嵽APPLET���     
        add(toolPanel,BorderLayout.NORTH);         
        setBounds(60,60,900,600); setVisible(true);
        validate();
        newPicture = new FileDialog(this,"�½�ͼ��",FileDialog.LOAD);
        newPicture.setVisible(false);
        openPicture = new FileDialog(this,"��ͼ��",FileDialog.LOAD);
        openPicture.setVisible(false);
        savePicture = new FileDialog(this,"����ͼ��",FileDialog.SAVE);
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
        g.clearRect(0,0,getSize().width,getSize().height);//���         
        for(int i=0; i<n ;i++)
        {     p1 = (Point)paintInfo.elementAt(i);
            p2 = (Point)paintInfo.elementAt(i+1);
            size = new BasicStroke(p1.boarder,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);            
            g2d.setColor(p1.col);
            g2d.setStroke(size);     
            if(p1.tool==p2.tool)
            {     switch(p1.tool)
                {     case 0://����            
                    Line2D line1 = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
                    g2d.draw(line1);
                    break;            
                    case 1://��Ƥ
                    g.clearRect(p1.x, p1.y, p1.boarder, p1.boarder);
                    break;
                    case 3://��ֱ��
                    Line2D line2 = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
                    g2d.draw(line2);
                    break;            
                    case 4://��Բ
                    Ellipse2D ellipse = new Ellipse2D.Double(p1.x, p1.y, Math.abs(p2.x-p1.x) , Math.abs(p2.y-p1.y));
                    g2d.draw(ellipse);
                    break;                     
                    case 5://������
                    Rectangle2D rect = new Rectangle2D.Double(p1.x, p1.y, Math.abs(p2.x-p1.x) , Math.abs(p2.y-p1.y));
                    g2d.draw(rect);
                    break;                     
                    case 6://�ضϣ�����
                    i=i+1;
                    break;
                    default :
                }//end switch
            }//end if
        }//end for
    }     
    public void itemStateChanged(ItemEvent e)
    {     if(e.getSource()==ColChoice)//Ԥѡ��ɫ
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
        else if(e.getSource()==SizeChoice)//���ʴ�С
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
            }//end����  
            else if(e.getSource()==EraserChoice)//��Ƥ��С
                {String Esize = EraserChoice.getSelectedItem();                 
                if(Esize=="5")
                { Econ = 5*2; }
                    else if(Esize=="9")
                        { Econ = 9*2; }
                        else if(Esize=="13")
                            { Econ = 13*2; }
                            else if(Esize=="17")
                                { Econ = 17*3; }
                }//end ��Ƥ����С
    }     
    public void mouseDragged(MouseEvent e)
    {     Point p1 ;
        switch(toolFlag)
        {     case 0://����
            x = (int)e.getX();
            y = (int)e.getY();
            p1 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p1);
            repaint();
            break;            
            case 1://��Ƥ
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
        {     case 3://ֱ��
            x = (int)e.getX();
            y = (int)e.getY();
            p2 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p2);
            break;
                        case 4: //Բ
            x = (int)e.getX();
            y = (int)e.getY();
            p2 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p2);
            break;
            case 5: //����
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
            case 0://����
            paintInfo.addElement(cutflag);
            break;
            
            case 1: //eraser
            paintInfo.addElement(cutflag);
            break;
   
            case 3://ֱ��
            x = (int)e.getX();
            y = (int)e.getY();
            p3 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p3);
            paintInfo.addElement(cutflag);
            repaint();
            break;
   
            case 4: //Բ
            x = (int)e.getX();
            y = (int)e.getY();
            p3 = new Point(x, y, c, toolFlag, con);
            paintInfo.addElement(p3);
            paintInfo.addElement(cutflag);
            repaint();
            break;

            case 5: //����
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
    {     if(e.getSource()==pen)//����
        {toolFlag = 0;}        
        if(e.getSource()==eraser)//��Ƥ
        {toolFlag = 1;}         
        if(e.getSource()==clear)//���
        {toolFlag = 2;
        paintInfo.removeAllElements();
        repaint();
        }

        if(e.getSource()==drLine)//����
        {toolFlag = 3;}        
        if(e.getSource()==drCircle)//��Բ
        {toolFlag = 4;}        
        if(e.getSource()==drRect)//������
        {toolFlag = 5;}
   
        if(e.getSource()==colchooser)//��ɫ��
        {Color newColor = JColorChooser.showDialog(this,"��ɫ��",c);    c= newColor;}
   
        if(e.getSource()==newPic)//�½���ͼ------�������
        {    int n = JOptionPane.showConfirmDialog(null, "�Ƿ��ȱ��������ĸ���?�½��������ڲ�������ѡ�������ڲ���", "�½���ͼ��", JOptionPane.YES_NO_OPTION);
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
                //���
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
        
        if(e.getSource()==openPic)//��ͼ��
        {    //��
            openPicture.setVisible(true);
            if(openPicture.getFile()!=null)
            {     //���
                toolFlag = 2;
                paintInfo.removeAllElements();
                repaint();//��
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
        
        if(e.getSource()==savePic)//����ͼ��
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
        
        if(e.getSource()==exitPic)//�˳���ͼ
        {
        int n = JOptionPane.showConfirmDialog(null, "ȷ���˳���?", "ȷ���˳���", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            System.exit(1);
        } else if (n == JOptionPane.NO_OPTION) {
        } }
        //ʱ��
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
                    String a=year+"��"+month2+"��"+date+"��"+hour+":"+minute;
                     int n = JOptionPane.showConfirmDialog(null, a, "��ǰʱ��Ϊ",JOptionPane.OK_CANCEL_OPTION);
                       }
           });}
        //����������
        if(e.getSource()==Calculator){
            Frame f=new Frame("������");
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
                    catch(NumberFormatException lexicalXSDInt ){System.out.println("����������");}
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
                        catch(NumberFormatException lexicalXSDInt ){System.out.println("����������");}
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
            //���尴ť���Լ�ע�������
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
            Button buttonqc=new Button("���");
            buttonqc.addActionListener(new buttonqca());
            Button button0=new Button("0");
            button0.addActionListener(new button0a());
            Button buttondeng=new Button("=");
            buttondeng.addActionListener(new buttondenga());
            Button buttonchu=new Button("/");
            buttonchu.addActionListener(new buttonchua());
            //��Ӱ�ť�Լ��ı���
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
            //���öԻ���
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
     { new paintboard("��ͼ����"); }
} 