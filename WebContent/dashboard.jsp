<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<h1>Dashboard</h1>
<h2>Welcome <s:property value="userid"/></h2>
<s:form name="showsemesterbranch" action="showsemesterbranch">
 <s:submit value="Fetch Records"/>
</s:form>

<a href="showsemesterbranch.action">subject</a>
<a href="showright.action">role</a>
<a href="showbranchsemester.action">register student</a>
<a href="showbranchsemestersubject.action">register teacher</a>
<a href="showgroupstudent.action">group</a>
<a href="pretestcache.action">add test</a>
<a href="semester.jsp">semester</a>
<a href="branch.jsp">branch</a>
</body>
</html>