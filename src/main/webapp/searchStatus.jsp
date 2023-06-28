<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Status</title>
<style ><%@ include file="table.css" %></style>
</head>
<body bgcolor="cyan">
	<br>
	<h1>Student Details</h1>
	<br>
	<c:choose>
		<c:when test="${student ne null || ! empty student  }">
			<table align="center">
				<tr>
					<th>SID</th>
					<td>${student.sid}</td>
				</tr>
				<tr>
					<th>SNAME</th>
					<td>${student.sname}</td>
				</tr>
				<tr>
					<th>SAGE</th>
					<td>${student.sage}</td>
				</tr>
				<tr>
					<th>SADDRESS</th>
					<td>${student.saddress}</td>
				</tr>

			</table>
		</c:when>
		<c:otherwise>
			<h1 style='color: red; text-align: center;'>No Record to display</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>