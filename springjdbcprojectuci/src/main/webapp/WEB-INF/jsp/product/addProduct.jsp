<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Add Product</title>
</head>
<body>
Add New Product:
<br>
<sf:form method="POST" modelAttribute="product">
<table border="0">
<tr>
<th><label for="sku">Catalog SKU:</label></th>
<td><sf:input path="sku" size="30" id="sku"/><br>
<sf:errors path="sku" cssClass="error" />
</td>
</tr>
<tr>
<th><label for="product_name"> Product Name:</label></th>
<td><sf:input path="product_name" size="30" id="product_name"/><br>
<sf:errors path="product_name" cssClass="error" />
</td>
</tr>
<tr>
<th><label for="available_quantity"> Product available quantity:</label></th>
<td><sf:input path="available_quantity" size="30" id="available_quantity"/><br>
<sf:errors path="available_quantity" cssClass="error" />
</td>
</tr>
<tr>
<th><label for="uom"> Unit of Measure:</label></th>
<td><sf:input path="uom" size="20" id="uom"/><br>
<sf:errors path="uom" cssClass="error" />
</td>
</tr>
<tr> 
		<th><label for="catalog_name">Catalog Name:</label></th>
    	<td>
    		<sf:select path="catalog.catalog_id" >
    		   <sf:options items="${catalogList}" itemLabel="catalog_name" itemValue="catalog_id" />
    		</sf:select>
    	</td> 
	</tr> 
  
<tr>
<th></th>
<td><input type="submit" value="Save" /></td>
</tr>
</table>
</sf:form>
</body>
</html>