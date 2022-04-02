<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Student Information</h2>
	<c:choose>
		<c:when test="${mode == 'STUDENT_VIEW'}">
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
			<div>
				<div id="singleFileUploadError"></div>
				<div id="singleFileUploadSuccess"></div>
			</div>
		</c:when>
		<c:when test="${mode == 'STUDENT_CREATE'}">
			<form:form modelAttribute="studentFromServer" method="POST"
				action="/addStudent ">
				<table>
					<tr>
						<form:input path="id" type="hidden" />
						<td><form:label path="firstName">First name</form:label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><form:label path="age">Age</form:label></td>
						<td><form:input path="age" /></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last name</form:label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value=" Registration" /></td>
					</tr>
				</table>
			</form:form>
			<div>
				<form id="singleUploadForm" name="singleUploadForm">
					<input id="singleFileUploadInput" type="file" name="file" required /><br>
					<button type="submit">Add foto</button>
				</form>
			</div>
		</c:when>
	</c:choose>
	<script src="/js/main.js"></script>
</body>
</html>