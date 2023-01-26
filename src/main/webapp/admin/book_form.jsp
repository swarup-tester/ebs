<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Book</title>
<link rel="shortcut icon" type="image/png" href="../images/favicon.png">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/jquery-ui.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
<body>
	<div class="container">
		<c:if test="${book != null }">
			<div class="row text-center">
				<div class="col">
					<br>
					<h4 class="pageheading">Edit Existing Book</h4>
				</div>
			</div>
		</c:if>

		<c:if test="${book == null }">
			<div class="row text-center">
				<div class="col">
					<br>
					<h4 class="pageheading">New Book</h4>
				</div>
			</div>
		</c:if>

		<form action="create_book" id="bookForm" method="post"
			style="max-width: 400px; margin: 0 auto;" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Category</label>
				<div class="col-sm-8">
					<select name="category" id="category" class="form-control" required>
						<option value="">Choose</option>
						<c:forEach items="${listCategory}" var="category">
							<option value="${category.categoryId}">${category.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Book Title</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="title" name="title"
						placeholder="Enter title" onkeypress="javascript:hideDiv()"
						value="${book.title}" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Author</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="author" name="author"
						placeholder="Enter author" onkeypress="javascript:hideDiv()" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Description</label>
				<div class="col-sm-8">
					<textarea class="form-control" id="description" rows="3"
						name="description" placeholder="Enter description" required></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">ISBN</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="isbn" name="isbn"
						placeholder="Enter isbn" onkeypress="javascript:hideDiv()" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Image</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="image" name="image"
						size="20" required>
						<img src="" id="thumbnail" alt="Image preview" style="width:50%; margin-top: 10px;">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Publish Date</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="publishDate"
						name="publishDate" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Price</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="price" name="price"
						placeholder="Enter price" onkeypress="javascript:hideDiv()" required>
				</div>
			</div>
			<div class="row">
				<div class="col text-center">
					<button type="submit" class="btn btn-primary" id="submitBtn">New
						Submit</button>
					<button type="submit" class="btn btn-danger" id="buttonCancel">Cancel</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" /></body>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#publishDate").datepicker();
		
		$("#image").change(function(){
			showImageThumbnail(this);
		}) ;	
		
		$("#bookForm").validate({
			rules : {
				category : "required",
				title : "required",
				author : "required",
				isbn : "required",
				image : "required",
				description : "required",
				price : "required"
			},
			messages : {
				category : "Please select category",
				title : "Please enter title",
				author : "Please enter author",
				isbn : "Please enter isbn",
				image : "Please select an image",
				description : "Please enter description",
				price : "Please enter price"			
			},
			submitHandler : function() {
				document.getElementById('loading').style.display = "block";
				button.disabled = true;
				form.submit();
			}
		});
	});
	
	function showImageThumbnail(fileInput) {
		var file = fileInput.files[0];
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#thumbnail").attr('src', e.target.result);
		};
		reader.readAsDataURL(file);
	}
	
</script>
</html>








