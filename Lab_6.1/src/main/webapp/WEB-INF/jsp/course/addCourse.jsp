<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add Course</title>
</head>
<body>
    Add New Course:
<br>
<sf:form method="POST" modelAttribute="course">
<table border="0">
	<tr> 
		<th><label for="course_code">Course Code:</label></th>
    	<td><sf:input path="courseCode" size="15" id="course_code" /><br/>
        	<sf:errors path="courseCode" cssClass="error" /> 
    	</td> 
	</tr> 
	<tr> 
		<th><label for="course_name">Course Name:</label></th>
    	<td><sf:input path="courseName" size="20" id="course_name" /><br/>
        	<sf:errors path="courseName" cssClass="error" /> 
    	</td> 
	</tr> 
	<tr> 
		<th><label for="department_name">Department Name:</label></th>
    	<td>
    		<sf:select path="department.departmentId" >
    		   <sf:options items="${departmentList}" itemLabel="departmentName" itemValue="departmentId" />
    		</sf:select>
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

