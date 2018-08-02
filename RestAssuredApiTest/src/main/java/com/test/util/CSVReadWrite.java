package com.test.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSVReadWrite {
	
	//从csv文件中的不同行、列读取不同数据
	
	String readurl="./CSVFiles/APIData.csv";
	
	String writeurl="./CSVFiles/APITestResult.csv";
	
	public static String ID=null;
	
	public static String casename=null;
	
	public static String param=null;
	
	
//	@Test
	
	public List<String> readcsvTest() throws IOException {
		
		List<String> readstr=new ArrayList<String>();
		
		
		CsvReader reader = null;
		try {
			reader = new CsvReader(readurl, ',', Charset.forName("GBK"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reader.readHeaders();//读取表头信息
	
		
		while(reader.readRecord()){
			
			
			//当前行数，从0开始
			
			long nowline=reader.getCurrentRecord()+1;
			
			//按列名读取这条记录的值
			
            
            String nowString=String.valueOf(nowline);
            
          //读取行内容
            
        //   LogUtil.loguuu("CSVReadWrite", "行数:"+nowString+"********"+reader.getRawRecord(), "CsvReader");
            
          //  LogUtil.loguuu("CSVReadWrite", "casename:"+reader.get("casename")+"--------------"+"Param:"+reader.get("Param"), "CsvReader");
            
            
            readstr.add(reader.getRawRecord());
         
		   ID=reader.get("ID");
		   
		   casename=reader.get("casename");
		   
		   param=reader.get("Param");
			
		}
		
		
		
		return readstr;
		
		
	
	}
	
	
	//@Test
	public void writecsv(String str[]) throws IOException{
		
//		CsvWriter wr=new CsvWriter(writeurl,',',Charset.forName("GBK"));
//       
//		
//		wr.writeRecord(str,true);
//		
//		wr.close();
		
		
		//csv文件写入追加
		
		File f = new File(writeurl);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f,true));
			CsvWriter cwriter = new CsvWriter(writer,',');
			cwriter.writeRecord(str,false);
			cwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

		
		
	    
		
	}
	

}
