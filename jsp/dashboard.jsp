<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="ISO-8859-1">
    <title>Dashboard</title>
 <style>
        /* Adjust the style as needed */
        .btn-container {
            display: flex;
            margin-bottom: 20px; /* Add space between buttons and table */
        }

        .btn-container form {
            margin-right: 5px; /* Adjust as needed for spacing */
        }

        .btn-container form:last-child {
            margin-right: 0; /* Remove margin for the last button */
        }
    </style>
</head>
<body>
 <h1>Welcome, Admin!</h1>

    <div class="btn-container">
        <form action="getallCitizen" method="post">
            <input type="submit" value="Citizens">
        </form>            

        <form action="getall">
            <input type="submit" value="Vaccination Centers">
        </form>            

        <form action="logout.jsp" method="post">
            <input type="submit" value="Logout">
        </form>
    </div>
    
    
</body>
</html>
