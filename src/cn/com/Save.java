package cn.com;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;



public class Save {
	static PreparedStatement stmt = null;
	static ResultSet rs = null;
	static String sql = null;
	public static void AddMess(String Facetoke) throws  SQLException{
		try{
			sql="insert into token(face) values(?)";
			stmt = Connecting.getconn().prepareStatement(sql);
			stmt.setString(1,Facetoke);
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"提交成功");	
		}
			catch(SQLException e){
				e.printStackTrace();
			}
		
}
	
  public static  String[] GetMess()throws SQLException{
	   String[] arr=new String[100];
	   try{
		     sql="select face from token ";
			 stmt = Connecting.getconn().prepareStatement(sql);
			 rs=stmt.executeQuery();
			  List<String> list=new ArrayList<String>();
			  while (rs.next()) {
				 list.add(rs.getString(1)); 
			  }
			  if(list != null && list.size()>0){
				  arr=new String[list.size()];
				  for(int i=0;i<list.size();i++){  
					  arr[i]=list.get(i);//数组赋值了。  
					  
				  }
			  }
			  
			  
			return arr;
		     
	   }catch(SQLException e){
		   e.printStackTrace();	 
		   }
	return arr;
	  
  }
}

