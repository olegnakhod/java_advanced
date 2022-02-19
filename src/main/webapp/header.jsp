<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
<link rel="stylesheet" href="css/header.css" />
<title>Bucket</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<div class="float-left">
				<button class="btn btn-outline-danger" id="menu-toggle">Toggle Menu</button>
			</div>
			<div class="float-right">
				<button class="btn btn-danger" id="logout">Log Out</button>
			</div>
		</div>
	</nav>
	<div id="wrapper">
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li><a class="" href="${pageContext.request.contextPath}/cabinet.jsp">Home</a></li>
				<li><a class="create-product-option"  href="${pageContext.request.contextPath}/createArticle.jsp">Add	product</a></li>
				<li><a class="user-bucket-option" href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a></li>
			</ul>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.nicescroll/3.6.8-fix/jquery.nicescroll.min.js"></script>
	<script src="js/header.js"></script>
</body>
</html>