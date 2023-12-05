<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <%@page import="com.example.demo.pojo.*" %>
    <%@page import="java.util.*" %>
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
    
    <h1>Centers</h1>
    <form action="addNewCenter.jsp" method ="get">
    <input type="submit" value="Add New Center"><br><br>
    </form>
    

    <%List<Vaccinationcenter> list=(List<Vaccinationcenter>)request.getAttribute("list");  %>
            <h2>Total Vaccination Center found: <%= list.size() %></h2>
        
        <table border="1">
        <tr>
            <td>ID</td>
            <td>Vaccination Center Name</td>
            <td>City</td>
            <td>Action</td>
        </tr>
<%for(Vaccinationcenter ss:list){ %>
<tr>
<td><%=ss.getVaccinationCenterId()%></td>
<td><%=ss.getVaccinationCenterName() %></td>
<td><%=ss.getVaccinationCenterCity() %></td>
                <td>
                    <div class="btn-container">
                
                    <form action="viewVC.jsp?id=<%=ss.getVaccinationCenterId()%>" method="post">
                        <input type="submit" value="View">
                    </form>
                   <form action="editVC.jsp?id=<%=ss.getVaccinationCenterId()%>" method="post">
                        <input type="submit" value="Edit">
                    </form>
                   <form action="deleteVC?id=<%=ss.getVaccinationCenterId()%>" method="post">
                   <input type="submit" value="Delete">
                   </form>
                    </div>
                </td>
</tr>
<%} %>
</table>
</body>
</html>
