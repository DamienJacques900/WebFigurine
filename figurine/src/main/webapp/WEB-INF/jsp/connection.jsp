<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="connection"/></title>
	</head>
	
	<body>
	
	<div class="container"> 
		<div class="menuInscription">
		  
		      <h1><i><img src="<spring:url value='/images/iconConnection.png'/>" height="40px"></i>   <spring:message code="connection"/></h1>
		      
		      	<form:form 	id="connectionForm"
		      				method="POST"
		      				action="/figurine/connection/connectionSend"
		      				modelAttribute="currentUserConnection">
		         
			        <div class="col s6">			       
			          	<form:label path="idUser"><spring:message code="userName"/></form:label>
			          	<form:input path="idUser" type="text" class="validate"/>
			          	<form:errors path="idUser"></form:errors>
			        </div>
				
					<div class="col s6">
						<form:label path="password"><spring:message code="password"/></form:label>
			          	<form:input path="password" type="password" class="validate"/>			       
			          	<form:errors path="password"></form:errors>
			        </div>

			        <form:button class="btn waves-effect waves-light">
			        	<spring:message code="connectionButton"/>
	  				</form:button>
	  			</form:form>  	    
		  </div>
		  <div class="imageClass">
			<img src ='<spring:url value="/images/connection.png"/>'/>
		</div>      
    </div>
	</body>
	
</html>