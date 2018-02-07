package Carcoord;

import java.util.ArrayList;


public class deneme {
	
	public static void main(String[] args){
		
		ArrayList<Coord> returnCoord = ReadFromDB.getListR();
		
		for(Coord coordR : returnCoord){
			
			double lat=coordR.getcrdX();
			double lng=coordR.getcrdY();
			System.out.println(lat);
			System.out.println(lng);
			
		}
	}
}
