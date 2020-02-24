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
	     grabber.start();   //开始获取摄像头数据
	     CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
	     canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     canvas.setAlwaysOnTop(true);
	     while(true){
	         if(!canvas.isDisplayable()){//窗口是否关闭
	        	    grabber.stop();//停止抓取
	        	    System.exit(2);//退出
	        	    break;
	         }
	         canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
	         Thread.sleep(50);//50毫秒刷新一次图像
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
