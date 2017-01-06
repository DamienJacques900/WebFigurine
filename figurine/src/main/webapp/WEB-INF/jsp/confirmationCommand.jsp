<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="confirmationCommand"/></title>
	</head>
	
	<body>
		<div class="whiteCard card container">
			<h3 class="header center rbwd-red-text text-base thin-text"><spring:message code="confirmation"/></h3>
			<div class="header center rbwd-red-text text-base thin-text">
				<form:form 	id="commandUserValidate"
					      	method="POST"
					      	action="/figurine/confirmationCommand/commandValidate"
					      	modelAttribute="command">
					<form:button class="btn waves-effect waves-light" type="submit" >
						<spring:message code="yes"/>									
					</form:button>
				</form:form>
				<form:form 	id="commandUserNotValidate"
					      	method="POST"
					      	action="/figurine/confirmationCommand/commandNotValidate"
					      	modelAttribute="command">
					<form:button class="btn waves-effect waves-light" type="submit">
						<spring:message code="no"/>									
					</form:button>
				</form:form>
			</div>
		</div>
	</body>
	
</html>