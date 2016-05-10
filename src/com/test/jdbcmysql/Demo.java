package com.test.jdbcmysql;

import java.sql.ResultSet;

public class Demo {
    static String sql=null;
    static DBHelper dbl=null;
    static ResultSet ret=null;//≤È—Ø
    
    
    public void getInfor(){
    	sql="select * from MyTest";
    	dbl=new DBHelper(sql);
    	try {
//    		ret=dbl.pst
			ret=dbl.pst.executeQuery();
			while(ret.next()){
				String did=ret.getString(1);
				String dname=ret.getString(2);
				String dage=ret.getString(3);
				System.out.println(did+"  "+dname+"  "+dage);
			}
			ret.close();
			dbl.close();
		} catch (Exception e) {
             System.out.println(e.getMessage());
		}
    }
    
   
    
}
