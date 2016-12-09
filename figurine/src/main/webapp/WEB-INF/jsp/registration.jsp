<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="registrationConnection"/></title>
	</head>
	
	<body>
	
	<div class="container"> 
		<div class="menuInscription">
		  
		      <h1><i><img src="images/iconInscription.png" height="40px"></i>   <spring:message code="registration"/></h1>
		      
		      
		      	<form:form 	id="registrationForm"
		      				method="POST"
		      				action="/figurine/registration/registrationSend"
		      				modelAttribute="currentUserRegistration">
			      	<div class="input-field col s6">
			          <form:input path="idUser" type="text" class="validate"/>
			          <form:label path="idUser" ><spring:message code="userName"/></form:label>
			          <form:errors path="idUser"></form:errors>
			        </div>
			      	<div class="input-field col s6">
			          <form:input path="lastName" type="text" class="validate"/>
			          <form:label path="lastName" ><spring:message code="lastName"/></form:label>
			          <form:errors path="lastName"></form:errors>
			        </div>
			        
			        <div class="input-field col s6">
			          <form:input path="firstName" type="text" class="validate"/>
			          <form:label path="firstName" ><spring:message code="firstName"/></form:label>
			          <form:errors path="firstName"></form:errors>
			        </div>
			        
			        <div class="input-field col s6">
			          <form:input path="password" type="password" class="validate"/>
			          <form:label path="password" ><spring:message code="password"/></form:label>
			          <form:errors path="password"></form:errors>
			        </div>
			        
			        <div class="input-field col s6">
			          <form:input path="password" type="password" class="validate"/>
			          <form:label path="password" ><spring:message code="verificationPassword"/></form:label>
			          <form:errors path="password"></form:errors>
			        </div>
			        
			        <div class="input-field col s6">
			          <form:input path="street" type="text" class="validate"/>
			          <form:label path="street" ><spring:message code="street"/></form:label>
			          <form:errors path="street"></form:errors>
			        </div>
			        
			        <div class="input-field col s6">
			          <form:input path="city" type="text" class="validate"/>
			          <form:label path="city" ><spring:message code="city"/></form:label>
			          <form:errors path="city"></form:errors>
			        </div>
			        
			        <div class="input-field col s6">
			          <form:input path="postalCode" type="text" class="validate"/>
			          <form:label path="postalCode" ><spring:message code="postalCode"/></form:label>
			          <form:errors path="postalCode"></form:errors>
			        </div>
			        
			        <div class="input-field col s6">
			          <form:input path="country" type="text" class="validate"/>
			          <form:label path="country" ><spring:message code="country"/></form:label>
			          <form:errors path="country"></form:errors>
			        </div>
			        
			        <div class="input-field col s6">
			          <form:input path="email" type="text" class="validate"/>
			          <form:label path="email" ><spring:message code="email"/></form:label>
			          <form:errors path="email"></form:errors>
			        </div>
			        
					<form:button class="btn waves-effect waves-light" type="submit" name="action">
						<spring:message code="validateButton"/>
					  	<i class="material-icons right">send</i>
					</form:button>
				</form:form>
        
		   
		  </div>
		  <div class="imageClass">
			<img src ='<spring:url value="/images/connection.png"/>'/>
		</div>      
    </div>
	</body>
	
</html>