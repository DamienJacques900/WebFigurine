<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="registration"/></title>
	</head>
	
	<body>
	
	<div class="container"> 
		<div class="menuInscription">
		  
		      <h1><i><img src="<spring:url value='/images/iconInscription.png'/>" height="40px"></i>   <spring:message code="registration"/></h1>
		      
		      
		      	<form:form 	id="registrationForm"
		      				method="POST"
		      				action="/figurine/registration/registrationSend"
		      				modelAttribute="userRegistration">
			      	<div class="col s6">
			      		<form:label path="idUser" ><spring:message code="userName"/></form:label>
			          	<form:input path="idUser" type="text" class="validate"/>			         
			          	<form:errors path="idUser" style="color:red"></form:errors>
			        </div>
			        
			        <div class="col s6">
						<form:label path="password"><spring:message code="password"/></form:label>
			          	<form:input path="password" type="password" class="validate"/>			       
			          	<form:errors path="password" style="color:red"></form:errors>
			        </div>
			        
			        <div class="col s6">
						<form:label path="confirmationPassword"><spring:message code="verificationPassword"/></form:label>
			          	<form:input path="confirmationPassword" type="password" class="validate"/>			       
			          	<form:errors path="confirmationPassword" style="color:red"></form:errors>
			        </div>
			        
			      	<div class="col s6">
			      		<form:label path="lastName" ><spring:message code="lastName"/></form:label>
			          	<form:input path="lastName" type="text" class="validate"/>		          
			          	<form:errors path="lastName" style="color:red"></form:errors>
			        </div>
			        
			        <div class="col s6">
			        	<form:label path="firstName" ><spring:message code="firstName"/></form:label>
			          	<form:input path="firstName" type="text" class="validate"/>			          
			          	<form:errors path="firstName" style="color:red"></form:errors>
			        </div>		       			     
			        
			        <div class="col s6">
			        	<form:label path="street" ><spring:message code="street"/></form:label>
			          	<form:input path="street" type="text" class="validate"/>			          
			          	<form:errors path="street" style="color:red"></form:errors>
			        </div>
			        
			        <div class="col s6">
			        	<form:label path="city" ><spring:message code="city"/></form:label>
			          	<form:input path="city" type="text" class="validate"/>		          
			          	<form:errors path="city" style="color:red"></form:errors>
			        </div>
			        
			        <div class="col s6">
			        	<form:label path="numTel" ><spring:message code="phone"/> (<spring:message code="optional"/>)	</form:label>
				        <form:input path="numTel" type="text" class="validate"/>	          
				        <form:errors path="numTel"></form:errors>
			        </div>
			        
			        <div class="col s6">
			        	<form:label path="numFax" ><spring:message code="fax"/>  (<spring:message code="optional"/>)</form:label>
			          	<form:input path="numFax" type="text" class="validate"/>			          
			          	<form:errors path="numFax" style="color:red"></form:errors>
			        </div>
			        
			        <div class="col s6">
			        	<form:label path="postalCode" ><spring:message code="postalCode"/></form:label>
			          	<form:input path="postalCode" type="text" class="validate"/>			          
			          	<form:errors path="postalCode" style="color:red"></form:errors>
			        </div>
			        
			        <div class="col s6">
			        	<form:label path="country" ><spring:message code="country"/></form:label>
			          	<form:input path="country" type="text" class="validate"/>			          
			          	<form:errors path="country" style="color:red"></form:errors>
			        </div>
			        
			        <div class="col s6">
			        	<form:label path="email" ><spring:message code="email"/></form:label>
			          	<form:input path="email" type="text" class="validate"/>		          
			          	<form:errors path="email" style="color:red"></form:errors>
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