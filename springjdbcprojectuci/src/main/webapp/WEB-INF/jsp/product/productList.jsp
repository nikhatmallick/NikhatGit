<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Product List</title>
</head>
<body>
Product List
<div>
<c:forEach var="product" items="${productList}">
<li><c:out value="${product.product_name}" /></li>
</c:forEach>
</div>
<a href="add.html"> Add new product</a>
</body>
</html>