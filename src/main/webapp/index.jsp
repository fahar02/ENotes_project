<%@page import="net.bytebuddy.asm.Advice.AllArguments"%>
<%@page
	import="org.hibernate.hql.internal.ast.util.ASTUtil.IncludePredicate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="all.jsp" %>
<meta charset="ISO-8859-1">
<title>Home page</title>

</head>
<body>

	<%@include file="nav.jsp" %>
		<div class="container-fluid back-img">
		<div class="text-center">
		<h1 class="text">
		<i class="fa fa-book text" aria-hidden="true"></i>E NOtes-Save Your Notes</h1>
		<a href="login.jsp" class="btn btn-light mr-30">
		<i class="fa fa-sign-in" aria-hidden="true"></i>Login</a>
		<a href="register.jsp" class="btn btn-light mr-20">
		<i class="fa fa-registered" aria-hidden="true"></i>Register</a>
		</div>
		
		</div>
<%@include file="footer.jsp" %>

	<%@include file="all.jsp" %>
</body>
</html>