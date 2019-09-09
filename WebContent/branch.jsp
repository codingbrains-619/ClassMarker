<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branch</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<script>
window.addEventListener("load", init);
function init() {
	let message = document.getElementById('alert');
	console.log("Message is ",message.innerText);
	if (message.innerText == "Added") {
		message.innerText = " ";
		alert("Branch Added....");
	}
}
</script>
</head>
<body>
<div class='w-100 float-right pr-2'>
    <h6 id="alert" class="text-center"><s:property value="message"/></h6>
	<h1 class='text-center btn btn-outline-success w-100 display-1'>Add Branch</h1>
<s:form action="addbranch" method="post">
	<s:textfield type="text" name="branchname" 
	cssClass="form-group form-control" label="Branch Name" 
	placeholder="Enter Branch Name"/>
	<s:textfield type="text" name="branchdesc" 
	cssClass="form-group form-control" label="Branch Description" 
	placeholder="Enter Branch Description"/>
	<s:submit cssClass="form-group btn btn-primary mx-5"/>
</s:form> 

<s:form name="showbranch" action="showbranch">
                <s:submit value="Fetch Records"/>
</s:form>

<table class="table table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>Branch Name</th>
			<th>Branch Description</th>
		</tr>
	</thead>
	<s:iterator value="branchlist">
	<tr>
			<td><s:property value="branchname"/></td>
			<td><s:property value="branchdesc"/></td>
	<tr>
	</s:iterator>
</table>
</div>
</body>
</html>