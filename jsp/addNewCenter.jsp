<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addNewCenter</title>
</head>
<body>
<h1>Add new Vaccination Center</h1>
<form action="insert" method= "post">
Center Name<input type="text" name="centerName"><br>
Center City <select name="centerCity">
		     <option value="Mumbai">Mumbai</option>
		     <option value="Pune">Pune</option>
		     <option value="Hyderabad">Hyderabad</option>
		     <option value="Bengaluru">Bengaluru</option>
		     </select><br>

<input type="submit" value="add">

</form></body>
</html>