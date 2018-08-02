package com.test.util;

public class AssertTest {
	public static String PassOrFail(String asster,String mess){
		
		String res=null;
		try{
		
		if(mess.contains(asster)){
			
			res="PASS";
			
			
		}
		else{
			
			res="FAIL";
		}
		
		}
		
		catch(Exception e){
			
			res="FAIL_exception";
			
		}
		return res;
		
		
		
		
	}
	
	public static String PassOrFailCode(String asster,int code){
		
		String res=null;
		
		int assint=Integer.valueOf(asster);
		try{
		
		if(assint==code){
			
			res="PASS";
			
			
		}
		else{
			
			res="FAIL";
		}
		
		}
		
		catch(Exception e){
			
			res="FAIL_exception";
			
		}
		return res;
		
		
		
	}

}
