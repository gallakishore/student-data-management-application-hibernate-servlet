<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<br>
	<br>
	<br>

	<c:choose>
		<c:when test="${status  eq 'success'}">
			<h1 style="color: green; text-align: center">Deletion Successful</h1>
		</c:when>

		<c:when test="${status  eq 'record notfound'}">
			<h1 style="color: red; text-align: center">Student with that id
				is not available</h1>
		</c:when>


		<c:otherwise>
			<h1 style="color: green; text-align: center">Deletion Not
				Successful</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>