<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="c"%>
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
	 <c:url value ="fileDownloadUri" var = "url"/>
	 <img alt="" src="${url}">
	
</body>
</html>