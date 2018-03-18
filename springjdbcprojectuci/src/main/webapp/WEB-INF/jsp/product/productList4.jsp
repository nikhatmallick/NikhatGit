<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Product List</title>
</head>
<body>
	Products:
	<sf:form method="POST" commandName="selectedProducts" >
		<div>
			<c:forEach var="prod" items="${productList}">
				<sf:checkbox path="itemList" value="${prod.product_id}" />
				  <a href="addOrder.html?product_id=${prod.product_id}">
					<c:out value="${prod.product_name}" />
				 </a>  
				<br>
			</c:forEach>
		</div>
 		<input type="submit" value="Purchase" />
	</sf:form>
	<br>
	<a href="add.html">Add New</a>
</body>
</html>