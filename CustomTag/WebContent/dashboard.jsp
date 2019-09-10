<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="brain" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<%-- <h1>Dashboard</h1>
<h2>Welcome <s:property value="userid"/></h2> --%>
<brain:dashboard></brain:dashboard>
<%--   <s:form name="showsemesterbranch" action="showsemesterbranch">
 <s:submit value="Fetch Records"/>
</s:form>
<a href="showsemesterbranch.action">Subject</a> <br>
<a href="showright.action">Role</a> <br>
<a href="showbranchsemester.action">Register Student</a> <br>
<a href="showbranchsemestersubject.action">Register Teacher</a> <br>
<a href="showgroupstudent.action">group</a>
<a href="pretestcache.action">add test</a>
<a href="semester.jsp">Semester</a> <br>
<a href="branch.jsp">Branch</a> --%>
</body>
</html>