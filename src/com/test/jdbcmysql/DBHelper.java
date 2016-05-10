package com.test.jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBHelper {
	//
    public static final String url="jdbc:mysql://localhost:3306/MyDemo";
    public static final String name="com.mysql.jdbc.Driver";
    public static final String user="root";
    public static final String password="";
    
    public Connection con=null;
    public PreparedStatement pst=null;
    public DBHelper(String sql){
    	try{
    		Class.forName(name);
    		con=DriverManager.getConnection(url, user, password);
    		pst=con.prepareStatement(sql);
    	}catch(Exception e){
    		e.printStackTrace();
    		//System.out.println("数据库连接失败："+e.getMessage());
    	}
    }
    
    public void close(){
    	try {
			con.close();
			pst.close();
		} catch (Exception e) {
              System.out.println(e.getMessage());
		}
    }
}
