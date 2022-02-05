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

	<form action="addMagazines" method="post"  class="position">
	<h3>Add new magazine</h3>
		<label for="name">Name:</label> <input name="name" class="formWithText">
			<br>
		<label for="price">Price:</label> <input name="price" class="formWithText">
			<br>
		<input type="submit" value="add" class="button">
	</form>




	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>