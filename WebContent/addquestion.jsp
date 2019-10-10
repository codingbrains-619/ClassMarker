<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="cm" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Questions</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<cm:header rolename='sessionScope.role' userid='sessionScope.userid'
		rights='sessionScope.rights'></cm:header>
	<div class='w-100 float-right pr-2'>
		<div class="w-50 float-left">
			<h1 class='text-center btn btn-outline-primary w-100 display-1'>Add
				New Question</h1>
			<s:form action="addquestion" namespace="/">

				<s:textarea rows="10" cols="30" type="text" name="question"
					cssClass="form-group 
		form-control" label="Question"
					placeholder="Enter Question" />
				<s:textfield type="text" name="choice1"
					cssClass="form-group 
		form-control" label="Choice 1"
					placeholder="Enter first choice" />
				<s:textfield type="text" name="choice2"
					cssClass="form-group 
		form-control" label="Choice 2"
					placeholder="Enter second choice" />
				<s:textfield type="text" name="choice3"
					cssClass="form-group 
		form-control" label="Choice 3"
					placeholder="Enter third choice" />
				<s:textfield type="text" name="choice4"
					cssClass="form-group 
		form-control" label="Choice 4"
					placeholder="Enter fourth choice" />
				<s:combobox list="{1,2,3,4}" headerKey="-1"
					headerValue="--- Select ---" name="selectedchoice"
					label="Correct Choice" />

				<s:submit value="Add new Question"
					cssClass="form-group btn btn-info mx-5" />
				<%-- <s:submit value="Add from QuestionBank" cssClass="form-group btn btn-primary mx-5"/> --%>
			</s:form>
		</div>
		<div class="w-50 float-right pl-1">
			<h1 class='text-center btn btn-outline-primary w-100 display-1'>Add
				From Question Bank</h1>
			<s:form action="AddQuestionBank" namespace="/">
				<table class="table table-bordered">
					<thead class="thead-dark">
						<tr>
							<th>Question</th>
							<th>Choice1</th>
							<th>Choice2</th>
							<th>Choice3</th>
							<th>Choice4</th>
							<th>Correct Choice</th>
						</tr>
					</thead>

					<s:iterator value="questionbanklist">
						<tr>
							<td><s:property value="question" /></td>
							<td><s:property value="choice1" /></td>
							<td><s:property value="choice2" /></td>
							<td><s:property value="choice3" /></td>
							<td><s:property value="choice4" /></td>
							<td><s:property value="selectedchoice" /></td>
						<tr>
					</s:iterator>
				</table>
				<%-- <s:checkboxlist list="questionbanklist" name="selectedquestionbank" label="Questions"></s:checkboxlist> --%>
				<s:submit value="Add Question"
					cssClass="form-group btn btn-primary mx-5" />
			</s:form>
		</div>
		<s:form name="submit" action="submitTest" namespace="/"
			class="mx-auto my-5">
			<s:submit value="Submit" cssClass="form-group btn btn-success mx-5" />
		</s:form>
	</div>
	<cm:footer></cm:footer>
</body>
</html>