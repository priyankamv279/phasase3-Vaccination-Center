<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration</title>
</head>
<body>
<h1>Admin Registration</h1>
<form action="registration" method= "post">
 <label for="username">Name:</label>
        <input type="text" id="username" name="username"><br><br>
        
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        
        <input type="submit" value="Register">
</form>
</body>
</html>