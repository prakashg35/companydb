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
<form action="addorder" method="post">
    <fieldset>
        <legend>EDIT EPNDING ORDER DETAILS</legend>
        <label>Order ID: <input type="text" name="orderid" value = ${contact.orderid} readonly></label>
		<br>
		<br>
         <label>Customer ID: <input type="text" name="customerid" value = ${contact.customerid} readonly></label>
		<br>
		<br>
		 <label>Product ID: <input type="text" name="productid" value = ${contact.productid} ></label>
		<br>
		<br>
		 <label>Order Date: <input type="text" name="orderdate" value = ${contact.orderdate} readonly></label>
		<br>
		<br>
		 <label>Status: <input type="text" name="status" value = ${contact.status} readonly></label>
		<br>
		<br>
		 <label>Quantity: <input type="text" name="qty" value = ${contact.qty} ></label>
		<br>
		<br>
		 <label>Gross Amount: <input type="text" name="gross" value = ${contact.gross} ></label>
		<br>
		<br>
		 <label>Discount: <input type="text" name="discount" value = ${contact.discount} ></label>
		<br>
		<br>
		 <label>Net Total: <input type="text" name="nettotal" value = ${contact.nettotal} ></label>
		<br>
		<br>
		 <label>Payment: <input type="text" name="payment" value = ${contact.payment} readonly></label>
		<br>
		<br>
				
        <input type="submit" value="Submit">
    </fieldset>
</form>
<br/>
<button onclick="window.location='customermaster.jsp'">Home</button>
</body>
</html>
