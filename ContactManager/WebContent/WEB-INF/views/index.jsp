<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Contact Manager</title>
<style type="text/css">
.headerClass{
	background-color: black;
    height: 73px;
    padding-top: 5px;
    padding-left: 11px;
}
.label1{
    padding-top: 7px;
    font-size: 28px;
    font-weight: bold;
}
.label2{
	float: right;
    padding-right: 3%;
    padding-top: 7px;
    font-size: 28px;
    font-weight: bold;
}

</style>
</head>
<body >
	<div class="headerClass">
		<label class="label1">Contact Manager Application</label>
		<label class="label2">Welcome User</label>
	</div>
	<div align="center" style="padding-left: 10px;padding-right: 10px;">
		<h2><a href="new" class="btn btn-success" style="float: right !important;margin-bottom: 15px">Add Contact</a></h2>
		<h3>User Details</h3>
		<table border="1" cellpadding="5" class="table table-bordered ">
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listContact}" var="contact" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.phone}</td>
					<td>
						<a href="edit?id=${contact.id}">Edit</a>
						&nbsp;&nbsp;<a href="delete?id=${contact.id}">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>