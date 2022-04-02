<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Submitted Student Information</h2>
	<table>
		<tr>
			<td>First name</td>
			<td>${student.firstName}</td>
		</tr>
		<tr>
			<td>Last name</td>
			<td>${student.lastName}</td>
		</tr>
		<tr>
			<td>Age</td>
			<td>${student.age}</td>
		</tr>
	</table>
	<form method="POST" action="/uploadFile">
		<img alt="" src="${multipartUR.fileDownloadUri}">
	</form>
	
</body>
</html>