<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" media="screen" href="style.css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<form action="registration" method="post" class="position">
	
		<label for="firstName">First Name :</label> <input name="firstName" class="formWithText">
			<br>
		<label for="lastName">Last Name :</label> <input name="lastName" class="formWithText">
			<br>
		<label for="email">Email :</label> <input name="email" class="formWithText">
			<br>	
		<label for="password">Password : </label> <input name="password" class="formWithText">
			<br>
		<input type="submit" value="submit" class="button">
	</form>




	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>