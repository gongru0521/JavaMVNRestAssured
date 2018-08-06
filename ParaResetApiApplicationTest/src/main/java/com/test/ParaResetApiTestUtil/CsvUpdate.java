package com.test.ParaResetApiTestUtil;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;




public class CsvUpdate {
	
	
	CSVReadWrite  csv=new CSVReadWrite();
	
	
	ParamAction pmaction=new ParamAction();
	
	//
	
	public static String appkey="33445d8b31fa81b444f3b8263c47dbfc";
	
	//String token ;
	
	String timenow;
	
	//String source;
	
	String sign;
	
	
	
	
	

	
	public void updatafuncitontest(String token,String source,String urllink) throws IOException, NoSuchAlgorithmException{
		
		
		
		  
		
		
		
		
		
		// token=ParaUpdatePanel.tokentext;
		
		// source=ParaUpdatePanel.sources;
		 
		 timenow=GetNowTime.getTime();
		 
	//	 System.out.println("urllink:"+urllink);
		 
		 List<String> readcsvback=csv.readcsvTest(urllink);
		 
		 
		 
		 
		 String removeback;
		 
		 String addstrback;
		 
		 String str;
		 
		 String ss[];
		 
		 String parawrite[];
		 
		 String writeurl="./csvdocs/FiddlerUpdatePrama.csv";
		 
		 String titile[]={"Fiddlerupdata",""};
		    
		  csv.writecsv(writeurl,titile);
		  if(readcsvback==null){
			  
			  System.out.println("字符串为空");
			  
		  }
		  else{
		 
	
		  Iterator<String> ita=readcsvback.iterator();
		  
		  

		  while(ita.hasNext()){
			  str=(String)ita.next();
		    
		    System.out.println("str:"+str);
			 
			 
			
		    sign=pmaction.getSign(str, source, timenow, token);
		    
		    
	
		    
		    
		    System.out.println("source:"+source+"timenow:"+timenow+"token:"+token+"sign:"+sign);
		    //把sign,token,timetamp,source删除
		    
		    removeback=pmaction.removestrtest(str);
		    
		    System.out.println("removeback:"+removeback);
		    
		    
		    
		    addstrback=removeback+"&"+"source="+source+"&"+"timestamp="+timenow+"&"+"token="+token+"&"+"sign="+sign;
		    
		    System.out.println("addstrback:"+addstrback);
		    
		    
		    ss=addstrback.split("&");
		    
		   
		    Arrays.sort(ss);
		    
		    
		   // System.out.println("updatepara:"+ss);
		    
//		    for(int j=0;j<ss.length;j++){
//		    	
//		    	System.out.println("ss[j]"+ss[j]);
//		    	
//		    	
//		    }
//		    
		    
		    String pp=pmaction.ArrayToStrLink(ss);
		    
		    parawrite=pp.split(",");
		    
		   
		    
		    
		    
		    csv.writecsv(writeurl,parawrite);
		    
		    
		    
		    
		
		 }
	
		
		}
		
	}
	
	
	
	
	
	
	

}
