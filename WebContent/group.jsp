<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList,com.classmarker.teacher.actions.Group" %>
    <%@taglib prefix="s" uri="/struts-tags" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<%-- <style>
.hide{
display:none;
}
</style>
<script>
function showBranch(){
	document.getElementById("branchshow").classList.toggle('hide');
}
</script> --%>
</head>
<body>
<div class='w-100 float-right pr-2'>
	<h1 class='text-center btn btn-outline-success w-100 display-1'>Add Group</h1>
<s:form action="addgroup" method="post" namespace="/">
	<s:textfield type="text" name="groupname" cssClass="form-group form-control" label="Group Name" placeholder="Enter Group Name"/>
	<s:textfield type="text" name="groupdesc" cssClass="form-group form-control" label="Group Description" placeholder="Enter Group Description"/>
	<s:checkboxlist list="studentlist" name="selectedstudent" label="Students" />
	<s:submit value="SUbmit" name="submit"/>
	<%-- cssClass="form-group btn btn-primary mx-5" --%>
</s:form> 


<s:form name="showgroup" action="showgroup">
                <%-- <s:textfield name="username" /> --%>
                <s:submit value="Fetch Records"/>
</s:form>
<table class="table table-bordered">
	<thead class="thead-dark">
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