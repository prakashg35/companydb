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
<h2>STOCK MASTER</h2>
                <table border="1">
                <th>ID</th>
                <th>Product Name</th>
                <th>Product Group</th>
                <th>MRP</th>
                <th>Stock</th>
                            
                <c:forEach var="stk" items="${lists}">
                
           
                 <tr>
                    <td>${stk.productid}</td>
                    <td>${stk.productname}</td>
                    <td>${stk.pdtgrp}</td>
                    <td>${stk.MRP}</td>
                    <td>${stk.stock}</td>
                                 
  </tr> 
                </c:forEach>             
            </table>
        </div>
        <button onclick="window.location='customermaster.jsp'">Home</button>
    </body>
</html>