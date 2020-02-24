package cn.com;

import java.util.List;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;





public class Compare {
	
	public static String t1;
	public static String t2;
	
//	  public static void main(String[] args) throws Exception, InterruptedException{
//		 String[] a=new Save().GetMess();
////		 System.out.println(a[0]);
//	  }
	  
	public Compare(String t4,int d) throws SQLException{
		  String b=null;
		  String[] a=new Save().GetMess();
		  b=a[d];
//		  if(d<a.length){
//			  b=a[d];
//			  d++;
//		  }
//		  if(d>a.length){
//			  d=0;
//			  b=a[d];
//			  d++;
//		  }
		  System.out.println("123132"+"     "+b);
		  String url = "https://api-cn.faceplusplus.com/facepp/v3/compare"; 
		  List<BasicNameValuePair> formparams = new ArrayList<>();  
	      formparams.add(new BasicNameValuePair("api_key", "FeYa4Ne64pRs0aFj2opqLu9A-5abdkqr"));  
	      formparams.add(new BasicNameValuePair("api_secret", "jZVQMxKBeOKmmH5i3uALaPNkxJ4k4oQJ")); 
	      formparams.add(new BasicNameValuePair("face_token1", b));  
	      formparams.add(new BasicNameValuePair("face_token2", t4));  

	      post(formparams,url);
		  
		  
	}
//	public static void main(String[] args) throws Exception {
//		
//		String url = "https://api-cn.faceplusplus.com/facepp/v3/compare"; 
//		  List<BasicNameValuePair> formparams = new ArrayList<>();  
//	      formparams.add(new BasicNameValuePair("api_key", "FeYa4Ne64pRs0aFj2opqLu9A-5abdkqr"));  
//	      formparams.add(new BasicNameValuePair("api_secret", "jZVQMxKBeOKmmH5i3uALaPNkxJ4k4oQJ")); 
//	      formparams.add(new BasicNameValuePair("face_token1", "e89d3ec1fd1cc985ac586fd6667e9144"));  
//	      formparams.add(new BasicNameValuePair("face_token2", t2));  
//
//	      post(formparams,url);
//	}
	 public static void post(List<BasicNameValuePair> formparams,String url) {  
		 CloseableHttpClient httpclient = HttpClients.createDefault();  
		// 创建httppost    
	        HttpPost httppost = new HttpPost(url);  
	        UrlEncodedFormEntity uefEntity;  
	        try {  
	            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
	            httppost.setEntity(uefEntity);  
	            System.out.println("executing request " + httppost.getURI());  
	            CloseableHttpResponse response = httpclient.execute(httppost);  
	            try {  
	                HttpEntity entity = response.getEntity();  
	                if (entity != null) {  
	                	
	                	JSONObject json = JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
	                	String facemess = json.getString("confidence");
	                
	                	Double num = Double.valueOf(facemess);
	                	System.out.println("--------------------------------------");  
	                	//System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
	                	System.out.println("--------------------------------------"); 
	                	System.out.println(num); 
	                	 if(num>71.000){
	                		 JOptionPane.showMessageDialog(null, "授权成功", "提醒消息",JOptionPane.INFORMATION_MESSAGE);  
	                	 }
	                	 
	                }
	            } finally {  
	            	  response.close();  }
	            }catch (ClientProtocolException e) {  
	            	 e.printStackTrace();  
	            }catch (UnsupportedEncodingException e1) { 
	            	e1.printStackTrace();
	            } catch (IOException e) { 
	            	 e.printStackTrace();  
	            }finally {  
	            	  try {  
	            		  httpclient.close();  
	            	  }catch (IOException e) {  
	            		  e.printStackTrace();  
	            	  }
	            }
	        
	        //EntityUtils.toString(entity, "UTF-8")
	                
	 }

	 }
	 
