<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Semester</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<script>
window.addEventListener("load", init);
function init() {
	let message = document.getElementById('alert');
	console.log("Message is ",message.innerText);
	if (message.innerText == "Added") {
		message.innerText = " ";
		alert("Semester Added....");
	}
}
</script>
</head>
<body>
<div class='w-100 float-right pr-2'>
    <h6 id="alert" class="text-center"><s:property value="message"/></h6>
	<h1 class='text-center btn btn-outline-success w-100 display-1'>Add Semester</h1>
<s:form action="addsem" method="post">
	<s:textfield type="text" name="semestername" 
	cssClass="form-group form-control" label="Semester Name" 
	placeholder="Enter Semester Name"/>
	<s:textfield type="text" name="semesterdesc" 
	cssClass="form-group form-control" label="Semester Description" 
	placeholder="Enter Semester Description"/>
	<s:submit cssClass="form-group btn btn-primary mx-5"/>
</s:form>

<s:form name="showsemester" action="showsemester">
                <s:submit value="Fetch Records"/>
</s:form>

<table class="table table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>Semester Name</th>
			<th>Semester Description</th>
		</tr>
	</thead>
	<s:iterator value="semesterlist">
	<tr>
			<td><s:property value="semestername"/></td>
			<td><s:property value="semesterdesc"/></td>
	<tr>
	</s:iterator>
</table>
</div>
</body>
</html>