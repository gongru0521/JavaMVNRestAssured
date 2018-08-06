package com.test.ParaResetApiTestUtil;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;






import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSVReadWrite {
	
	//从csv文件中的不同行、列读取不同数据
	
//	String readurl=ParaUpdatePanel.urllink;
	
	
	
	
	
	
//	@Test
	
	public List<String> readcsvTest(String readurl) throws IOException {
		
		System.out.println("readurl:"+readurl);
		
		List<String> readstr=new ArrayList<String>();
		
		File file=new File(readurl);
		
		CsvReader reader = null;
		
		if((!file.exists())){
			System.out.println("文件"+readurl+"不存在");
			
			return null;
			
			
		}
		else{
		
		try {
			reader = new CsvReader(readurl, ',', Charset.forName("GBK"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reader.readHeaders();//读取表头信息
	
		
		while(reader.readRecord()){
			
			
			//当前行数，从0开始
			
			//long nowline=reader.getCurrentRecord()+1;
			
			//按列名读取这条记录的值
			
            
         //   String nowString=String.valueOf(nowline);
            
          //读取行内容
            
        //   LogUtil.loguuu("CSVReadWrite", "行数:"+nowString+"********"+reader.getRawRecord(), "CsvReader");
            
          //  LogUtil.loguuu("CSVReadWrite", "casename:"+reader.get("casename")+"--------------"+"Param:"+reader.get("Param"), "CsvReader");
            
            
            readstr.add(reader.getRawRecord());
         
		
			
		}
		
		
		
		return readstr;
		
		}
	
	}
	
	
	//@Test
	public void writecsv(String writeurl,String str[]) throws IOException{
		
//		CsvWriter wr=new CsvWriter(writeurl,',',Charset.forName("GBK"));
//       
//		
//		wr.writeRecord(str);
//		
//		wr.close();
		
		
		//csv文件写入追加
		
//		
		
		/*
		File f = new File(writeurl);
		try {
			
			FileWriter fl=new FileWriter(f,true);
			
			BufferedWriter writer = new BufferedWriter(fl);
			
			CsvWriter  cwriter=new CsvWriter(writer, ' ');
			
			
			cwriter.writeRecord(str,true);
			
			cwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		*/
		/*
		 * 追加写入且解决乱码问题
		 */
		if(str==null){
			
			System.out.println("写入信息为null");
		}
		else{

		BufferedWriter  out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeurl,true),"GBK"),1024);
		
		CsvWriter  csw=new CsvWriter(out, ',');
		csw.writeRecord(str);
	    csw.close();
	    
		}
		
	}
	

}
