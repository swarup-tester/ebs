<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Category</title>
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
	<jsp:directive.include file="header.jsp" />
	<div class="container">
		<c:if test="${category != null }">
			<div class="row text-center">
				<div class="col">
					<br>
					<h4 class="pageheading">Edit Existing Category</h4>
				</div>
			</div>
		</c:if>

		<c:if test="${category == null }">
			<div class="row text-center">
				<div class="col">
					<br>
					<h4 class="pageheading">New Category</h4>
				</div>
			</div>
		</c:if>

		<c:if test="${category != null }">
			<form action="update_category" id="categoryForm" method="post"
				style="max-width: 400px; margin: 0 auto;">
				<input type="hidden" name="categoryId" value="${category.categoryId}">
				
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Category Name</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="Enter name" onkeypress="javascript:hideDiv()"
							value="${category.name}">
					</div>
				</div>
				<div class="row">
					<div class="col text-center">
						<button type="submit" class="btn btn-primary" id="submitBtn"> Update </button>
						<button type="submit" class="btn btn-danger" id="buttonCancel">Cancel</button>
					</div>
				</div>
			</form>
		</c:if>

		<c:if test="${category == null }">
			<form action="create_category" id="categoryForm" method="post"
				style="max-width: 400px; margin: 0 auto;">
				<div class="form-group row">
					<label class="col-sm-4 col-form-label">Category Name</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="Enter name" onkeypress="javascript:hideDiv()"
							value="${category.name}">
					</div>
				</div>
				<div class="row">
					<div class="col text-center">
						<button type="submit" class="btn btn-primary" id="submitBtn">New Submit</button>
						<button type="submit" class="btn btn-danger" id="buttonCancel">Cancel</button>
					</div>
				</div>
			</form>
		</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>