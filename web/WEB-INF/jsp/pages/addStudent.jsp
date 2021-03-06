<%@ page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div>
	${message}
	<h2>Student Information</h2>
<spring:url value="/addStudent" var="addStudent" htmlEscape="true"/>
	<sf:form method="POST" modelAttribute="student" action="${addStudent}">
		<fieldse>
		<table cellspacing="0">
			<tr>
				<th><label for="username">UserName</label></th>
				<td><sf:input path="username" id="username" /></td>
				<td><sf:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="password">Password</label></th>
				<td><sf:input path="password" id="password" /></td>
				<td><sf:errors path="password" cssClass="error" /></td>
			</tr>
						<tr>
				<th><label for="name">FirstName</label></th>
				<td><sf:input path="firstName" id="name" /></td>
				<td><sf:errors path="firstName" cssClass="error" /></td>
			</tr>
						<tr>
				<th><label for="name">LastName</label></th>
				<td><sf:input path="lastName" id="surname" /></td>
				<td><sf:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="email">E-mail</label></th>
				<td><sf:input path="email" id="email" /></td>
				<td><sf:errors path="email" cssClass="error" /></td>
			</tr>
						 <tr>
				<th><label for="studentClass">Grade</label></th>
				<td>
				<sf:select path="studentClass" id="studentClass">
					  <sf:option value="-1" label="--- Select ---" />
					  <c:forEach var="stClass" items="${allClasses}">
                    <option value="${stClass.id}">${stClass.fullName}</option>
                </c:forEach>
				       </sf:select>
                                </td>
                                <td><sf:errors path="studentClass" cssClass="error" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input name="commit" type="submit" value="Add" /></td>
			</tr>
		</table>
		</fieldse>
	</sf:form>
	
	<h4>${message}</h4>
</div>