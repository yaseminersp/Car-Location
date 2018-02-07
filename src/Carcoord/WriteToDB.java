package Carcoord;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



public class WriteToDB {
	
	
	public static void main(String[] args) throws SQLException{
		
		ArrayList<Coord> coordinates=TextReader.getList();
		
		
		try
		{
			String connectionString="jdbc:mysql:///cartracking";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=(Connection)DriverManager.getConnection(connectionString,"car","car");
			
			try
			{					
						
				String SQLwrt= "INSERT INTO carcoordinates"+"(lat, lng, createdat, plate) VALUES"+"(?,?,?,?)";
				PreparedStatement statement=(PreparedStatement)connection.prepareStatement(SQLwrt);
				
				
				for(Coord coord : coordinates){
					
					SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
					java.util.Date date=format.parse(coord.dateTime);
					java.sql.Timestamp time=new java.sql.Timestamp(date.getTime());
					
					
					statement.setDouble(1,coord.crdX);
					statement.setDouble (2,coord.crdY);
					statement.setTimestamp(3, time);
					statement.setString (4,coord.licensePlt);
					
					System.out.println("Success");
					statement.executeUpdate();
				
				}
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
		}
			
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
