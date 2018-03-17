<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page of Order purchase</title>
</head>
<body>
<h2>User Order Successful. <br>Order Details are:</h2>
<c:out value="${order.order_id }"></c:out><br>
<c:out value="${order.username }"></c:out><br>
<c:out value="${order.order_created }"></c:out><br>
<c:out value="${order.order_amount }"></c:out><br>
<c:out value="${order.confirm_number }"></c:out><br>
</body>
</html>