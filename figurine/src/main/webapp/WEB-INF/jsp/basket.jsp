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
			  		<c:forEach items="${commandLinesWithItems}" var="commandLinesWithItems" varStatus="status">
			  			<li class="collection-item avatar">
			  				<img src="<spring:url value='/images/allFigurine/${commandLinesWithItems.figurine.image}'/>" alt="" height="50px">
							<p>
								<spring:message code="name"/> : ${figurineTranslations[status.index].name} <br>									      	
							</p>
							 <p><spring:message code="brand"/> : ${commandLinesWithItems.figurine.brand} <br>
								<spring:message code="description"/> : ${figurineTranslations[status.index].description}								
							</p>
							<p>
								<spring:message code="unityPrize"/> : <fmt:formatNumber type="number" maxFractionDigits="2" value="${commandLinesWithItems.figurine.cost}"/>€
								
							</p>
							
							<p class="secondary-content">
								<spring:message code="prize"/> : <fmt:formatNumber type="number" maxFractionDigits="2" value="${commandLinesWithItems.figurine.cost*commandLinesWithItems.commandLine.nbFigurine}"/>€ 
								<br>
											
							<c:forEach items="${promotionAll}" var="promotion">
			     					<c:choose>
							       		<c:when test="${commandLinesWithItems.figurine.promotion eq promotion.idPromotion}">
							       			<p style="color:red">
							        			Promo : ${promotion.amountPourc*100} %
							       			</p>
										</c:when>
									</c:choose>
		       					</c:forEach>				
							<form:form id="newCommandLine"
									   method="POST"
									   action="/figurine/basket/nbFigurineBasket"
									   modelAttribute="figurineBasket">
							<p><spring:message code="nbFigurine"/></p>
							<form:input path="nbFigurine" id="user_lic" type="number" min="1" max="100" step="1" value ="${commandLinesWithItems.commandLine.nbFigurine}"/>
							<form:hidden path="prizeCommand" value="${commandLinesWithItems.commandLine.prizeCommand}"/>
							<form:hidden path="figurine" value="${commandLinesWithItems.commandLine.figurine}"/>
							<form:hidden path="command" value="${commandLinesWithItems.commandLine.command}"/>
							<form:hidden path="idCommandeLine" value="${commandLinesWithItems.commandLine.idCommandeLine}"/>
										     										     	
										     	
							<form:button class="waves-effect waves-light btn">
								<spring:message code="modify"/>
							</form:button>
							</form:form>
							<form:form id="newCommandLine"
										method="POST"
										action="/figurine/basket/deleteFigurineBasket"
										modelAttribute="deleteBasket">
													   
							<form:hidden path="idCommandeLine" value="${commandLinesWithItems.commandLine.idCommandeLine}"/>
													  
							<form:button class="waves-effect waves-light btn">
								<spring:message code="delete"/>
							</form:button>
							</form:form>
									     	
							</p>
							
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
		  				
		  					<c:forEach items="${commandLinesWithItems}" var="commandLinesWithItems" varStatus="status">
			  					<div class="row">
				  					<c:forEach items="${figurineTranslations}" var="figurine" varStatus="status">
				  						<li>
					  						<c:choose>
					  							<c:when test="${commandLinesWithItems.commandLine.figurine eq figurine.figurine}">
						  							<div class="col s7">
						  								${figurineTranslations[status.index].name} (${commandLinesWithItems.commandLine.nbFigurine}X)
						  							</div>
						  							<div class="col s5">
						  								 
						  								<fmt:formatNumber type="number" maxFractionDigits="2" value="${commandLinesWithItems.figurine.cost*commandLinesWithItems.commandLine.nbFigurine}"/>€
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
		  								<spring:message code="total"/> : <fmt:formatNumber type="number" maxFractionDigits="2" value="${totalValue}"/> €
		  								
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
					  			
							  	<form:button class="btn waves-effect waves-light" type="submit" name="action" disabled="${commandLinesWithItems[0].commandLine.figurine eq null}">
									<spring:message code="commandButton"/>
							  	</form:button>
						  								  			
				  			</form:form>
			  			</c:when>
			  			<c:otherwise>
			  				<form:form 	id="commandUser"
				      					method="POST"
				      					action="/figurine/basket/command"
				      					modelAttribute="command">
				      					
				      			<form:button class="btn waves-effect waves-light" type="submit" name="action" disabled="${commandLinesWithItems[0].commandLine.figurine eq null}">
									<spring:message code="commandButton"/>									
							  	</form:button>
							  	
				  			</form:form>
			  			</c:otherwise>
		  			</c:choose>
	  			</div>
  			</div>
		</div>
	</body>
	
</html>