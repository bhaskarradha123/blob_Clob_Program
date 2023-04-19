package practice_jdbc1.module1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Program4 {

	
	//retriving the file from database
	public static void main(String[] args) throws SQLException, IOException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1db","root","root");
		PreparedStatement statement=connection.prepareStatement("select * from file");
		  int n=1;
		ResultSet  resultSet=statement.executeQuery();
		while(resultSet.next()) {
			
			Clob c=resultSet.getClob(2);
			Reader reader=c.getCharacterStream();
			FileWriter fw=new FileWriter("C:\\Users\\POOJARI MAHESH\\Desktop\\AdvanceJava\\JDBC\\text"+n+".txt");
			n++;
			int i;
			while((i=reader.read())!=-1) {
			    fw.write(i);

			}
			
			
		}
		
	}

}
