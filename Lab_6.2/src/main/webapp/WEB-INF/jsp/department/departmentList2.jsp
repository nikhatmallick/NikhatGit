<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Department List</title>
</head>
<body>
	Departments:
	<sf:form method="POST" commandName="selectedDepartments" action="list.html">
		<sf:checkboxes path="itemList" items="${departmentList}" 
    		itemValue="departmentId" itemLabel="departmentName" />
 		<input type="submit" value="Delete" />
	</sf:form>
	<br>
	<a href="add.html">Add New</a>
</body>
</html>