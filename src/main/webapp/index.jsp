<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style ><%@ include file="index.css" %></style>

<title>Student Home</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>

	<div class="divTop">
		<h1>WELCOME TO STUDENT DATA MANAGEMENT PORTAL</h1>
		
	</div>
	<div class="nav">
		<nav class="navbar">
			<div class="content">
				<ul class="ulist">
				    <br>
				    <br>
					<li><a href="./insert.html" target="body">INSERT</a></li>
					<li><a href="./update.html" target="body">UPDATE</a></li>
					<li><a href="./search.html" target="body">SEARCH</a></li>
					<li><a href="./delete.html" target="body">DELETE</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="body">
		<br> <br>
		<iframe src="body.html" width="950px" height="500px" name="body" frameborder="0"></iframe>
	</div>

</body>
</html>