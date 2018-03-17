<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Order List</title>
</head>
<body>
order List Name
<div>

	<c:forEach var="ordName" items="${usernameList}">
				<li>	<a href="/listUserNames/${username}.html"></a><c:out value="${ordName}" /></a></li>
				<br>
			</c:forEach>
</div>
<a href="add.html"> Add new order</a>
</body>
</html>