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

	<h1><center> CUSTOMER DELETION</center> </h1>
<form action="deletecustomer" method="post">
    <fieldset>
        <legend>Enter Customer Details to Delete</legend>
        <label>Customer Name: <input type="text" name="name"></label>
		<br>
		<br>
       
        <input type="submit" value="Submit">
    </fieldset>
</form>
<br/>
<button onclick="window.location='customermaster.jsp'">Home</button>
</body>
</html>