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
					<img src="../../images/allFigurine/${figurine.image}" alt="">
				</div>
				<div class="col s6">
					<div class="card-image">        
						<p><spring:message code="name"/> :${figurineTranslations.name} </p>						
						<p><spring:message code="description"/> :${figurineTranslations.description} </p>	
						<p><spring:message code="size"/> : ${figurine.size} cm</p>	
						<p><spring:message code="weight"/> : ${figurine.weight} g</p>	
						<p><spring:message code="brand"/> : ${figurine.brand}</p>
						<p><spring:message code="prize"/> : ${figurine.cost} euros</p>	
					</div>
					
					<button class="waves-effect waves-light btn">
						<spring:message code="addBasketButton"/>
					</button>
				</div>
			</div>
		</div>
	</body>
	
</html>