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
<%@include file="all.jsp"%>
</head>
<body>
	<%@include file="nav.jsp"%>

	<h1 class="text-center">Add your notes</h1>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form action="AddNotes" method="post">
					<div class="form-group">


						<label for="exampleInputEmail1">Enter Titles</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="title">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Enter Content</label><br>
						<textarea rows="9" cols="150" name="content"></textarea>
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Add Notes</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	<%@include file="all.jsp"%>
</body>
</html>