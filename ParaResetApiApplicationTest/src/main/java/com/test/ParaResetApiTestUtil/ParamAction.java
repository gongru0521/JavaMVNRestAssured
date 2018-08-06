package com.test.ParaResetApiTestUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;








//import com.ndktools.javamd5.Mademd5;

public class ParamAction {
	
//	Mademd5 md5 = new Mademd5();
	
	
	//获得sign值
	
	/*
	 * 
	 * 1.对所有API请求参数（包括公共参数和业务参数，但除去sign参数资源类型和byte[]类型的参数），根据参数名称的ASCII码表的顺序排序。如：foo=1, bar=2, foo_bar=3, foobar=4排序后的顺序是bar=2, foo=1, foo_bar=3, foobar=4。

		2.将排序好的参数名和参数值拼装在一起，根据上面的示例得到的结果为：bar2foo1foo_bar3foobar4。

		3.把拼装好的字符串采用utf-8编码，使用签名算法对编码后的字节流进行摘要。使用MD5算法，在拼装的字符串前后加上app的secret后，再进行摘要，如：md5(secret+bar2foo1foo_bar3foobar4+secret)；
	 * 
	 * 
	 * 
	 * 
	 * 接口举例：
	 * apiversion=V1&appkey=1&device=2&format=json&method=kkpb.express_info.start&sign=68244ecbbbe13ae88f77756b749a4d78&
	 * source=iPhone%20SE%28iOS10.3.2%29&timestamp=1513666954&token=E32FF72F589C56CE4785FF76ED83CCC9&user_id=411586&version=2.1.3

	 * 
	 * 
	 */
	
	
	/*
	 * 从csv文件中获得所有参数
	 */
	
	//List<String> allreadcsv=null;
	
//	CSVReadWrite  csv=new CSVReadWrite();
	
	public static String Appkey="33445d8b31fa81b444f3b8263c47dbfc";
	
	
	/*
	 * 删除字符串数组中的某个字符
	 * 
	 * 
	 */
	
	/*
	 * 删除sign,source,token,timestap
	 */
	
	//@Test
	
//	public void removetest(){
//		
//		//正则表达式方法删除字符串
//		   String str="apiversion=V1&appkey=1&device=2&format=json&method=kkpb.express_info.start&sign=68244ecbbbe13ae88f77756b749a4d78&source=iPhone%20SE%28iOS10.3.2%29&timestamp=1513666954&token=E32FF72F589C56CE4785FF76ED83CCC9&user_id=411586&version=2.1.3";
//			
//			String backstr="";
//		
//		
//			
//			String regstrsign="sign=.*?(&)";
//			
//			String regstrsource="source=.*?(&)";
//			
//			String regtime="timestamp=.*?(&)";
//			
//			String regtoken="token=.*?(&)";
//			
//			
//			String strsss=str.replaceAll(regstrsign, "").replaceAll(regstrsource, "").replaceAll(regtime, "").replaceAll(regtoken, "");
//			
//			
//			
//			System.out.println("strsss:"+strsss);
//			
//			
//		//转换为数组法删除
//			/*
//			String regstr="sign.*";
//			
//			String strs[]=str.split("&");
//			
//			List<String> list=new ArrayList<String>();
//			
//			
//			
//			
//			
//			for(int i=0;i<strs.length;i++){
//			
//			//backstr=str.replace(regstr, "");
//				
//				if((strs[i].matches(regstr))==true){
//					
//					System.out.println("包含！");
//					
//					
//					
//				}
//				
//				else{
//					
//					list.add(strs[i]);
//					
//				//	System.out.println("strs[i]:"+strs[i]);
//					
//				}
//			
//			
//			
//			
//			}
//			
//			Iterator  ita=list.iterator();
//			
//			while(ita.hasNext()){
//				
//				System.out.println(ita.next());
//				
//			}
//			
//			System.out.println("backstr:"+backstr);
//		
//		
//		*/
//		
//	}
//	
	
	
	
	
	public String removestrtest(String str){
		
	
		
		
	//	System.out.println("str:"+str);
		
		String backstr="";
		
		
		String regstrsign="sign=.*?(&)";
		
		String regstrsource="source=.*?(&)";
		
		String regtime="timestamp=.*?(&)";
		
		String regtoken="token=.*?(&)";
		
		
		 backstr=str.replaceAll(regstrsign, "").replaceAll(regstrsource, "").replaceAll(regtime, "").replaceAll(regtoken, "");
			
		
		return backstr;
		
		
		
		
		
	}
	
	
	/*
	 * 
	 * 
	 * 添加source,token,timestap
	 */
	
	
	public String addpara(String str){
		
		 String addbackstr=null;
		 
		 
		 return addbackstr;
		
		
		
		
		
	}
	
	/*
	 * 数组转换为字符串
	 * 
	 * 
	 * 
	 * 
	 */
	
	public String ArrayToStr(String str[]){
		
		
		String ss="";
		
		for(int i=str.length-1;i>=0;i--){
			
			ss=str[i]+ss;
			
		}
		
		
		
		return ss;
		
		
		
	}
	
	
	/*
	 * 数组转换为list
	 * 
	 * 
	 */
	public List<String> StrToList(String str[]){
		
		List<String> list=new ArrayList<>();
		
		for(int i=0;i<str.length;i++){
			
			list.add(str[i]);
			
		}
		
		
		return list;
		
	}
	
	/*
	 * 
	 * 数组转换为list并添加&
	 */
	
	public String ArrayToStrLink(String str[]){
		
		
	//	 Arrays.sort(str);
		 
		 
		
		 String ss="";
		
		
		
		for(int i=str.length-1;i>=0;i--){
			
			
			
			ss=str[i]+"&"+ss;
			
		//	System.out.println("str[i]:"+str[i]);
		
		}
		
	//	System.out.println("ss:"+ss);
		
	//	
		System.out.println("ss.substring(0, ss.length()-1):"+ss.substring(0, ss.length()-1));
		
		
		return ss.substring(0, ss.length()-1);
		
		
		
	}
	
	
	
	
	/*
	 * 
	 * list转换为字符串数组
	 */
	
	public String[] ListToStrs(List<String> list){
		
		String str[]=new String[list.size()];
		
		for(int i=0;i<list.size();i++){
		
			
			str[i]=list.get(i);
		
		
		}
		
		
		return str;
		
		
	}
 	
	
	
	
	/*
	 * 
	 * md5加密
	 */
	
	
	public String getmd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		
		String md5back=null;
		
		
		
		if(str!=null){
			
//			  //创建具有指定算法名称的信息摘要 
//            MessageDigest md5 = MessageDigest.getInstance("MD5"); 
//            
//            md5.update(str.getBytes("UTF-8"));
//            
//          //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算 
//            byte[] results = md5.digest(str.getBytes()); 
//            
//            
//            
//			md5back=new String(results);
			
			//大写转小写
		//	md5back=md5.toMd5(str).toLowerCase();
			
			md5back=MD5Util.MD5(str).toLowerCase();
			
		}
		
		
		return md5back;
		
		
		
	}
	
	//@Test
	
//	public void signtest() throws NoSuchAlgorithmException, UnsupportedEncodingException{
//		
//		
//		
//		String sss="device=1&sign=54d57a3ebb0b65ab27971d6f82a9ef1a&source=Redmi Note 2 5.0.2&method=kkpb.user.login&appkey=1&timestamp=1533351929&apiversion=V1&format=json&lng=0.0&user_pwd=123456&imei=869334027396186&user_mobile=18638732236&version=2.2.2&jgid=010fec58471&user_flag=3&lat=0.0";;
//		
//		
//		//String removebackstr="device=1&method=kkpb.user.login&appkey=1&apiversion=V1&format=json&lng=0.0&user_pwd=123456&imei=869334027396186&user_mobile=18638732236&version=2.2.2&jgid=010fec58471&user_flag=3&lat=0.0";
//		
//		String removesign="device=1&source=Redmi Note 2 5.0.2&method=kkpb.user.login&appkey=1&timestamp=1533351929&apiversion=V1&format=json&lng=0.0&user_pwd=123456&imei=869334027396186&user_mobile=18638732236&version=2.2.2&jgid=010fec58471&user_flag=3&lat=0.0";
//		
//		String strcsv[]=removesign.replaceAll("=", "").split("&");
//		for(int i=0;i<strcsv.length;i++){
//		
//		System.out.println("strcsv[i]:"+strcsv[i]);
//		
//		}
//		
//		Arrays.sort(strcsv);
//		
//		
//		String tomad5=Appkey+ArrayToStr(strcsv)+Appkey;
//		
//		
//		System.out.println("tomad5:"+tomad5);
//		
//		
//		//md5加密
//		
//		
//		
//		
//		
//		
//		
//	   String sign=getmd5(tomad5);
//	   System.out.println("sign="+sign);
//		
//		
//		
//	}
//	
	
	

	public  String getSign(String str,String source,String timestamp,String token) throws IOException, NoSuchAlgorithmException{
		
		
		
		
		String sign;
		
		
		//获得csv文件中的参数
		/*
		
		allreadcsv=csv.readcsvTest();
		
			*/
		
		String strcsv[];
		
		//String strss=null;
		
		String removebackstr;
		
		String addparastr;
	
		
		
		
		//根据规则 拆分成数组
		/*
		
		Iterator  ite=allreadcsv.iterator();
		
		while(ite.hasNext()){
			//获得每行信息
			
			strss=(String) ite.next();
			
		*/	
			/*
			 * 删除sign,source,token,timestap
			 */
			
			
			
			//获得删除后的字符串并转化为数组
			
			removebackstr=removestrtest(str);
			
			
			addparastr=removebackstr+"&"+"source="+source+"&"+"timestamp="+timestamp+"&"+"token="+token;
			
			
			
			strcsv=addparastr.replaceAll("=", "").split("&");
			
			
			Arrays.sort(strcsv);
			
			//appkey+字符串
			
			String tomad5=Appkey+ArrayToStr(strcsv)+Appkey;
			
			
			//md5加密
			
			
			
			
			
			
			
		   sign=getmd5(tomad5);
			
			
			
		//}
		
		
		
		
		return sign;
		
	
		
		
		
		
		
		
		
	}
	
	
}
