<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="cm" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Take Test</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<cm:header rolename='sessionScope.role' userid='sessionScope.userid'
		rights='sessionScope.rights'></cm:header>
	<div class='w-100 float-right pr-2'>
		<h1 class='text-center btn btn-outline-success w-100 display-1'>Take Test</h1>
		<s:form action="taketest" namespace="/">
			<s:property value="question"/>
			<s:property value="choice1"/>
			<s:property value="choice2"/>
			<s:property value="choice3"/>
			<s:property value="choice4"/>
			<s:combobox list="{1,2,3,4}" headerKey="-1" headerValue="--- Select ---" name="selectedchoice" label="Correct Choice"/>
			
		</s:form>

	</div>
	<cm:footer></cm:footer>
</body>
</html>