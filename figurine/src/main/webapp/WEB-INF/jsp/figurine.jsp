<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>


<html>	
	<head>
		<title><spring:message code="figurine"/></title>
		<script type="text/javascript">

		</script>
	</head>
	
	<body>
	
		<div class="section no-pad-bot">
		    <div class="container">
		        <h1 class="header center rbwd-red-text text-base thin-text" style="text-color:blue">
		        	<spring:message code="figurineSection"/>
		        </h1>
		    </div>
		    
		    
		</div>
		
		<div class="container">
			<h2>
				<spring:message code="findFigurine"/>
			</h2>
			<div class="row">
				<div class="col s3">
					<form:form id="searchByName"
		      				   method="POST"
		      				   action="/figurine/figurine/searchName"
		      				   modelAttribute="figurineName">
						<div class="input-field">
							<form:input path="name" id="search" type="search"/>
							<form:label path="name" for="search"><i class="material-icons">search</i></form:label>
							<i class="material-icons">close</i>
						</div>
						<form:button class="waves-effect waves-light btn">
					      	<spring:message code="searchButton"/>
					    </form:button>	
					</form:form>
				</div>
			</div>
			<div class="row">
				<div class="col s3">
				
				<h4><spring:message code="category"/></h4>
				<c:forEach items="${categoryTranslations}" var="category">
					<a href="<spring:url value='/figurine/byCategory/${category.category}'/>">
						<button class="btn waves-effect waves-light blue" style="width:100%;">
							${category.name}
						</button>
					</a>	
				</c:forEach>
							
				
					
	        	</div>
	        	
	        	<div class="col s9">
	        		<div class="row">
	        		
	        			<c:forEach items="${figurineAll}" var="figurine"  varStatus="status" >
		        			<div class="col s4">
		        				<div class="card" style="height:400px">	
		        					<form:form	id="descriptionID"
								      			method="POST"
								      			action="/figurine/welcome/description"
								      			modelAttribute="description">  								      	
											<div>
												<p class="center-align" style="font-weight:bold">
					        						<a href="<spring:url value='/description/figurine/${figurine.idFigurine}'/>">
					        							${figurineTranslations[status.index].name}
					        						</a>
					        						
					        					</p>
				        					</div>
				        					<div class="card-image">
				        					
				        						<a href="<spring:url value='/description/figurine/${figurine.idFigurine}'/>">
				        							<img src="<spring:url value='/images/allFigurine/${figurine.image}'/>" alt="" height="250px"/>
				        						</a>
				        					
				        						<p class="center-align" style="font-weight:bold">
				        							<fmt:formatNumber type="number" maxFractionDigits="2" value="${figurine.cost}"/>€
				        						</p>
				        						<div>		        						
						        					<c:forEach items="${promotionAll}" var="promotion">
							        					<c:choose>
							        						<c:when test="${figurine.promotion eq promotion.idPromotion}">
							        							<p style="color:red">
							        								Promo : ${promotion.amountPourc*100} %
							       								</p>
							       							</c:when>
							       						</c:choose>
						       						</c:forEach>
					       						</div>
				        					</div>       														    					
		        					</form:form> 
		        				</div>
		        			</div>
	        			</c:forEach>
	        		</div>
	        	</div>
        	</div>
		</div>

		
		
	</body>
	
</html>