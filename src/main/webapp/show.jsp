<%@page import="dto.AddNotes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <% User user=(User)session.getAttribute("user"); 
    if(user==null){
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
<%List <AddNotes> notes=(List)request.getAttribute("list"); %>

<div class="container">
<h2 class="text-center">All Notes</h2>
<%for(AddNotes note:notes){ %>
<div class="row">
<div class="col-md-3">
<div class="card mt-9">
<img src="./images/image1.jpg" class="card-img-top mx-auto" style="max-auto:100px;">
<div class="card-body p-4">

<h5 class="card-title"></h5>
<p></p>

<p>
<b class="text-success">Published by:<%=user.getName()%></b><br>
<b class="text-primary"><%=note.getContent() %></b>
</p>

<p>
<b class="text-success">Published Date:<%=note.getDate() %></b>
<b class="text-success"></b>
</p>


<div class="container text-center mt-2">
<a href="deleteNotes?id=<%=note.getId() %>" class="btn-btn-danger">Delete</a>
<a href="editnote.jsp?id=<%=note.getId() %>" class="btn-btn-primary">Edit</a>
</div>
</div>

</div>


</div>



</div>
<%} %>
</div>

<%@include file="all.jsp" %>
<%@include file="footer.jsp" %>

</body>
</html>