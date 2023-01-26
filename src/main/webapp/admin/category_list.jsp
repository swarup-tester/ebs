<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
<link rel="shortcut icon" type="image/png" href="../images/favicon.png">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<h4 class="pageheading">Category Management</h4>
				<h6>
					<a href="category_form.jsp">Create New Category</a>
				</h6>
			</div>
		</div>
		<div class="row">
			<div class="col text-center">
				<c:if test="${message != null}">
					<h6 class="message">${message}</h6>
				</c:if>
			</div>
		</div>
		<div align="center">
			<table class="table table-bordered table-striped table-hover"
				style="max-width: 500px;">
				<thead class="thead-dark">
					<tr>
						<th>Index</th>
						<th>ID</th>
						<th>Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="category" items="${listCategory}"
						varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>${category.categoryId }</td>
							<td>${category.name }</td>
							<td><a href="edit_category?id=${category.categoryId }">Edit</a>&nbsp;
								<a href="javascript:void(0);" class="deleteLink"
								id="${category.categoryId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<jsp:directive.include file="footer.jsp" /></body>
	<script>
	$(document)
			.ready(
					function() {
						$(".deleteLink")
								.each(
										function() {
											$(this)
													.on(
															"click",
															function() {
																categoryId = $(this)
																		.attr(
																				"id");
																if (confirm("Are you sure you want to delete ID:"
																		+ categoryId
																		+ " ?")) {
																	window.location = "delete_category?id="
																			+ categoryId;
																}
															});
										});
					});
</script>
</body>
</html>