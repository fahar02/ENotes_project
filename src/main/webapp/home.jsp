<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
User user2 = (User) session.getAttribute("user");
if (user2 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error","pleas login");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>
<div class="container-fluid">
<div class="card py-5">
<div class="card-body text-center">
<img alt="save Notes" src="images/image1.jpg" style="height:500px; widht:100%">
<h1>START TAKING THE NOTES</h1>
<br>
<a href="addNotes.jsp" target="_self" style="height:40px; widht:40; color:black; background-color:white;
 border:2px solid black;">START-HERE</a>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
<%@include file="all.jsp" %>
</body>
</html>