<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Product List</title>
</head>
<body>
	Products:
	<sf:form method="POST" commandName="selectedProducts" action="list.html">
		<sf:checkboxes path="itemList" items="${productList}" 
    		itemValue="product_id" itemLabel="Product_name" />
 		<input type="submit" value="Delete" />
	</sf:form>
	<br>
	<a href="add.html">Add New</a>
</body>
</html>