package com.test.ParaResetApiTestUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowTime {

	public static String getTime(){
		
		 String stime=null;
//	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//	        stime=df.format(new Date()).toString();

		 
		 stime=String.valueOf(new Date().getTime());
		 
	      return stime;
		
		
	}
	
	
	public static String getnowtime(){
		
		
		String stime=null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        stime=df.format(new Date()).toString();
	 
	// stime=String.valueOf(new Date().getTime());
	 
      return stime;
      
	}
}
