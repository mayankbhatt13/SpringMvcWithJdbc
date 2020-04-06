<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Contact</title>
</head>
<body>
	<div align="center">
		<h3>New/Edit Contact</h3>
		<form:form action="save" method="post" modelAttribute="contact">
			<table cellpadding="5">
			<form:hidden path="id"/>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><form:input path="Phone" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value ="save"/></td>
			</tr>
			</table>
		</form:form>
	</div>
</body>
</html>