<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Camskart/stylesheets/loginstyle.css" />
</head>
<body>
	<div class="login-box">
	
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
			
			<p class="accountcreatemsg">Don't have an account?</p>
			
			
			<a href="${pageContext.request.contextPath}/pages/register.jsp">Create one now</a><br>
			 
			
			<button type="submit" class="login-button">Login</button><br>
			<%
			String errorMessage = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
					if (errorMessage != null && !errorMessage.isEmpty()) {
			%>
				<p class ="error-message"><%=errorMessage %></p>
					<%
					}
				%>
			
			
		</form>
	</div>
</body>
</html>