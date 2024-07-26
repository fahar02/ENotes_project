<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all.jsp"%>
</head>
<body>
	<%@include file="nav.jsp"%>

	
	<div class="parent">
		<div class="child2">
			<i class="fa fa-user fa-3x" aria-hidden="true"></i>
			<h4>User Login</h4>
			<%
		String	msg=(String)session.getAttribute("login-fail");
			if(msg!=null){%>
				<div class="alert alert-danger" role="alert"><%=msg %></div>
		<%session.removeAttribute("login-fail");}%>
		<% String error=(String)session.getAttribute("login-error");
		if(error!=null)
		{%>
		<div class="alert alert-danger" role="alert"><%=error%></div>
			
		<%session.removeAttribute("login-error");}
		%>
		<%
	String logout = (String) session.getAttribute("logoutMsg");
	if (logout != null) {
	%>
	<div class="alert alert-success" role="alert"><%=logout%></div>
	<%
	session.removeAttribute("logoutMsg");
	}
	%>
		
			<form action="login" method="post">
				<br> <label>Email:</label> <br> <input type="text"
					name="email"> <br> <label>Password:</label> <br>
				<input type="text" name="password"> <br> <br> <input
					type="submit">
			</form>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	<%@include file="all.jsp"%>
</body>
</html>