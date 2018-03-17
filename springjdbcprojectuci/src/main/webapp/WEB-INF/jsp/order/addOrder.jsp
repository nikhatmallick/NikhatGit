<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Add Order</title>
</head>
<body>
Add New Order:
<br>
<sf:form method="POST" modelAttribute="orders">
<table border="0">
<tr>
<th><label for=order_created>Order Created Date:</label></th>
<td><sf:input path="order_created" size="30" id="order_created"/><br>
<sf:errors path="order_created" cssClass="error" />
</td>
</tr>
<tr>
<th><label for="order_amount"> Order Amount :</label></th>
<td><sf:input path="order_amount" size="30" id="order_amount"/><br>
<sf:errors path="order_amount" cssClass="error" />
</td>
</tr>
<tr>
<th><label for="confirm_number"> Confirm Number:</label></th>
<td><sf:input path="confirm_number" size="30" id="confirm_number"/><br>
<sf:errors path="confirm_number" cssClass="error" />
</td>
</tr>
<tr>
<th><label for="username"> User Name:</label></th>
<td><sf:input path="username" size="40" id="username"/><br>
<sf:errors path="username" cssClass="error" />
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