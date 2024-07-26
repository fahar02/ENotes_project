<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="all.jsp"%>
</head>
<body>
	<%@include file="nav.jsp"%>
	<div class="parent">
	
		<div class="child2">
			<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
			<h4>Registaration</h4>
			
			<form action="register" method="post">
				<label for="name">Full Name</label> <br> <input type="text"
					id="name" name="name"> <br> <label for="phone">Mobile
					Number</label> <br> <input type="number" id="phone" name="phone">
				<br> <label for="email">Email</label> <br> <input
					type="text" id="email" name="email"> <br> <label
					for="address">Address</label> <br> <input type="text"
					id="address" name="address"> <br> <label
					for="password">Password</label> <br> <input type="text"
					id="password" name="password"> <br> <br>
				<button type="submit">Submit</button>
				<button type="submit">Cancel</button>

			</form>
		</div>
	</div>


	<%@include file="footer.jsp"%>
	<%@include file="all.jsp"%>
</body>
</html>