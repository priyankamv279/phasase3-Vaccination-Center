<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<h1>Vaccination Application</h1>
<p>developed by Priyanka M V</p>

<h3>Login</h3>

<form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        
        <input type="submit" value="Login">
        
        </form><br>
        <h3>To create a new account click below:</h3>
        <form action="registration.jsp" method ="get">
    <input type="submit" value="Registration">
</form>
</body>
</html>