<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<img src="./images/logo.png" width="500px"><br>
	</div>
	<br>
	<div id="headermenu">
		<input type="text" name="keyword" size="50" />&nbsp; <br> <input
			type="button" value="Search"
			style="margin-top: 10px; margin-bottom: 10px;" /><br> <a
			href="login">Sign In</a> | <a href="register">Register</a> | <a
			href="cart">Check Cart</a>
	</div>
	<br>
	<div>
		<c:forEach var="category" items="${listCategory}" varStatus="status">
			<a href="view_category?id=${category.categoryId}"><font size="+2"> <b><c:out value="${category.name}" /></b></font> 
			</a>
			<c:if test="${not status.last}">&nbsp; | &nbsp;</c:if>
		</c:forEach>
	</div>
</div>