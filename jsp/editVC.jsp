<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.example.demo.pojo.*" %>
    <%@page import="java.util.*" %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editVC</title>
</head>
<body>
<h1>Edit Vaccination Center</h1>
<form action="edit" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    Center Name: <input type="text" name="centerName"><br>
    Center City: <select name="centerCity">
		     <option value="Mumbai">Mumbai</option>
		     <option value="Pune">Pune</option>
		     <option value="Hyderabad">Hyderabad</option>
		     <option value="Bengaluru">Bengaluru</option>
		     </select><br>
    <input type="submit" value="Update">

</form></body>
</html>
