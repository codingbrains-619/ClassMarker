<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
     <%@taglib prefix="cm" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>

<cm:header rolename='<s:property value="rolename"/>' userid='<s:property value="userid" />' rights='<s:property value="rights"/>' ></cm:header>


        <h1 class="h2">Main Dashboard</h1>
        
              
<%-- <cm:dashboard></cm:dashboard> --%>
<%-- <h1>Dashboard</h1>
<h2>Welcome <s:property value="rolename"/> <s:property value="userid"/></h2>
<s:iterator value="rights">
			
			<a href='<s:property value="screenname"/>'><s:property value="rightname"/></a><br>
</s:iterator>
<s:form name="showsemesterbranch" action="showsemesterbranch">
 <s:submit value="Fetch Records"/>
</s:form>

<a href="showbranchsemester.action">register student</a>
<a href="showbranchsemestersubject.action">register teacher</a>
<a href="showgroupstudent.action">group</a>
<a href="pretestcache.action">add test</a> --%>
<cm:footer></cm:footer>

</body>
</html>