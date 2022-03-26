<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Lesson-19</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">Spring MVC -Logos</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Create</a></li>
				<li><a href="profile">Profile</a></li>
			</ul>
		</div>
	</nav>


	<c:choose>
		<c:when test="${mode == 'STUDENT_PROFILE'}">
			<p>First Name: ${student.firstName}</p>
			<p>Last Name: ${student.lastName}</p>
			<p>Age: ${student.age}</p>
			<img src="#singleFileUploadSuccess">
		</c:when>
		
		<c:when test="${mode == 'STUDENT_CREATE'}">
			<form action="save" method="POST">
				<div class="form-group">
					<label for="firstName">First Name :</label> <input type="text"
						value="${student.firstName}" class="form-control" id="firstName"
						name="firstName">
				</div>
				<div class="form-group">
					<label for="lastName">Last Name :</label> <input type="text"
						value="${student.lastName}" class="form-control" id="lastName"
						name="lastName">
				</div>
				<div class="form-group">
					<label for="age">Age :</label> <input type="number"
						value="${student.age}" class="form-control" id="age" name="age">
				</div>
			</form>
			<form id="singleUploadForm" name="singleUploadForm">
				<input id="singleFileUploadInput" type="file" name="file" required />
				<button type="submit">Submit</button>
			</form>
		</c:when>
	</c:choose>
	<script src="/js/main.js"></script>
</body>
</html>