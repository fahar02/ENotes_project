<%@page import="dto.AddNotes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dto.User"%>
<%@page import="dao.Database" %>
<%
User user = (User) session.getAttribute("user");
if (user == null) {
	response.sendRedirect("login.jsp");
}
%>
<%
Integer noteid = Integer.parseInt(request.getParameter("id"));
Database database=new Database();
AddNotes addNotes=database.getAddNotes(noteid);
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
	<h1 class="text-center">Edit your notes</h1>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form action="EditNotes" method="post">
					<div class="form-group">
						<input type="hidden" value="<%=noteid%>" name="id"> <label
							for="exampleInputEmail1">Enter Titles</label> <input type="text"
							class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="title" value="<%=addNotes.getTitle()%>">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Enter Content</label><br>
						<textarea rows="9" cols="150" name="content"><%=addNotes.getContent()%></textarea>
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Edit Notes</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<%@include file="all.jsp"%>
	<%@include file="footer.jsp"%>
</body>
</html>