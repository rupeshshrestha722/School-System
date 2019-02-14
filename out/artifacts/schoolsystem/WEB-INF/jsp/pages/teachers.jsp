<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
<h4>${message}</h4>
	<table align="center" width="500">
		<thead>
			<tr>
				<td>Id</td>
				<td>FirstName</td>
				<td>LastName</td>
				<td>User Name</td>
				<td>Password</td>
				<td>Delete</td>
				<td>Edit</td>
				<td>More</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="teacher" items="${teachers}">
				<tr>
					<td>${teacher.id}</td>
					<td>${teacher.firstName}</td>
					<td>${teacher.lastName}</td>
					<td>${teacher.username}</td>
					<td>${teacher.schoolClass.name}</td>
					<td>
					<spring:url value="/deleteTeacher?id=${teacher.id}" var="deleteTeacher" htmlEscape="true"/>
					<a href="${deleteTeacher}">Delete</a>
					</td>
					<td>
					<spring:url value="/editTeacher?id=${teacher.id}" var="editTeacher" htmlEscape="true"/>
					<a href="${editTeacher}">Edit</a>
					</td>
					
					</td>
					<td>
					<spring:url value="/teacher?id=${teacher.id}" var="teacher" htmlEscape="true"/>
					<a href="${teacher}">More</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>