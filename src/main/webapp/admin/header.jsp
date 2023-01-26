<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<img src="../images/logo.png" width="500px"><br>
		Welcome, <b><c:out value="${sessionScope.useremail}"/></b> | <a href="logout">Logout</a>
	</div>
	<br>
	<div id="headermenu">
		<div>
			<a href="list_user"> <img src="../images/user.png" width="30px"
				height="30px"><br>Users
			</a> |
		</div>
		<div>
			<a href="list_category"> <img src="../images/category.png"
				width="30px" height="30px"><br>Categories
			</a> |
		</div>
		<div>
			<a href="list_book"> <img src="../images/book.png" width="30px"
				height="30px"><br> Books
			</a> |
		</div>
		<div>
			<a href="#"> <img src="../images/customer.png" width="30px"
				height="30px"><br>Customer
			</a>
		</div>
	</div>
</div>