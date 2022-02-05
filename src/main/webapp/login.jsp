<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link type="text/css" rel="stylesheet" media="screen" href="style.css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<form action="login" method="post" class="position">

		<label for="login">Login :</label> <input name="login" class="formWithText"> <br> 
		<label for="password">Password: </label> <input name="password" class="formWithText"> <br>
		<div class = "lineWithButton">
			<input type="submit" value="submit" class="button"> 
			<a href="index.jsp" class="button">Registration</a>
		</div>

		<a href="notAutorizationPage.jsp">Page for don`t registration user</a>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>