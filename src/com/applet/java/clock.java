package com.applet.java;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JApplet;

public class clock extends Applet implements Runnable {

	Thread clockThread = null;
    Calendar now;
    private String s1;
    private int size;
    int r1,g1,b1;
    @Override
    public void init() {
    	// TODO Auto-generated method stub
    	size=Integer.parseInt("30");
    	//size=Integer.parseInt(getParameter("size"));
    }
    @Override
    public void start() {
    	// TODO Auto-generated method stub
    	if(clockThread==null){
    		clockThread =new Thread(this ,"Clock2");
    		clockThread.start();
    	}
    }
    @Override
	public void run() {
		// TODO Auto-generated method stub
        Thread myThread =Thread.currentThread();
        while(clockThread==myThread){
        	repaint();//通过repaint方法调用paint方法
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    	
	}
    @Override
    public void paint(Graphics g) {
    	// TODO Auto-generated method stub
        r1=(int)(Math.random()*255);
        g1=(int)(Math.random()*255);
        Color c=new Color(r1,g1,b1);//在通过随机数分别设置三原色，红绿蓝
        g.setColor(c);
       // now =Calendar.getInstance();//获得系统当前时间
        System.out.println(new SimpleDateFormat("yyyy--MM--dd HH:mm:ss").format(new Date()));
        s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      //  s1=now.get(now.YEAR)+"--"+(now.get(now.MONTH)+1)+"--"+now.get(now.DATE)+" "+now.get(now.HOUR)+":"+now.get(now.MINUTE)+":"+now.get(now.SECOND)+"";
       // Date d=new Date();
      //  long time = d.getTime();
       // System.out.println(time);
        
    	/*Class cc = null;
    	Object o1 = null;
		try {
			cc = Class.forName("java.util.Date");
			o1 = cc.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(o1 instanceof Date)
		{
		Date t=(Date)o1;
		System.out.println(new SimpleDateFormat("yyyy--MM--dd HH:mm:ss SSS").format(t));
		String s1 = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss SSS").format(t);
        
		}*/
        
        
        Font f=new Font("",1,size);
        g.setFont(f);
        g.drawString(s1, 10, 50);
    }
    @Override
    public void stop() {
    	// TODO Auto-generated method stub
        clockThread=null;
    }
   
}
