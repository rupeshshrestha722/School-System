<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="leftPane">
	<dl id="menu0" class="leftMenu">
		<dt>
			<spring:url value="/" var="homeUrl" htmlEscape="true" />
			<a href="${homeUrl}">Home</a>
		</dt>

			<sec:authorize access="hasRole('admin')">
		<dt>Class Management</dt>
		<dd>
				<spring:url value="/classes" var="classes" htmlEscape="true" />
				<a href="${classes}">Class</a>
			</sec:authorize>
		</dd>
		<dd>
			<sec:authorize access="hasRole('admin')">
				<spring:url value="/addClass" var="addClass" htmlEscape="true" />
				<a href="${addClass}">Add Class</a>
			</sec:authorize>
		</dd>

		<sec:authorize access="hasRole('admin')">
			<dt>Teacher Management</dt>
						<dd>
				<spring:url value="/teachers" var="teachers" htmlEscape="true" />
				<a href="${teachers}">Teachers</a>
			</dd>
			<dd>
				<spring:url value="/addTeacher" var="addTeacher" htmlEscape="true" />
				<a href="${addTeacher}">Add Teacher</a>
			</dd>
				</sec:authorize>
			
			<sec:authorize access="hasRole('admin')">
		<dt>
			Student management</dt>
		<dd>
				<spring:url value="/students" var="students" htmlEscape="true" />
				<a href="${students}">Student</a>
			</sec:authorize>
		</dd>
		
		<dd>
			<sec:authorize access="hasRole('admin')">
				<spring:url value="/addStudent" var="addStudent" htmlEscape="true" />
				<a href="${addStudent}">Add Student</a>
			</sec:authorize>
		</dd>
		<sec:authorize access="hasRole('admin')">
		<dt>Subject Management</dt>
		<dd>
				<spring:url value="/addSubject" var="addSubject" htmlEscape="true" />
				<a href="${addSubject}">Add Subject</a>
		</dd>
		<dd>
				<spring:url value="/subjects" var="subjects" htmlEscape="true" />
				<a href="${subjects}">Subject</a>
			
		</dd>
			</sec:authorize>
		
		<sec:authorize access="hasAnyRole('admin','teacher')">
		<dt>Gradebook</dt>
		<dd>
				<spring:url value="/listClasses" var="listClasses" htmlEscape="true" />
				<a href="${listClasses}">List Class</a>
		</dd>
			</sec:authorize>
		
		
		
		<a href="/logout" />">Logout</a>
	
	
	
	
			
		
	</dl>
	<script type="text/javascript">
		// <![CDATA[
		new Menu('menu0');
		// ]]>
	</script>
</div>
