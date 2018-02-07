<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Carcoord.ReadFromDB"%>
<%@ page import="Carcoord.Coord"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Tracking</title>
<style>
		html,body {
			height: 100%;
			margin:0;
			padding:0;
		}
		#map {
		height:100%;
		}
	</style>
</head>
<body>
	<div id="map"></div>
	<script>
	
	
	function initMap(){
				
		var map=new google.maps.Map(document.getElementById('map'),{
			zoom:3,
			center: {lat:0,lng: -180},
			mapTypeId:'terrain'
		});
		
	<% 	ArrayList <Coord> returnCoord = ReadFromDB.getListR();
		
 	String crd="";
		
	for(Coord coordR : returnCoord){
			
			crd+="{"+"lat:"+Double.toString(coordR.getcrdX())+","+"lng:"+Double.toString(coordR.getcrdY())+"}"+",";	
			System.out.println(crd);
	} %> 
		
		var carCoordinates=[<%out.print(crd);%>];
		
		var carPath=new google.maps.Polyline({
			path:carCoordinates,
			geodesic:true,
			strokeColor:'#FF0000',
			strokeOpacity:1.0,
			strokeWeight:2
		});
		
		carPath.setMap(map);
	}
	
	</script>
	<script async defer 
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDm7yF-jjPsLGVoH8ieu-ESezpe5JcUUi0&callback=initMap">
	</script>
</body>
</html>
