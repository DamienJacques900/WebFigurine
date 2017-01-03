<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="basket"/></title>
	</head>
	
	<body>
		<div class="container">
			<div class="row">
				<h1><spring:message code="basketTitle"/></h1>
			</div>
			<div class="row">
				<div class="col s9">
			  	<ul class="collection">
			  		<c:forEach items="${commandLines}" var="commandLine">
			  			<li class="collection-item avatar">
			  				<c:forEach items="${figurineTranslations}" var="figurine" varStatus="status">
			  					<c:choose>
			  						<c:when test="${commandLine.figurine eq figurine.figurine}">
								    	<img src="<spring:url value='/images/allFigurine/${figurineAllCommand[status.index].image}'/>" alt="" height="50px">
								    	<p>
								    		<spring:message code="name"/> : ${figurine.name} <br>									      	
									     </p>
									     <p><spring:message code="brand"/> : ${figurineAllCommand[status.index].brand} <br>
									      	<spring:message code="description"/> : ${figurine.description}
									     </p>
									     
									     
									     <p class="secondary-content">
									     	<spring:message code="prize"/> : ${commandLine.prizeCommand*commandLine.nbFigurine} <spring:message code="euro"/><br>
									     	
							    			<br>
											
											
											<form:form id="newCommandLine"
													   method="POST"
													   action="/figurine/basket/nbFigurineBasket"
													   modelAttribute="figurineBasket">
												<p><spring:message code="nbFigurine"/></p>
												<form:input path="nbFigurine" id="user_lic" type="number" min="1" max="100" step="1" value ="${commandLine.nbFigurine}"/>
										     	<form:hidden path="prizeCommand" value="${commandLine.prizeCommand}"/>
										     	<form:hidden path="figurine" value="${commandLine.figurine}"/>
										     	<form:hidden path="command" value="${commandLine.command}"/>
										     	<form:hidden path="idCommandeLine" value="${commandLine.idCommandeLine}"/>
										     										     	
										     	
								    			<form:button class="waves-effect waves-light btn">
								    				<spring:message code="modify"/>
								    			</form:button>
							    			</form:form>
							    			<form:form id="newCommandLine"
													   method="POST"
													   action="/figurine/basket/deleteFigurineBasket"
													   modelAttribute="deleteBasket">
													   
												<form:hidden path="idCommandeLine" value="${commandLine.idCommandeLine}"/>
													  
								    			<form:button class="waves-effect waves-light btn">
								    				<spring:message code="delete"/>
								    			</form:button>
							    			</form:form>
									     	
									     </p>
									</c:when>	
							  	</c:choose>
							</c:forEach>							          
				    	</li>				    	
			  		</c:forEach>			   
				  </ul>
	                   	
	  			</div>
	  			
	  			<div class="col s3">
	  				<div class="card">
		  				<h5>
		  					<spring:message code="command"/>
						</h5>
		  				<ul>
		  					<c:forEach items="${commandLines}" var="commandLine" varStatus="status">
			  					<div class="row">
				  					<c:forEach items="${figurineTranslations}" var="figurine" varStatus="status">
				  						<li>
					  						<c:choose>
					  							<c:when test="${commandLine.figurine eq figurine.figurine}">
						  							<div class="col s7">
						  								${figurineTranslations[status.index].name} (${commandLine.nbFigurine}*)
						  							</div>
						  							<div class="col s5">
						  								${commandLine.prizeCommand*commandLine.nbFigurine} <spring:message code="euro"/>
						  							</div>
					  							</c:when>
					  						</c:choose>
				  						</li>
				  					</c:forEach>
			  					</div>
			  				</c:forEach>
		  					
		  					<hr>
		  					<div class="row">
		  						<li>
		  							<div>
		  								<spring:message code="total"/> : ${totalValue} <spring:message code="euro"/>
		  							</div>		  							
		  						</li>
		  					</div>
		  				</ul>		  				
		  			</div>
		  			<c:choose>
		  				<c:when test="${currentUserConnection.connected eq null}">
				  			<form:form 	id="commandUser"
				      					method="POST"
				      					action="/figurine/basket/commandNotPossible"
				      					modelAttribute="command">
					  			
							  	<form:button class="btn waves-effect waves-light" type="submit" name="action" disabled="${commandLines[0].figurine eq null}">
									<spring:message code="commandButton"/>
							  	</form:button>
						  								  			
				  			</form:form>
			  			</c:when>
			  			<c:otherwise>
			  				<form:form 	id="commandUser"
				      					method="POST"
				      					action="/figurine/basket/command"
				      					modelAttribute="command">
				      					
				      			<form:button class="btn waves-effect waves-light" type="submit" name="action" disabled="${commandLines[0].figurine eq null}">
									<spring:message code="commandButton"/>									
							  	</form:button>
							  	
				  			</form:form>
			  			</c:otherwise>
		  			</c:choose>
	  			</div>
	  			<div>
	  				<h1>TEST :</h1>
	  				<c:forEach items="${commandLinesWithFigurines}" var="figurine">
	  					<p>NOM : ${commandLinesWithFigurines.figurine.name}</p>
	  				</c:forEach>
	  			</div>
  			</div>
		</div>
	</body>
	
</html>