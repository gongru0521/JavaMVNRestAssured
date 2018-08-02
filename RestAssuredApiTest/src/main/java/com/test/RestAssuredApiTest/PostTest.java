package com.test.RestAssuredApiTest;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;









import com.test.util.AssertTest;
import com.test.util.CSVReadWrite;
import com.test.util.GetNowTime;
import com.test.util.GetPropertyData;

import static io.restassured.RestAssured.*;



//import static io.restassured.RestAssured.*;
//
public class PostTest {


//从读取文件中获得信息
	CSVReadWrite csvrw=new CSVReadWrite();
	
	
	/*
	 * 需要传递的参数
	 */
	String ID;
	String casename;
	String httpmethod;
	String param;
	String Host;
	String Url;
	String ContentType;
	
	//断言参数
	
	String asserstr;
	
	
	
	 /*
	    * 测试结果包括:ID,casename,para,
	    * 
	    */
	   
	//请求返回结果
	   String reponseResult;
	   //测试结果
	   
	   String caseresult;
	   //测试日期
	   String daytime;
	   //测试用时
	  long testtime;
	
	
	
	@Test
	public void test001() throws IOException {
		
		 //测试结果标题
		   
		   String title[]={"ID","casename","param","断言字符串","返回结果","测试结果","测试用时","测试日期"};
		   
		   
		
		try {
			csvrw.writecsv(title);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	    List<String> allstr = null;
		try {
			allstr = csvrw.readcsvTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  
	 	

	   
	   
	   httpmethod=GetPropertyData.getproperdata("httpmethod");
	
	   
	   Host=GetPropertyData.getproperdata("Host");
	   
	   Url=GetPropertyData.getproperdata("Url");
	   String link=Host+Url;
	   
	   ContentType=GetPropertyData.getproperdata("ContentType");
	  
		
	   
	   
	  
	   
	   for(int i=0;i<allstr.size();i++){
		   String alls[]=allstr.get(i).split(",");
		   
		   ID=alls[0];
		   
		   casename=alls[1];
		   
		   param=alls[6];
		   
		   
		   asserstr =alls[7];
	   
	   
	       Response response = given()
               // 设置request Content-Type
               .contentType(ContentType)
               // 请求参数 放body
               .body(param)
               // POST 请求
               .post(link);

      // response.print();
	     
	     System.out.println("casename:"+casename);
	     System.out.println("参数:"+param);
	     
	   //  int statuscode=response.getStatusCode();
	     
	  //  System.out.println("statuscode:"+statuscode);
	     
	     //返回的三个类型
	     
	     int code=response.jsonPath().get("code");
	     
	     String message=response.jsonPath().get("message");
	     
	     Map<String,String> datas=response.jsonPath().get("data");
	    
	     
	     //获得返回结果
	     
	     reponseResult="code:"+code+","+"message"+message+"datas:"+datas;
	     
	     //获得测试结果
	     caseresult=AssertTest.PassOrFail(asserstr, message);
	     
	     daytime=GetNowTime.getTime();
	     
	     testtime=response.time();
	     
	     String reslist[]={ID,casename,param,asserstr,reponseResult,caseresult,String.valueOf(testtime),daytime};
	     
	     csvrw.writecsv(reslist);
	     
	     System.out.println(";datas:"+datas);
	     
	  
		
	   }
		
		
	}
	
	
	//@Test
	public void test002() throws IOException{
		
		Response response = given()
	               // 设置request Content-Type
	               .contentType("application/x-www-form-urlencoded")
	               // 请求参数 放body
	               .body("password=aaaaaa6&method=kkpb.user.login&mobile=18534163095")
	               // POST 请求
	               .post("http://test.xk.api.myzs.com/gateway ");
		
		
		int statuscode=response.getStatusCode();
	     System.out.println("statuscode:"+statuscode);
	    
	    //返回测试结果
	     response.asString();
	     
	     System.out.println("response.asString():"+response.asString());
	     
	     int code=response.jsonPath().get("code");
	     System.out.println("code:"+code);
	     
	     String message=response.jsonPath().get("message");
	     
	     System.out.println("message:"+message);
	     
	     Map<String,String> datas=response.jsonPath().get("data");
	     
	     System.out.println("datas:"+datas);
	
	}
}
