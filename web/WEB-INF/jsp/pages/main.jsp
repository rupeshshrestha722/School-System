
    <%@page import="java.util.*"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
     <sec:authorize access="hasRole('admin')">
     
    <h2>Welcome to Admin Paneel</h2>
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaaM5LNrxBvjLIlYWmdxA31-HCJXQ-q0mlecXJpEy6Zjw840-e8Q"> 
    <br/>
    Wybierz pożądaną opcję po lewej stronie aby zarządzać Twoją szkołą. 
    <br/><br/><br/>
    
    <%
    Date date = new Date();
    out.print("Dzisiaj jest: "+date.toString());
	%>
    <br/>
    
    </sec:authorize>
    <sec:authorize access="hasRole('teacher')">
    <h2>Witamy w panelu Nauczyciela !</h2>  
    
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaaM5LNrxBvjLIlYWmdxA31-HCJXQ-q0mlecXJpEy6Zjw840-e8Q"> 
    <br/>
        Select the desired option on the left to manage your students.
    <br/><br/><br/>
    
    <%
    Date date = new Date();
    out.print("Today is: "+date.toString());
	%>
    <br/>
    </sec:authorize>
    
    <sec:authorize access="hasRole('student')">
    <h2>Welcome to the Student panel !</h2>
    </sec:authorize>
