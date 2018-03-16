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
<h2>PENDING ORDERS</h2>
                <table border="1">
                <th> ORDER ID</th>
                <th>CUSTOMER ID</th>
                <th>PRODUCT ID</th>
                <th>ORDER DATE</th>
                <th>STATUS</th>
                <th>QUANTITY</th>
                <th>GROSS</th>
                <th>DISCOUNT %</th>
                <th>NET TOTAL</th>
                <th>PAYMENT STATUS</th>
                
                
                <th>Action</th>
                            
                <c:forEach var="contact" items="${lists}">
                
           
                 <tr>
                    <td>${contact.orderid}</td>
                    <td>${contact.customerid}</td>
                    <td>${contact.productid}</td>
                    <td>${contact.orderdate}</td>
                    <td>${contact.status}</td>
                    <td>${contact.qty}</td>
                     <td>${contact.gross}</td>
                    <td>${contact.discount}</td>
                    <td>${contact.nettotal}</td>
                    <td>${contact.payment}</td>
                     <td>                    
                        <a href="/getOrder?id=${contact.orderid}">Edit</a>
                        </td>
                    
  </tr> 
                </c:forEach>             
            </table>
        </div>
        <button onclick="window.location='customermaster.jsp'">Home</button>
    </body>
</html>