package cn.com;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import net.sf.json.JSONObject;

public class JavavcCameraTest {
	  public static OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
	  static int d=0;
	  static int c=0;
	  
	  public static void JavavcCameraTest() throws Exception, InterruptedException{
		   OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		   grabber.start();   //��ʼ��ȡ����ͷ����
		   CanvasFrame canvas = new CanvasFrame("����ͷ");//�½�һ������
		   canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   //canvas.setAlwaysOnTop(true);
		   canvas.setVisible(true);
		   int ex = 0;
		   
		   while(true){
			   
			   if(!canvas.isDisplayable()){
				   grabber.stop();//ֹͣץȡ
	                System.exit(2);//�˳�
	                break;
			   }
			 
			    canvas.showImage(grabber.grab());//��ȡ����ͷͼ�񲢷ŵ���������ʾ�� �����Frame frame=grabber.grab(); frame��һ֡��Ƶͼ��
	            opencv_core.Mat mat = converter.convertToMat(grabber.grabFrame());
	            
	            opencv_imgcodecs.imwrite("C:\\Users\\wen\\Desktop\\img\\" + ex + ".jpg", mat);
	         
	             
	            
	             File f=new File("C:\\Users\\wen\\Desktop\\img\\" + ex + ".jpg");
	             ex++;
				 try {
					 
					  
						String str=FaceCheck(f);
						JSONObject json = JSONObject.fromObject(str);
						try{
							String faces = json.getString("faces");
							 if("[]".equals(faces)){
								 //JOptionPane.showMessageDialog(null, "�ϴ���ͼƬ��û��ʶ������", "������Ϣ",JOptionPane.ERROR_MESSAGE);  
							 }
							 
							 JSONObject josnToken = JSONObject.fromObject(faces.substring(1, faces.length()-1));
							 String token = josnToken.getString("face_token");
							 String[] a=new Save().GetMess();
							 
							  
							  if(d<a.length){
                                  c=d;
                                  d++;
							  }
							  if(d>=a.length){
								  d=0;
								
							  }
						
							 new Compare(token,c);
							 
							 
							 //Save.AddMess(token);
							
							 System.out.println(token);
						}catch(Exception e1){
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    
			    
	            Thread.sleep(1);//50����ˢ��һ��ͼ��
	            
		   }
	  }
	  public static String FaceCheck(File file)throws IOException{
		  byte[] buff = Main.getBytesFromFile(file);
			 String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
			 HashMap<String, String> map = new HashMap<>();
		        HashMap<String, byte[]> byteMap = new HashMap<>();
		        map.put("api_key", "FeYa4Ne64pRs0aFj2opqLu9A-5abdkqr");
		        map.put("api_secret", "jZVQMxKBeOKmmH5i3uALaPNkxJ4k4oQJ");
		        map.put("return_landmark", "1");
		        map.put("return_attributes", "gender,age,smiling,headpose,facequality,blur,eyestatus,emotion,ethnicity,beauty,mouthstatus,eyegaze,skinstatus");
		        byteMap.put("image_file", buff); 
		        String str=null;
		        try{ 
		        	byte[] bacd = Main.post(url, map, byteMap);
		        	 str = new String(bacd); 
		        	
		        	System.out.println(str); }
		        catch (Exception e1) { 
		        	e1.printStackTrace(); } 
		        return str;
	  }
	  
	  
}
