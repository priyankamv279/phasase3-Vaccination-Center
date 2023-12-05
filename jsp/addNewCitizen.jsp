<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addNewCitizen</title>
</head>
<body>
<h1>Add new Citixen</h1>
<form action="insertCitizen">
Citizen Name<input type="text" name="citizenName"><br>
City <select name="centerCity">
		     <option value="Mumbai">Mumbai</option>
		     <option value="Pune">Pune</option>
		     <option value="Hyderabad">Hyderabad</option>
		     <option value="Bengaluru">Bengaluru</option>
		     </select><br>
Vaccination Center<select name="vaccinationCenter">
		     <option value="CityHosiptal">City Hosiptal</option>
		     <option value="GalaxyClinic">Galaxy Clinic	</option>
		     <option value="SunshineHosiptal">Sunshine Hosiptal	</option>
		     <option value="Central">Central</option>
		     <option value="CentralMedicalCare">Central Medical Care</option>
		     <option value="Sanjeevani Clinic">Sanjeevani Clinic</option>		     
		     </select><br>
No of doses	<select name="noOfDoses">
		     <option value="0">0</option>
		     <option value="2">2</option>		     
		     </select><br>	  
<input type="submit" value="add">
</form>
</body>
</html>