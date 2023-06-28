<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
<style ><%@ include file="table.css" %></style>

</head>
<body bgcolor="cyan">
 <h1>Student Details</h1>
	<br>
	<c:choose>
		<c:when test="${student ne null || ! empty student }">

			<form method="post" action="./controller/update">

				<table  align="center">
					<tr>
						<th>Sid</th>
						<td><input type="text" readonly="readonly" name='sid'
							value="${student.sid }"></td>
					</tr>

					<tr>
						<th>Sname</th>
						<td><input type="text" name='sname' value="${student.sname }"></td>
					</tr>
					<tr>
						<th>Sage</th>
						<td><input type='text' name='sage' value="${student.sage }"></td>
					</tr>
					<tr>
						<th>Saddress</th>
						<td><input type='text' name='saddress'
							value="${student.saddress }"></td>
					</tr>

					<tr>
					<th></th>
					<td><input type='submit' name='update'
						value="update"></td>
					</tr>

				</table>

			</form>


		</c:when>
		<c:otherwise>
			<h1 style='color: red; text-align: center'>NO RECORD TO DISPLAY
			</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>