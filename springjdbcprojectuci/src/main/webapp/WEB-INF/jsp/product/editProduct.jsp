<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Edit Product</title>
</head>
<body>
    Edit Product Details:
<br>
<sf:form method="POST" modelAttribute="product">
<table border="0">
	<tr> 
		<th align="left">Product Id:</th>
    	<td align="left">${product.product_id}</td> 
	</tr> 
	<tr> 
		<th align="left"><label for="product_name">Product Name:</label></th>
    	<td align="left">
    	    <sf:input path="Product_name" id="product_name" /><br/>
        	<sf:errors path="Product_name" cssClass="error" /> 
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
		<th align="left"><label for="sku">sku:</label></th>
    	<td align="left">
    	    <sf:input path="sku" id="sku" /><br/>
        	<sf:errors path="sku" cssClass="error" /> 
    	</td> 
	</tr>
	<tr> 
		<th align="left"><label for="uom">Unit of Measure:</label></th>
    	<td align="left">
    	    <sf:input path="uom" id="uom" /><br/>
        	<sf:errors path="uom" cssClass="error" /> 
    	</td> 
	</tr>
	<tr> 
		<th align="left"><label for="available_quantity">available_quantity:</label></th>
    	<td align="left">
    	    <sf:input path="available_quantity" id="available_quantity" /><br/>
        	<sf:errors path="available_quantity" cssClass="error" /> 
    	</td> 
	</tr>
	<tr>
		<th></th>
		<td><input type="submit" value="Save" /></td>
	</tr>
</table>
</sf:form>

<br>
<a href="../list.html">Cancel</a>
<br><br>

</body>
</html>