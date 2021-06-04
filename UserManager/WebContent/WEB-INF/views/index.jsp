<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserManager</title>
</head>
<body>
	<div align="center">
		<h1>User Manager</h1>

		<form method="get" action="search">

			<input type="text" name="keyword" /> <input type="submit"
				value="Search" />

		</form>
<h3> <a href = "new"><input type="button" value = "New User" > </a> </h3> <br> 
		<table border="1" cellpadding = "5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${listUser}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.address}</td>
					<td padding="3">
					    <a href="edit?id=${user.id}"><input type="button" value="Edit"></a> 
					    &nbsp; 
					    <a href="delete?id=${user.id}"><input type="button" value="Del"></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>