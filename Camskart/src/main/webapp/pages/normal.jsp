<%@page import="util.StringUtils"%>

<%
User user = (user)session.getAttribute("user")
if user == null
{
	session.setAttribute("messagekey", "You are not logged in");
	response.sendRedirect("login.jsp");
	return
}
else 
{
	
	if ("admin".equals(userType)) {
	print("You do not have access to this page.");
	response.sendRedirect(login.jsp);
	return

}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
<link rel="stylesheet" type="text/css" href="/Camskart/stylesheet/style.css" />
</head>
<body>
		<%
    String userSession = (String) session.getAttribute("username");
    String cookieUsername = null;
    String cookieSessionID = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                cookieUsername = cookie.getValue();
            }
            if (cookie.getName().equals("JSESSIONID")) {
                cookieSessionID = cookie.getValue();
            }
        }
    }
%>
		<div class="welcome-container">
			<h1>Hello <%=cookieUsername %>. Welcome to our Admin page!</h1>
			<h3>Cookie session Id is <%=cookieSessionID %></h3>
			<p>Session username: <%=userSession %></p>
			<a href="${pageContext.request.contextPath}/pages/home2.jsp">
				<button class="home-button">Continue to Home Page</button>
			</a>
		</div>
	</body>
</html>