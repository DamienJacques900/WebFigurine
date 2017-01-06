<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="description"/></title>
		<script type="text/javascript">

		</script>
	</head>
	
	<body>
		<div class="container">
			<h2>
				<spring:message code="descriptionFigurine"/>
			</h2>
			
			<div class="row">
				<div class="col s6">
					<img src="<spring:url value='/images/allFigurine/${figurine.image}'/>" alt="" style="height:400px; width:auto ">
				</div>
				<div class="col s6">
					 
							   
						<div class="card-image">        
							<p><spring:message code="name"/> :${figurineTranslations.name} </p>						
							<p><spring:message code="description"/> :${figurineTranslations.description} </p>	
							<p><spring:message code="size"/> : ${figurine.size} cm</p>	
							<p><spring:message code="weight"/> : ${figurine.weight} g</p>	
							<p><spring:message code="brand"/> : ${figurine.brand}</p>
							<c:choose>
								<c:when test="${figurine.cost eq prizeWithoutPromotion}">
									<p><spring:message code="prize"/> : ${figurine.cost} €</p>								
								</c:when>
								<c:otherwise>	
									<p>
										<spring:message code="prize"/> : 
										<strike>${prizeWithoutPromotion} €</strike>
										<span style="color:red">${figurine.cost} €</span>	
									</p>										
								</c:otherwise>
							</c:choose>
						</div>
						
						
        
				
					<form:form id="newCommandLine"
							   method="POST"
							   action="/figurine/description/figurineBasket"
							   modelAttribute="figurineCommand">
							
						<form:label path = "nbFigurine" for="user_lic"><spring:message code="nbFigurine"/> </form:label>
						<form:input path = "nbFigurine" id="user_lic" type="number" min="1" max="100" step="1" value ="1"/>	
						   
						<form:hidden path="figurine" value="${figurine.idFigurine}"/>
						
						<form:hidden path="prizeCommand" value="${figurine.cost}"/>
						
						<form:button class="waves-effect waves-light btn">
							<spring:message code="addBasketButton"/>
						</form:button>
					</form:form>
					
					
				</div>
			</div>
		</div>
	</body>
	
</html>