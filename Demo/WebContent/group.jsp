<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Group</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
</head>
<body>
<div class='w-100 float-right pr-2'>
	<h1 class='text-center btn btn-outline-success w-100 display-1'>Add Group</h1>
<s:form action="addgroup" method="post" namespace="/">
	<s:textfield type="text" name="groupname" cssClass="form-group 
	form-control" label="Group Name" placeholder="Enter Group Name"/>
	<s:textfield type="text" name="groupdesc" cssClass="form-group 
	form-control" label="Group Description" placeholder="Enter Group Description"/>
	<s:checkboxlist list="studentlist" name="selectedstudent" label="Students" />
	<s:submit value="Add Group" name="submit"/>
</s:form> 


<s:form name="showgroup" action="showgroup">
                <s:submit value="Fetch Records"/>
</s:form>

<table>
	<thead>
		<tr>
			<th>Group Name</th>
			<th>Group Description</th>
			<th>Students</th>
		</tr>
	</thead>
	<s:iterator value="grouplist">
	<tr>
			<td><s:property value="groupname"/></td>
			<td><s:property value="groupdesc"/></td>
			<td><s:property value="showstudent"/></td>
	<tr>
	</s:iterator>
</table>
</div>
</body>
</html>