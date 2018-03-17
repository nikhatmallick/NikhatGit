<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>View Product</title>
</head>
<body>
    Product Details:
<br>
<table border="0">
	<tr> 
		<th align="left">Product Id:</th>
    	<td align="left">${product.product_id}</td> 
	</tr> 
	<tr> 
		<th align="left">Product Name:</th>
    	<td align="left">${product.product_name}</td> 
	</tr> 
	<tr> 
		<th></th>
    	<td><a href="edit/${product.product_id}.html">Edit</a></td> 
	</tr> 
</table>
<br>
<a href="list.html">Back to Product List</a>
<br><br>

</body>
</html>