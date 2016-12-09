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
					image
				</div>
				<div class="col s6">
					<div>        					
						<p class="truncate"><spring:message code="description"/> : ${figurine.description}</p>	
						<p><spring:message code="size"/> : ${figurine.size} cm</p>	
						<p><spring:message code="weight"/> : ${figurine.weight} g</p>	
						<p><spring:message code="brand"/> : ${figurine.brand}</p>	
					</div>
					
					<button class="waves-effect waves-light btn">
						<spring:message code="addBasketButton"/>
					</button>
				</div>
			</div>
		</div>
	</body>
	
</html>