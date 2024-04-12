<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Camskart/stylesheet/login.css" />
</head>
<body>
	<div class="login-box">
		<%
		String errorMessage = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
		if (errorMessage != null && !errorMessage.isEmpty()) {
		%>
		<p class ="error-message"><%=errorMessage %></p>
		<%
		}
		%>
		<h2>Login</h2>
		<form action="/Camskart/LoginServlet" method="post">
			<div class="row">
				<div class="col">
					<label for="username">Username:</label> 
					<input type="text" id="username" name="username" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> 
					<input type="password" id="password" name="password" required>
				</div>
			</div>
			<button type="submit" class="login-button">Login</button>
		</form>
	</div>
</body>
</html>