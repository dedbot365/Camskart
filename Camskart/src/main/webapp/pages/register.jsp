<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Camskart/stylesheets/registerstyles.css" />
</head>
<body>
    <div class="container">
        <%-- Display error message if it exists --%>
        <%
        String errorMessage = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
        if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
        <p class="error-message"><%=errorMessage %></p>
        <%
        }
        %>
        <h1>Registration Form</h1>
        <form action="/Camskart/RegisterServlet" method="post">
            
            <div class="row">
                <div class="col">
                    <label for="<%=StringUtils.FIRST_NAME%>">First Name:</label> 
                    <input type="text" id="<%=StringUtils.FIRST_NAME%>" name="<%=StringUtils.FIRST_NAME%>" required>
                </div>
                <div class="col">
                    <label for="<%=StringUtils.LAST_NAME%>">Last Name:</label> 
                    <input type="text" id="<%=StringUtils.LAST_NAME%>" name="<%=StringUtils.LAST_NAME%>" required>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label for="<%=StringUtils.USER_NAME%>">Username:</label> 
                    <input type="text" id="<%=StringUtils.USER_NAME%>" name="<%=StringUtils.USER_NAME%>" required>
                </div>
                <div class="col">
                    <label for="<%=StringUtils.PASSWORD%>">Password:</label> 
                    <input type="password" id="<%=StringUtils.PASSWORD%>" name="<%=StringUtils.PASSWORD%>" required>
                </div>
                <div class="col">
						<label for="retypePassword">Retype Password:</label> <input
							type="password" id="retypePassword" name="retypePassword" required>
				</div>
            </div>
            
            <div class="row">
                <div class="col">
                    <label for="<%=StringUtils.BIRTHDAY%>">Birthday:</label> 
                    <input type="date" id="<%=StringUtils.BIRTHDAY%>" name="<%=StringUtils.BIRTHDAY%>" required>
                </div>
                <div class="col">
                    <label for="<%=StringUtils.GENDER%>">Gender:</label> 
                    <select id="<%=StringUtils.GENDER%>" name="<%=StringUtils.GENDER%>" required>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Others</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label for="<%=StringUtils.EMAIL%>">Email:</label> 
                    <input type="email" id="<%=StringUtils.EMAIL%>" name="<%=StringUtils.EMAIL%>" required>
                </div>
                <div class="col">
                    <label for="<%=StringUtils.PHONE_NUMBER%>">Phone Number:</label> 
                    <input type="tel" id="<%=StringUtils.PHONE_NUMBER%>" name="<%=StringUtils.PHONE_NUMBER%>" required>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label for="<%=StringUtils.STREET%>">Street:</label> 
                    <input type="text" id="<%=StringUtils.STREET%>" name="<%=StringUtils.STREET%>" required>
                </div>
                <div class="col">
                    <label for="<%=StringUtils.CITY%>">City:</label> 
                    <input type="text" id="<%=StringUtils.CITY%>" name="<%=StringUtils.CITY%>" required>
                </div>
            </div>
            <div class="row">
                
                <div class="col">
                    <label for="<%=StringUtils.ZONE%>">Zone:</label> 
                    <input type="text" id="<%=StringUtils.ZONE%>" name="<%=StringUtils.ZONE%>" required>
                </div>
                <div class="col">
                    <label for="<%=StringUtils.POSTAL_CODE%>">Postal Code:</label> 
                    <input type="text" id="<%=StringUtils.POSTAL_CODE%>" name="<%=StringUtils.POSTAL_CODE%>" required>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label for="<%=StringUtils.COUNTRY%>">Country:</label> 
                    <input type="text" id="<%=StringUtils.COUNTRY%>" name="<%=StringUtils.COUNTRY%>" required>
                </div>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
