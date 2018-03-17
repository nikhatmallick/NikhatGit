<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Order List</title>
</head>
<body>
order List Name
<div>

	<c:forEach var="ordName" items="${usernameList}">
				<li>	<a href="/listUserNames/${ordName}.html"><c:out value="${ordName}" /></a></li>
				<br>
			</c:forEach>
</div>
<a href="add.html"> Add new order</a>
</body>
</html>

<!-- <a href="view.html?product_id=${prod.product_id}">
					<c:out value="${prod.product_name}" />
				</a> -->