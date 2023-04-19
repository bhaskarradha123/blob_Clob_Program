package practice_jdbc1.module1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Program2 {

	public static void main(String[] args) throws SQLException, IOException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1db","root","root");
		PreparedStatement statement=connection.prepareStatement("select * from image");
		   int a=8;
		ResultSet  resultSet=statement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			Blob b=resultSet.getBlob(2);
			byte barr[]=b.getBytes(1,(int)b.length());//image in byte form
         
			FileOutputStream fout=new FileOutputStream("C:\\Users\\POOJARI MAHESH\\Pictures\\Screenshots\\sonoo"+a +".jpg"); 
			++a;
			fout.write(barr);  
			              
			fout.close();  
			}//end of if  
			System.out.println("ok");  			
		}
	}


