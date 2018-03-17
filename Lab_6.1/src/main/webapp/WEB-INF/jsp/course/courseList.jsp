<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Course List</title>
</head>
<body>
    Course List
<br>
<div> 
    <c:forEach var="course" items="${courseList}"> 
        <li><c:out value="${course.courseName}" /></li> 
    </c:forEach> 
</div>    
<a href="add.html">Add New Course</a>
    
</body>
</html>