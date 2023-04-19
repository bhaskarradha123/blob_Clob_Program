package practice_jdbc1.module1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program1 {
	//storing an image
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//		//load or register
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		//establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1db","root","root");
		//create statement
		PreparedStatement statement=connection.prepareStatement("insert into image values(?,?)");
		statement.setInt(1,4);
		
		FileInputStream fin=new FileInputStream("C:\\Users\\POOJARI MAHESH\\Pictures\\Camera Roll\\WIN_20220805_16_53_26_Pro.jpg");  

		statement.setBinaryStream(2,fin,fin.available());
		//execute statement
		statement.execute();
		System.out.println("inserted");
		//close the connection
		statement.close();
		connection.close();
		

	}

}
