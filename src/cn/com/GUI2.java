package cn.com;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.JFrame;

import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import org.bytedeco.javacpp.opencv_imgcodecs;

public class GUI2 {
	
	
	public static void main(String[] args) throws  Exception, InterruptedException {
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
	     grabber.start();   //��ʼ��ȡ����ͷ����
	     CanvasFrame canvas = new CanvasFrame("����ͷ");//�½�һ������
	     canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     canvas.setAlwaysOnTop(true);
	     while(true){
	         if(!canvas.isDisplayable()){//�����Ƿ�ر�
	        	    grabber.stop();//ֹͣץȡ
	        	    System.exit(2);//�˳�
	        	    break;
	         }
	         canvas.showImage(grabber.grab());//��ȡ����ͷͼ�񲢷ŵ���������ʾ�� �����Frame frame=grabber.grab(); frame��һ֡��Ƶͼ��
	         Thread.sleep(50);//50����ˢ��һ��ͼ��
	     }
		
		
		
		
		
		
		
//		Webcam webcam = Webcam.getDefault();
//		webcam.setViewSize(WebcamResolution.VGA.getSize());
//		WebcamPanel panel = new WebcamPanel(webcam);
//		panel.setFPSDisplayed(true);
//		panel.setDisplayDebugInfo(true);
//		panel.setImageSizeDisplayed(true);
//		panel.setMirrored(true);
//		JFrame window = new JFrame("Test webcam panel");
//		window.add(panel);
//		window.setResizable(true);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.pack();
//		window.setVisible(true);
		
 
	}

	

	
}
