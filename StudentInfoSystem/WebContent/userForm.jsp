<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<fieldset>
			<legend align="top">User Registration Form</legend>
			<form class="container" action="UserController" method="post" enctype="multipart/form-data">
			<span><input type="hidden" name="id" value="${user.id}"></span>
				<div class="form-group">
					<label for="exampleInputEmail1">FirstName</label> <input
						type="text" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="firstname"
						value="${user.firstName}">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">LastName</label> <input type="text"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="lastname"
						value="${user.lastName}">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">UserName</label> <input type="text"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="username"
						value="${user.userName}">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						name="pass" value="${user.password}">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" value="${user.email}" name="email">
				</div>

				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">Gender</label>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="gender"
							id="inlineRadio1" value="male"
							${user.gender=='male'?'checked':''}> Male
						</label>
					</div>
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="gender"
							id="inlineRadio2" value="female"
							${user.gender=='female'?'checked':''}> Female
						</label>
					</div>
				</div>
				<div class="form-group row">
					<label for="exampleFormControlInput1"
						class="col-sm-2 col-form-label">DOB</label>
					<div class="col-sm-6">
						<input type="date" class="form-control"
							id="exampleFormControlInput1" value="${user.dob}" name="dob">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="exampleFormControlFile1">Upload Image</label> <input
						type="file" class="form-control-file" id="exampleFormControlFile1" name="photo">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</fieldset>
	</div>
</body>
</html>