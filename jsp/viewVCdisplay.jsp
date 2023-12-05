<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
            <%@page import="com.example.demo.pojo.*" %>
<%@ page import="com.example.demo.service.*" %>
            <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewVCdisplay</title>
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
<h3>Center Information</h3>
        <form action="getall">
            <input type="submit" value="Vaccination all Centers">
        </form><br>
        
    <% Vaccinationcenter center = (Vaccinationcenter) request.getAttribute("center"); %>
    <% if (center != null) { %>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Vaccination Center Name</td>
                <td>City</td>
            </tr>
            <tr>
                <td><%= center.getVaccinationCenterId() %></td>
                <td><%= center.getVaccinationCenterName() %></td>
                <td><%= center.getVaccinationCenterCity() %></td>
            </tr>
        </table>
        <!--  -->
           <h3>All citizens of this center</h3>
           
           <% 
           List<Citizen> citizens = (List<Citizen>) request.getAttribute("citizens"); 
           if (citizens != null && !citizens.isEmpty()) {
        %>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Action</td>
                    </tr>
                <% for (Citizen citizen : citizens) { %>
                    <tr>
                    <td><%= citizen.getId() %></td>
                     <td><%= citizen.getPersonName() %></td>
                     <td>
    <a href="viewC.jsp?id=<%= citizen.getVaccinationCenter().getVaccinationCenterId() %>">
        View
    </a>
</td>

                         </tr>
                <% } %>
            </table>
        <% } else { %>
            <p>No citizens found for this center.</p>
        <% } %>
        <!--  -->
    <% } else { %>
        <p>Center not found.</p>
    <% } %>
    
 
    
</body>
</html>