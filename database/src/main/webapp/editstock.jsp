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

	<h1><center> EDIT CUSTOMER</center> </h1>
<form action="addstock" method="post">
    <fieldset>
        <legend>EDIT STOCK DETAILS</legend>
        <label>Product ID: <input type="text" name="productid" value = ${stk.productid} readonly></label>
		<br>
		<br>
        <label>Product Name: <input type="text" name="productname" value = ${stk.productname} ></label>
		<br>
		<br>
        <label>Product Group: <input type="text" name="pdtgrp" value = ${stk.pdtgrp}></label>
		
		<br>
		<br>
        <label>MRP: <input type="text" name="MRP" value = ${stk.MRP}></label>
		<br>
		<br>
        <label>Stock: <input type="text" name="stock" value = ${stk.stock}></label>
		
		<br>
		<br>
        <input type="submit" value="Submit">
    </fieldset>
</form>
<br/>
<button onclick="window.location='customermaster.jsp'">Home</button>
</body>
</html>
