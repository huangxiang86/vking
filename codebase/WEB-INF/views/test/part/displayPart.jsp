<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.vking.test.data.Part"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Create Part</title>
</head>
<body>
<%Part part =(Part) request.getAttribute("part");%>
<h1><%=part.getName()%> Profile</h1>



<h3> Name: <%=part.getName() %></h3>
<h3>Number:<%=part.getNumber()%></h3>
<h3>Description:<%=part.getDescribtion()%></h3>
</body>
</html>