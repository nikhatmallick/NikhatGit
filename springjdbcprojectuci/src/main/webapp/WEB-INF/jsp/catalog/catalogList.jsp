<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog List</title>
</head>
<body>
<H1>Catalog List</H1>
<br>

<div>
	<c:forEach var="catalog" items="${catalogList}">
	<li>	<c:out value="${catalog.catalog_name }"></c:out></li>
	</c:forEach>
</div>
<a href="add.html">Add New Catalog</a>
</body>
</html>