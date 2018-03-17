<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>View Department</title>
</head>
<body>
    Department Details:
<br>
<table border="0">
	<tr> 
		<th align="left">Department Id:</th>
    	<td align="left">${department.departmentId}</td> 
	</tr> 
	<tr> 
		<th align="left">Department Name:</th>
    	<td align="left">${department.departmentName}</td> 
	</tr> 
	<tr> 
		<th></th>
    	<td><a href="edit/${department.departmentId}.html">Edit</a></td> 
	</tr> 
</table>
<br>
<a href="list.html">Back to Department List</a>
<br><br>

</body>
</html>