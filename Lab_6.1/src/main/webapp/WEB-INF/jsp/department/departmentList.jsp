<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Department List</title>
</head>
<body>
    Department List
<br>
<div> 
    <c:forEach var="department" items="${departmentList}"> 
        <li><c:out value="${department.departmentName}" /></li> 
    </c:forEach> 
</div>    
<a href="add.html">Add New Department</a>
</body>
</html>