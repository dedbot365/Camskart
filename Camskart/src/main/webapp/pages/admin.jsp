
<%@page import="util.StringUtils"%>
<%@page import="controller.database.DatabaseController"%>

<%
HttpSession user = (HttpSession)session.getAttribute("username");
DatabaseController dbController = new DatabaseController();
String userName = request.getParameter("username");
String userType = dbController.getUserType(userName);
if (user == null)
{
	session.setAttribute("messagekey", "You are not logged in");
	response.sendRedirect("login.jsp");
}
else 
{
	
	if (!"admin".equals(userType)) 
	{
	session.setAttribute("messagekey", "You are not logged in");
	response.sendRedirect("login.jsp");
	}
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
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
	<p>This is admin page</p>
	</body>
</html>