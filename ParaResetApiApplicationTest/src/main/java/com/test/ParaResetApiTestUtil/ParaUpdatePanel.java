package com.test.ParaResetApiTestUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.test.peisongapi.PeiSongApiTest;

public class ParaUpdatePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String tokentext;
    
	public static String urllink;
	
	public static String sources;
	
	
	public static void creatShowGUI(){
		
		JPanel  panelss=new JPanel();
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		
		
		
		// 创建及设置窗口
        JFrame frame = new JFrame("参数更新");
        frame.setSize(800,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      
        
      
     
        
    
     
        
        
        
        frame.add(panelss);
        
        JLabel label =new JLabel("账号token:");
        
      //  frame.getContentPane().add(label);
        
      
        
        panelss.setLayout(null);
        
        label.setBounds(10, 20, 150, 25);
        
        panelss.add(label);
		
      //输入信息文本框
        final JTextField token=new JTextField(1000);
        
        token.setBounds(150, 20, 400, 25);
        
        panelss.add(token);
        
        //写入设备信息 source
        
        JLabel labelsource =new JLabel("输入设备信息(resource):");
        
        labelsource.setBounds(10, 80, 150, 25);
        
        panelss.add(labelsource);
        
        
        
        //
        
      //输入设备信息文本信息文本
        final JTextField sourceText=new JTextField(1000);
        
        sourceText.setBounds(150, 80, 400, 25);
        
        panelss.add(sourceText);
        
        
        
        
        
        
        
        
        //输入csv文件
        
        JLabel labelpara =new JLabel("输入csv文件url:");
        
        labelpara.setBounds(10, 140, 150, 25);
        
        panelss.add(labelpara);
        
        
        
        //
        
      //输入url信息文本
        final JTextField url=new JTextField(1000);
        
        url.setBounds(150, 140, 400, 25);
        
        panelss.add(url);
        
        
        //确认按钮和清空按钮
        
        JButton sure=new JButton("确定");
        
        sure.setBounds(10, 300, 150, 25);
        
        panelss.add(sure);
        
        
        JButton clear=new JButton("清空");
        
        clear.setBounds(200, 300, 150, 25);
        
        panelss.add(clear);
        
        
        
        //添加执行接口测试按钮
        
        JButton ApiButton=new JButton("开始接口测试");
        
        ApiButton.setBounds(10, 500, 150, 25);
        
        panelss.add(ApiButton);
        
        

  	  //添加删除之前的测试结果文件
      
      JButton deletecsv=new JButton("删除上次结果文件");
      
      
      deletecsv.setBounds(200, 500, 150, 25);
      
      panelss.add(deletecsv);
      
        
        //获得文本框中的信息
        
        
        
         
         
         
         //写入
        
        
        
        /*
         * 
         * 添加事件监听器
         */
         sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 tokentext=token.getText();
		       //  System.out.println("tokentext:"+tokentext);
		        
		         urllink=url.getText();
		         
		       //  System.out.println("urllink:"+urllink);
		         
		         
		         sources=sourceText.getText();
		         
		       //  System.out.println("sources:"+sources);
		         
		         CsvUpdate  csvup=new CsvUpdate();
		         
		         try {
					csvup.updatafuncitontest(tokentext,sources,urllink);
				} catch (NoSuchAlgorithmException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		         
		      //   csvup.updatafuncitontest();
				
				// TODO Auto-generated method stub
				
			}
		});
         
         
         clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				token.setText("");
				
				url.setText("");
				
				sourceText.setText("");
				
				
				// TODO Auto-generated method stub
				
			}
        	 
        	 
        	 
        	 
        	 
        	 
         }
         
        	
        		 
        		 );
         /*
 		 * 开始进行接口测试
 		 *  
 		 */
         
         ApiButton.addActionListener(new ActionListener(
        		 
                ) {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			//	PeiSongApiTest peisongapi=new PeiSongApiTest();
				
				try {
					
					PeiSongApiTest.apit();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
//				JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
//						"暂不支持！", "警告信息", JOptionPane.WARNING_MESSAGE); 
//				
				
				
			}
	});
         
         deletecsv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String filename1="F:\\workspace\\ParaResetApiApplicationTest\\csvdocs\\FiddlerUpdatePrama.csv";
				
				DeleteFileUtil.delete(filename1);
				
				String filename2="F:\\workspace\\ParaResetApiApplicationTest\\csvdocs\\PeisongApiTestResult.csv";
				
				DeleteFileUtil.delete(filename2);
				
				
				
				
			}
		});
        
        
       // MonitorButton mb=new MonitorButton();
        
       // sure.addActionListener(mb);
        
        
        
        
		
	}
	
    
    
    
	
	
	
	public  static void main(String args[]){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				creatShowGUI();
				
			}
		});
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
