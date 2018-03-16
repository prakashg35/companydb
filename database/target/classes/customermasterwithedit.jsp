<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title> Customer Management System</title> 
	<link rel="stylesheet" type="text/css" href="/resources/css/formstyle.css">
	<script type="text/javascript" src="/resources/js/app.js"></script>
</head>
<body>



<div align="center">
<h2>EDIT CUSTOMER'S INFO</h2>
                <table border="1">
                <th>ID</th>
                <th>Name</th>
                <th>ContactPerson</th>
                <th>Location</th>
                <th>Contactno</th>
                <th>Email</th>
                <th>Action</th>
                            
                <c:forEach var="contact" items="${lists}">
                
           
                 <tr>
                    <td>${contact.customerid}</td>
                    <td>${contact.name}</td>
                    <td>${contact.contactperson}</td>
                    <td>${contact.location}</td>
                    <td>${contact.contactno}</td>
                    <td>${contact.email}</td>
                     <td>                    
                        <a href="/getContact?id=${contact.customerid}">Edit</a>
                        </td>
                    
  </tr> 
                </c:forEach>             
            </table>
        </div>
        <button onclick="window.location='customermaster.jsp'">Home</button>
    </body>
</html>