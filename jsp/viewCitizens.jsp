<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@page import="com.example.demo.pojo.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewCitizens</title>
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
    
    <h1>Citizens</h1>
    <form action="addNewCitizen.jsp" method ="get">
    <input type="submit" value="Add New Center"><br><br>
    </form>

 <%List<Citizen> list=(List<Citizen>)request.getAttribute("list");  %>
            <h2>Total Citizens found: <%= list.size() %></h2>

       <table border="1">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>City</td>
            <td>No of Doses</td>
            <td>Vaccination Status</td>
            <td>Vaccination Center</td>
            <td>Action</td>
        </tr>
        
        <%for(Citizen ss:list){ %>
        
        <tr>
<td><%=ss.getId()%></td>
<td><%=ss.getPersonName() %></td>
<td><%= ss.getVaccinationCenter().getVaccinationCenterCity() %></td>
<td><%=ss.getNumberOfDoses() %></td>
<td><%=ss.getVaccinationStatus() %></td>
<td><%=ss.getVaccinationCenter().getVaccinationCenterName() %></td>

                <td>
                    <div class="btn-container">
                
                    <form action="viewC.jsp?id=<%=ss.getId()%>" method="post">
                        <input type="submit" value="View">
                    </form>
                   <form action="editC.jsp?id=<%=ss.getId()%>" method="post">
                        <input type="submit" value="Edit">
                    </form>
                   <form action="deleteC?id=<%=ss.getId()%>" method="post">
                   <input type="submit" value="Delete">
                   </form>
                    </div>
                </td>
</tr>
<%} %>
</table>
        
        
</body>
</html>