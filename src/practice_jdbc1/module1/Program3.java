package practice_jdbc1.module1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program3 {
  //inserting the large text   =====create text column which ranges of 65535 ======text is a datatype 
	public static void main(String[] args) throws SQLException, FileNotFoundException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1db","root","root");
		PreparedStatement statement=connection.prepareStatement("insert into file values(?,?)");
		statement.setInt(1, 2);
		File  f=new File("C:\\Users\\POOJARI MAHESH\\Desktop\\AdvanceJava\\JDBC\\JDBC Notes.txt");
		FileReader file=new FileReader(f);
		statement.setCharacterStream(2,file,(int) f.length());
		
		int i=statement.executeUpdate();
		System.out.println(i+"rows affected");

		connection.close();
		
	}

}
