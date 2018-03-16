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

	<h1><center> NEW ORDER ENTRY</center> </h1>
	<div class="container">
		<form action="addorder" method="post">
    <fieldset>
        <legend>Enter New Order Details below</legend>
		
		<br>
        	<input type="hidden" name="orderid" value="create">
		<br>
		<br>
        
  <label>Order ID: <input type="text" name="orderid" ></label>
		<br>
		<br>
         <label>Customer ID: <input type="text" name="customerid" ></label>
		<br>
		<br>
		 <label>Product ID: <input type="text" name="productid"  ></label>
		<br>
		<br>
		 <label>Order Date: <input type="text" name="orderdate" ></label>
		<br>
		<br>
		 <label>Status: <input type="text" name="status" ></label>
		<br>
		<br>
		 <label>Quantity: <input type="text" name="qty" ></label>
		<br>
		<br>
		 <label>Gross Amount: <input type="text" name="gross" ></label>
		<br>
		<br>
		 <label>Discount: <input type="text" name="discount" ></label>
		<br>
		<br>
		 <label>Net Total: <input type="text" name="nettotal" ></label>
		<br>
		<br>
		 <label>Payment: <input type="text" name="payment" ></label>
		<br>
		<br>
				
        <input type="submit" value="Submit">
    </fieldset>
</form>
<br/>
<button onclick="window.location='customermaster.jsp'">Home</button>
</body>
</html>
