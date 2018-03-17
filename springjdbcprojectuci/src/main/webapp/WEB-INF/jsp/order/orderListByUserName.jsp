<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Order List</title>
</head>
<body>
order List
<div>
<c:forEach var="order" items="${orderList}">
<li>
<c:out value="${order.order_id}" />
<c:out value="${order.order_created}" />
<c:out value="${order.order_amount}" />
<c:out value="${order.confirm_number }" />
</li>
</c:forEach>
</div>
<a href="add.html"> Add new order</a>
</body>
</html>