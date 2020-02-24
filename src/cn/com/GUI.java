package cn.com;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.SSLException;
import javax.swing.JFrame;

import org.opencv.core.CvType;  
import org.opencv.core.Mat;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import net.sf.json.JSONObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
  

public class GUI extends JFrame implements ActionListener{

    private static final String File = "C:\\Users\\wen\\Desktop\\image\\";
	JButton open=null;
	JButton sent=null;
    JButton startCamera=null;
	private static String a="C:\\Users\\wen\\Desktop\\image\\timg13.jpg";
	private ImageIcon c = new ImageIcon("C:\\Users\\wen\\Desktop\\image\\timg12.jpg");
	private JFileChooser jfc=new JFileChooser(File);
	private static File f=null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 new GUI(a,f);
		
	}
  public GUI(String b,File file){
	  sent=new JButton("sent");
	  open=new JButton("open");
	  startCamera=new JButton("startCamera");
	  this.setTitle("图片上传");
	  this.setSize(658, 411);
	  this.setLayout(null);
	  
	  
	  JPanel jp=new JPanel(); 
	  JLabel jl=new JLabel(c);
	  jl.setBounds(0, 0, c.getIconWidth(), c.getIconHeight());	
	  this.getLayeredPane().setLayout(null);
   	  this.getLayeredPane().add(jl, new Integer(Integer.MIN_VALUE)); 
	  jp = (JPanel) this.getContentPane();  
	  jp.setOpaque(false);  
	  
	  this.f=file;
	  
	  
	  
	  ImageIcon background = new ImageIcon(b);
	  int imgWidth=background.getIconWidth();
	  int imgHeight=background.getIconHeight();
	  int conWidth=130;
	  int conHeight=130;
	  int reImgWidth;
      int reImgHeight;
      if(imgWidth/imgHeight>=conWidth/conHeight){
			if(imgWidth>conWidth){
				reImgWidth=conWidth;
				reImgHeight=imgHeight*reImgWidth/imgWidth;
			}else{
				reImgWidth=imgWidth;
				reImgHeight=imgHeight;
			}
		}else{
			if(imgWidth>conWidth){
				reImgHeight=conHeight;
				reImgWidth=imgWidth*reImgHeight/imgHeight;
			}else{
				reImgWidth=imgWidth;
				reImgHeight=imgHeight;
			}
		}

	  background=new ImageIcon(background.getImage().getScaledInstance(reImgWidth, reImgHeight, Image.SCALE_DEFAULT));
	  JLabel label = new JLabel();
      label.setIcon(background);
	  label.setHorizontalAlignment(SwingConstants.CENTER);
	  label.setBounds(180, 160, 130, 130);	
	  open.setBounds(350,180,75,35);
	  sent.setBounds(350,225,75,35);
	  startCamera.setBounds(440,225,120,35);
	  
	  this.add(open);
	  this.add(label);
	  this.add(sent);
	  this.add(startCamera);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  open.addActionListener(this);
	  sent.addActionListener(this);
	  startCamera.addActionListener(this);
	  
  }
  

  




public class FileFilterTest extends javax.swing.filechooser.FileFilter{
  public boolean accept(java.io.File f) {
	    if (f.isDirectory())
	    	return true;
	    return f.getName().endsWith(".jpg");  //设置为选择以.class为后缀的文件
	  } 
  
  public String getDescription(){
	    return ".JPG";
	  }
  }
  
 
  public java.io.File getFile(){
//	 JFileChooser jfc=new JFileChooser(File);
		 FileFilterTest fileFilter=new FileFilterTest ();
		 jfc.setFileFilter(fileFilter); 
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
			//jfc.showDialog(new JLabel(), "选择");
			File file1=jfc.getSelectedFile();
//			if(file1.isDirectory()){
//				System.out.println("文件夹:"+file1.getAbsolutePath());
//			}
//			else if(file1.isFile()){
//				System.out.println("文件:"+file1.getAbsolutePath());
//			}
//			System.out.println(jfc.getSelectedFile().getName());
			
			return file1;
			
  }
  
  public  void getFace(java.io.File img)  {
	
	  
  }
  
  public String FaceCheck(File file)throws IOException{
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
  

  
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
//	 JFileChooser jfc=new JFileChooser(File);
//	 FileFilterTest fileFilter=new FileFilterTest ();
//	 jfc.setFileFilter(fileFilter); 
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
//		jfc.showDialog(new JLabel(), "选择");
//		File file1=jfc.getSelectedFile();
//		if(file1.isDirectory()){
//			System.out.println("文件夹:"+file1.getAbsolutePath());
//		}
//		else if(file1.isFile()){
//			System.out.println("文件:"+file1.getAbsolutePath());
//		}
//		System.out.println(jfc.getSelectedFile().getName());
        if(e.getSource()==open){
        	 this.setVisible(false);
        	 jfc.showDialog(new JLabel(), "选择");
        	 File file=new File(getFile().getAbsolutePath());
    	     
    	  
    	     new GUI(getFile().getAbsolutePath(),file);
    	     
        }
	    
	     //this.setVisible(false);
	     
	     //jfc.showDialog(new JLabel(), "选择");
		 //File file=new File(getFile().getAbsolutePath());
	     
		 //new GUI(getFile().getAbsolutePath());
        if(e.getSource()==startCamera){
        	 
			   this.setVisible(false);
        	
				try {
					new JavavcCameraTest();
					JavavcCameraTest.JavavcCameraTest();
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
        }
		
	     
	    	
	     
		 if(e.getSource()==sent){
			 
		 try {
			 
			  
			String str=FaceCheck(f);
			JSONObject json = JSONObject.fromObject(str);
			try{
				String faces = json.getString("faces");
				 if("[]".equals(faces)){
					 JOptionPane.showMessageDialog(null, "上传的图片中没有识别到人脸", "提醒消息",JOptionPane.ERROR_MESSAGE);  
				 }
				 JSONObject josnToken = JSONObject.fromObject(faces.substring(1, faces.length()-1));
				 String token = josnToken.getString("face_token");
				 Save.AddMess(token);
				
				 System.out.println(token);
			}catch(Exception e1){
				e1.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 }
		 
		 
//		 byte[] buff = Main.getBytesFromFile(file);
//		 String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
//		 HashMap<String, String> map = new HashMap<>();
//	        HashMap<String, byte[]> byteMap = new HashMap<>();
//	        map.put("api_key", "FeYa4Ne64pRs0aFj2opqLu9A-5abdkqr");
//	        map.put("api_secret", "jZVQMxKBeOKmmH5i3uALaPNkxJ4k4oQJ");
//	        map.put("return_landmark", "1");
//	        map.put("return_attributes", "gender,age,smiling,headpose,facequality,blur,eyestatus,emotion,ethnicity,beauty,mouthstatus,eyegaze,skinstatus");
//	        byteMap.put("image_file", buff); 
//	        try{ 
//	        	byte[] bacd = Main.post(url, map, byteMap);
//	        	String str = new String(bacd); 
//	        	
//	        	System.out.println(str); }
//	        catch (Exception e1) { 
//	        	e1.printStackTrace(); } 
	      

}
}
