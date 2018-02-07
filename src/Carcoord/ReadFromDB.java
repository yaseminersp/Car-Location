package Carcoord;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class ReadFromDB {
	
	
	public static ArrayList<Coord> getListR(){
		
		
		ArrayList<Coord> returnCoord=new ArrayList<>();
		
		try
		{
			String connectionString="jdbc:mysql:///cartracking";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=(Connection)DriverManager.getConnection(connectionString,"car","car");
			
			try
			{
				String SQL="SELECT * FROM carcoordinates";
				Statement statement=(Statement)connection.createStatement();
				ResultSet rs=(ResultSet)statement.executeQuery(SQL);
				
				
				while(rs.next()){
					
					Coord coordR=new Coord();
					
					coordR.crdX=rs.getDouble(1);
					coordR.crdY=rs.getDouble(2);
					coordR.dateTime=rs.getTimestamp(3).toString();
					coordR.licensePlt=rs.getString(4);
					
					//System.out.println(rs.getDouble(1)+" "+rs.getDouble(2)+" "+rs.getTimestamp(3)+" "+rs.getString("plate"));
					
					returnCoord.add(coordR);
					
				}
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
			return returnCoord;
		}
		 
}
	

