<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title> Customer Management System</title> 
	<link rel="stylesheet" type="text/css" href="/resources/css/customerstyle.css">
	<script type="text/javascript" src="/resources/js/app.js"></script>
</head>
<body>

<div class= "wrapper">
	<div class= "heading">

		<h1> CUSTOMER MANAGEMENT SYSTEM </h1>

	</div>
	
<div class= "navigation">

<ul>
	<li><a>Admin</a>
		<ul>
			<li><a>Change Password</a></li>
			<li><a>Logout</a></li>
		</ul>	
	</li>
	<li><a>Customer Master</a>
		<ul>
			<li><a href= "newcustomer.jsp">New Customer Entry</a></li>
			<li><a href= "http://localhost:8080/customermasterdelete">Delete a Customer</a></li>
			<li><a href= "http://localhost:8080/customermasteredit">Edit a Customer</a></li>
			<li><a href = "http://localhost:8080/customermaster" >Open Customer Master</a></li>			
		</ul>
	</li>
	<li><a>Stock Data</a>
		<ul>
			<li><a href= "newstock.jsp">Add New Stock</a></li>
			<li><a href= "http://localhost:8080/stockmasteredit">Edit Stock Details</a></li>
			<li><a href = "http://localhost:8080/stockmaster">Open Stock Master</a></li>
		</ul>
	</li>
	<li><a>Orders</a>
		<ul>
			<li><a href= "neworder.jsp">Add New Order</a></li>
			<li><a href= "http://localhost:8080/pendingorder">View Pending Orders</a></li>
			<li><a href= "http://localhost:8080/completedorder">View Completed Orders</li>
		</ul>
	</li>
</ul>
</div>

</body>

</html>