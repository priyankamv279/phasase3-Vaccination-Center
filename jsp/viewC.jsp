<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewCitizen</title>
</head>
<body>
<h3>Citizen Information</h3>
<form action="viewCController" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    <input type="submit" value="View">
    </form></body>
</html>