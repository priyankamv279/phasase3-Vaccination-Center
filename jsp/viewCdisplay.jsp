<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                <%@page import="com.example.demo.pojo.*" %>
    <%@page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view each Citizen display</title>
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
<h1>Citizen Information</h1>
        <form action="getallCitizen">
            <input type="submit" value="View The citizen">
        </form><br>
        
            <% Citizen citizen = (Citizen) request.getAttribute("citizen"); %>
   <% if (citizen != null) { %>
        <table border="1">
            <tr>
             <td>ID</td>
            <td>Name</td>
            <td>City</td>
            <td>No of Doses</td>
            <td>Vaccination Status</td>
            <td>Vaccination Center</td>
            </tr>
        
        <tr>
<td><%=citizen.getId()%></td>
<td><%=citizen.getPersonName() %></td>
<td><%= citizen.getVaccinationCenter().getVaccinationCenterCity() %></td>
<td><%=citizen.getNumberOfDoses() %></td>
<td><%=citizen.getVaccinationStatus() %></td>
<td>
    <a href="viewVC.jsp?id=<%=citizen.getVaccinationCenter().getVaccinationCenterId()%>">
        <%=citizen.getVaccinationCenter().getVaccinationCenterName() %>
    </a>
</td>
  </tr>
        </table>
    <% } else { %>
        <p>Citizen not found.</p>
    <% } %>
</body>
</html>