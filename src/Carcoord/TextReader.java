package Carcoord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class TextReader {
	
		public static ArrayList<Coord> coordinates;
			
		
		public static ArrayList<Coord> getList(){			
			
			try(BufferedReader br=new BufferedReader(new FileReader("D:\\koordinat(1).txt"))){
				
				String sCurrentLine;
				coordinates=new ArrayList<>();
				
							
				while((sCurrentLine=br.readLine())!=null){
					
					
					Coord coord=new Coord();
					
					String[] parts= sCurrentLine.split("[|]");
					
					
					coord.crdX=Double.parseDouble(parts[0]);
					coord.crdY=Double.parseDouble(parts[1]);
					coord.dateTime=parts[2];
					coord.licensePlt=parts[3];
					
					coordinates.add(coord);
												
				}
				
				//System.out.println(coordinates);
			
			}
			
			catch (IOException e){
				
				e.printStackTrace();
			}
		
			return coordinates;
		}	
	
}
