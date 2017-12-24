<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
<%@ include file="header.jsp"%>
</head>
<body>
<a href="StudentController?actions=student_new">New Student</a>
<c:if test="${! empty students}">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Student Id</th>
				<th scope="col">Student Name</th>
				<th scope="col">College Name</th>
				<th scope="col">Email</th>
				<th scope="col">Roll</th>
				<th scope="col">Gender</th>
				<th scope="col">Subject</th>
				<th scope="col">Departments</th>
				<th scope="col">DOB</th>
				<th scope="col">Image</th>
				<th scope="col">Actions</th>
				
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${students}" var="student">
			<tr>
				<th scope="row">1</th>
				<td><c:out value="${student.id}"/></td>
				<td><c:out value="${student.studentName }"/></td>
				<td><c:out value="${student.collegeName }"/></td>
				<td><c:out value="${student.email}"/></td>
				<td><c:out value="${student.roll}"/></td>
				<td><c:out value="${student.gender}"/></td>
				<td><c:out value="${student.subject}"/></td>
				<td><c:out value="${student.department}"/></td>
				<td><c:out value="${student.dob}"/></td>
				<td><img src="ImageDisplayController?studentId=${student.id}" alt="profile picture" width="50px" height="50px"></td>
				<td>
				
				<a href="StudentController?actions=student_delete&studentId=${student.id}">Delete</a>|
				<a href="StudentController?actions=student_edit&studentId=${student.id}">Edit</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:if>
	
</body>
</html>