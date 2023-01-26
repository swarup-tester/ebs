<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Evergreen</title>
<link rel="shortcut icon" type="image/png" href="../images/favicon.png">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/additional-methods.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row text-center">
			<div class="col">
				<h1>Evergreen Bookstore</h1>
				<h4>Admin Login</h4>
			</div>
		</div>
		<div class="row text-center">
			<div class="col">
				<c:if test="${message != null}">
					<div align="center">
						<h4 class="message">${message}</h4>
					</div>
				</c:if>
			</div>
		</div>

		<div class="text-center" id="loading" style="display: none;">
			<div class="spinner-border text-danger" role="status">
				<span class="sr-only"></span>
			</div>
		</div>

		<form action="login" id="formLogin" method="post"
			style="max-width: 400px; margin: 0 auto;">
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Email address</label>
				<div class="col-sm-8">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="Enter email" onkeypress="javascript:hideDiv()">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Password</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Enter password"
						onkeypress="javascript:hideDiv()">
					<div id="loadMsg" style="display: block;">
						<small id="emailHelp" class="form-text text-muted">2 Upper
							case, 2 Lower case</small>
					</div>

				</div>
			</div>
			<div class="row">
				<div class="col text-center">
					<button type="submit" class="btn btn-primary" id="submitBtn">Sign
						In</button>
				</div>
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$('#email').focus();
		const button = document.querySelector('button')

		$.validator.addMethod("regex", function(value, element, regexp) {
			var check = false;
			return this.optional(element) || regexp.test(value);
		}, "Minimum four characters...");

		$("#formLogin").validate({
			rules : {
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					regex : /^[a-z]{5}$/,
					minlength : 4
				}
			},
			messages : {
				email : {
					required : "Email required",
					email : "Not valid Email pattern"
				},
				password : {
					required : "Password required",
					minlength : "Minimum length is 4",
					regx : "RE"
				}
			},
			submitHandler : function() {
				document.getElementById('loading').style.display = "block";
				button.disabled = true;
				form.submit();
			}
		});
	});

	function showDiv() {
		document.getElementById('loading').style.display = "block";
	}

	function hideDiv() {
		document.getElementById('loading').style.display = "none";
		document.getElementById('loadMsg').style.display = "none";
	}
</script>
</html>





