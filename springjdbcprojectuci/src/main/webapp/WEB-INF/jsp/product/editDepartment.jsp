<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Edit Department</title>
</head>
<body>
    Edit Department Details:
<br>
<sf:form method="POST" modelAttribute="department">
<table border="0">
	<tr> 
		<th align="left">Department Id:</th>
    	<td align="left">${department.departmentId}</td> 
	</tr> 
	<tr> 
		<th align="left"><label for="department_name">Department Name:</label></th>
    	<td align="left">
    	    <sf:input path="departmentName" id="department_name" /><br/>
        	<sf:errors path="departmentName" cssClass="error" /> 
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