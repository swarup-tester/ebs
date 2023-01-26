<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<div>
			<c:if test="${user != null }">
				<h2 class="pageheading">Edit Existing User</h2>
			</c:if>
			<c:if test="${user == null }">
				<h2 class="pageheading">Create New User</h2>
			</c:if>
		</div>

		<c:if test="${user != null }">
			<form action="update_user" id="userForm" method="post">
				<input type="hidden" name="userId" value="${user.userId}">
				<table class="form">
					<tr>
						<td align="right">Email:</td>
						<td align="left"><input type="email" size="20"
							placeholder="Enter email" id="email" name="email"
							value="${user.email}"></td>
					</tr>
					<tr>
						<td align="right">Full name:</td>
						<td align="left"><input type="text" size="20"
							placeholder="Enter full name" id="fullname" name="fullname"
							value="${user.fullname}"></td>
					</tr>
					<tr>
						<td align="right">Password:</td>
						<td align="left"><input type="password" size="20"
							placeholder="Enter Password" id="password" name="password"
							value="${user.pwd}"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit">Update</button>&nbsp;
							<button>Cancel</button>
						</td>

					</tr>
				</table>
			</form>
		</c:if>

		<c:if test="${user == null }">
			<form action="create_user"  id="userForm" method="post">
				<table class="form">
					<tr>
						<td align="right">Email:</td>
						<td align="left"><input type="email" size="20"
							placeholder="Enter email" id="email" name="email"
							value="${user.email}"></td>
					</tr>
					<tr>
						<td align="right">Full name:</td>
						<td align="left"><input type="text" size="20"
							placeholder="Enter full name" id="fullname" name="fullname"
							value="${user.fullname}"></td>
					</tr>
					<tr>
						<td align="right">Password:</td>
						<td align="left"><input type="password" size="20"
							placeholder="Enter Password" id="password" name="password"
							value="${user.pwd}"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit">Save</button>&nbsp;
							<button id="buttonCancel">Cancel</button>
						</td>

					</tr>
				</table>
			</form>
		</c:if>

	</div>
	<jsp:directive.include file="footer.jsp" /></body>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#userForm" ).validate({
			rules: {
				email: {
					required: true,
					email: true
				},
				fullname: "required",
				password: "required"
			},
			messages: {
				email: {
					required: "Email required",
					email: "Not valid Email pattern"
				},
				fullname: "Full name required",
				password: "Password required"
			}
		});
		
		$("#buttonCancel").click(function(){
			history.go(-1);
		});
	});
</script>
</html>