package com.test.peisongapi;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;



import com.test.ParaResetApiTestUtil.CSVReadWrite;
import com.test.ParaResetApiTestUtil.GetNowTime;

public class PeiSongApiTest {
	
	
	//获得csv中字符串
	
	static CSVReadWrite  csvre=new CSVReadWrite();
	
	static String readurl="./csvdocs/FiddlerUpdatePrama.csv";
	
	
	static String linkurl="http://test.c.api.kkpbcdn.com/gateway";
	
	 
	
//	@Test
	public static void apit() throws IOException{
	
	List<String> listread=csvre.readcsvTest(readurl);
	
	String param="";
	
	String ContentType="application/x-www-form-urlencoded";
	
	 String writeurl="./csvdocs/PeisongApiTestResult.csv";
     
     String resultapi[]={"参数:","返回所有数据","Code","Message","Datas","测试时间","当前时间"};
     
     csvre.writecsv(writeurl,resultapi);
	
     Response response;
	
	for(int i=0;i<listread.size();i++){
		
		System.out.println("listread.get("+i+"):"+listread.get(i));
		
		param=listread.get(i);
		
	//	RestAssured.basePath="http://test.c.api.kkpbcdn.com";
	
	    response = given()
             // 设置request Content-Type
             .contentType(ContentType)
             // 请求参数 放body
             .body(param)
             // POST 请求
             .post(linkurl);
	    
	   ResponseBody<?> ssbod= response.getBody();
	   
	   String values=ssbod.asString();
	   
	   System.out.println("values:"+values);
	   
	   System.out.println("\n****************");
	    
	  //  String ss= response.print();
	  //   System.out.println("ss:"+ss);
	    
	    int code=response.jsonPath().get("code");
	     
	    String message=response.jsonPath().get("message");
	     
	    Map<String,String> datas=response.jsonPath().get("data");
	    
	    System.out.println("code:"+code+",message:"+message+",datas:"+datas);
	    //写入测试结果
	    
	    
	     
	     String daytime=GetNowTime.getnowtime();
	     
	     Long testtime=response.time();
	     
	     String reslist[]={param,values,String.valueOf(code),message,String.valueOf(datas),String.valueOf(testtime),daytime};
	     
	     
	    
	     
	     csvre.writecsv(writeurl,reslist);
	
	
	 
	 }
	 
	}
	
	public static void main(String args[]){
		
		try {
			apit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
