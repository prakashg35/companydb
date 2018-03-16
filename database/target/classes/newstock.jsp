<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title> Customer Management System</title> 
	<link rel="stylesheet" type="text/css" href="/resources/css/formstyle.css">
	<script type="text/javascript" src="/resources/js/app.js"></script>
</head>
<body>

	<h1><center> NEW CUSTOMER ENTRY</center> </h1>
<form action="addstock" method="post">
    <fieldset>
        <legend>Enter New Customer Details</legend>
	<input type="hidden" name="productid" value="create">
		<br>
		<br>
        
        
        <label>Product Name: <input type="text" name="productname" ></label>
		<br>
		<br>
        <label>Product Group: <input type="text" name="pdtgrp"></label>
		
		<br>
		<br>
        <label>MRP: <input type="text" name="MRP"></label>
		<br>
		<br>
        <label>Stock: <input type="text" name="stock"></label>
		
		<br>
		<br>
        
        <input type="submit" value="Submit">
    </fieldset>
</form>
<br/>
<button onclick="window.location='customermaster.jsp'">Home</button>
</body>
</html>
