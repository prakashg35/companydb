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
<form action="savecustomer" method="post">
    <fieldset>
        <legend>Enter New Customer Details</legend>
	<input type="hidden" name="customerid" value="create">
		<br>
		<br>
        
        
        <label>Customer Name: <input type="text" name="name" ></label>
		<br>
		<br>
        <label>Contact Person: <input type="text" name="contactperson"></label>
		
		<br>
		<br>
        <label>Contact Number: <input type="text" name="contactno"></label>
		<br>
		<br>
        <label>eMail ID: <input type="text" name="email"></label>
		
		<br>
		<br>
        <label>Location: <input type="text" name= "location"></label>
		<br>
		<br>
		
        <input type="submit" value="Submit">
    </fieldset>
</form>
<br/>
<button onclick="window.location='customermaster.jsp'">Home</button>
</body>
</html>
