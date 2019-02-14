<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
	<div>
	<b>List of all items for the class:</b> ${sClass.fullName}<br>
	<b>yearbook:</b> ${sClass.year}
	<br/><br/><br/>
	<table id="table-2">
	<tr>
	<th>Subject</th>
	<th></th>
	
	
	</tr>
	<c:forEach var="subject" items="${subjects}">
	<tr>
	<td>${subject.name}</td>
	<td>
	<spring:url value="/listStudents?class_id=${subject.subClass.id}&subject_id=${subject.id}" var="studentsOfClass"></spring:url>
	<a href ="${studentsOfClass}">Oceń</a>
	
	
	</td>
	
	</tr>
	
	</c:forEach>
	
	</table>
	
	
	
	
	

	
	
	
	
	
	</div>