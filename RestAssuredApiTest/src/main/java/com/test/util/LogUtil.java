package com.test.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {
	public static void loguuu(String classname,String  contentline,String funname){
		
		Logger logg=Logger.getLogger(classname.getClass());
		
		PropertyConfigurator.configure("./dataproperty/log4j.properties");
		
		//logg.debug("classname:"+classname.getClass());
		
		logg.debug("test_funciton_name:"+funname+";******LogMessage:"+contentline);
		
	//	logg.error("test_funciton_name:"+funname+";******LogMessage:"+contentline);
		
		
	}

}
