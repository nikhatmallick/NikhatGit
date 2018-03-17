<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Department List</title>
</head>
<body>
	Departments:
	<sf:form method="POST" commandName="selectedDepartments" action="list.html">
		<div>
			<c:forEach var="dept" items="${departmentList}">
				<sf:checkbox path="itemList" value="${dept.departmentId}" />
				<a href="view.html?deptId=${dept.departmentId}">
					<c:out value="${dept.departmentName}" />
				</a>
				<br>
			</c:forEach>
		</div>
 		<input type="submit" value="Delete" />
	</sf:form>
	<br>
	<a href="add.html">Add New</a>
</body>
</html>