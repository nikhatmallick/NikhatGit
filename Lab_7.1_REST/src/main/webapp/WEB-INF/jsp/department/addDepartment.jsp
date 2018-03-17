<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add Department</title>
</head>
<body>
    Add New Department:
<br>
<sf:form method="POST" modelAttribute="department">
<table border="0">
	<tr> 
		<th><label for="department_name">Department Name:</label></th>
    	<td><sf:input path="departmentName" size="20" id="department_name" /><br/>
        	<sf:errors path="departmentName" cssClass="error" /> 
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