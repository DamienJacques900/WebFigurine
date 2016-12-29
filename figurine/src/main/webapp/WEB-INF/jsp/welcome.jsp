<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>


<html>

	<!-- <head>
		<title><spring:message code="reception"/></title>
		<script type="text/javascript">
		// Pause slider
		$('.slider').slider('pause');
		// Start slider
		$('.slider').slider('start');
		// Next slide
		$('.slider').slider('next');
		// Previous slide
		$('.slider').slider('prev');
		</script>	
	</head>-->
	
	
	<head>
		<title><spring:message code="reception"/></title>
		<script type="text/javascript">
		var slider = document.getElementById('test5');
		  noUiSlider.create(slider, {
		   start: [1, 10],
		   connect: true,
		   step: 1,
		   range: {
		     'min': 1,
		     'max': 10
		   },
		   format: wNumb({
		     decimals: 0
		   })
		  });
		</script>
	</head>
	
	<body>
	
		<div class="section no-pad-bot">
		    <div class="container">
		        <h1 class="header center rbwd-red-text text-base thin-text" style="text-color:blue">Madoline</h1>
		        <h2 class="header center light thin-text">
		        	<spring:message code="figurineSite"/>
		        </h2>
		    </div>
		    
		    <div class="container">		
			
				<p>
					<spring:message code="welcomeSentence"/>
				</p>
			
			</div>
		</div>
		
		<div class="container">
			<h2>
				<spring:message code="findFigurine"/>
			</h2>
			<div class="row">
				<div class="col s3">
					<form>
						<div class="input-field">
							<input id="search" type="search" required>
							<label for="search"><i class="material-icons">search</i></label>
							<i class="material-icons">close</i>
						</div>
						<button class="waves-effect waves-light btn">
					      	<spring:message code="searchButton"/>
					    </button>	
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col s3">
				
				<form:form id="descriptionID"
						   method="POST"
						   action="/figurine/japaneseAnimation/description"
						   modelAttribute="description">
					<a href="<spring:url value='/videoGame'/>">
						<form:button class="btn waves-effect waves-light green" style="width:100%;">
							<spring:message code="videoGame"/>
						</form:button>
					</a>
				</form:form>
				
				<form:form id="descriptionID"
						   method="POST"
						   action="/figurine/japaneseAnimation/description"
						   modelAttribute="description">
					<a href="<spring:url value='/japaneseAnimation'/>">
						<form:button class="btn waves-effect waves-light red" style="width:100%;">
							<spring:message code="animationJapanese"/>
						</form:button>
					</a>
				</form:form>
				
				
				<form:form id="descriptionID"
						   method="POST"
						   action="/figurine/japaneseAnimation/description"
						   modelAttribute="description">
					<a href="<spring:url value='/movie'/>">
						<form:button class="btn waves-effect waves-light orange" style="width:100%;">					
				  				<spring:message code="movie"/>	  			
						</form:button>
					</a>
				</form:form>
				
				
			
				
					<ul class="collapsible" data-collapsible="accordion">
					 	<li>
							<div class="collapsible-header"><i><img src="images/euro.png" height="20px"></i><spring:message code="prize"/></div>
							<div class="collapsible-body">
								<div class="row">
					      			<form class="col s12">
					      				<div class="input-field col s4">
								          	<input id="icon_prefix" type="text" class="validate">
								          	<label for="icon_prefix">
								          		<spring:message code="from"/>
								          	</label>
								        </div>
					      				<div class="input-field col s4">
								          	<input id="icon_prefix" type="text" class="validate">
								          	<label for="icon_prefix">
								          		<spring:message code="to"/>
								          	</label>
								        </div>	
								        <button class="waves-effect waves-light btn">
					      					<spring:message code="searchButton"/>
					      				</button>						       
					      			</form>
					      		</div>
							</div>
					    </li>
					    <li>
					      	<div class="collapsible-header"><i><img src="images/taille.png" height="20px"></i><spring:message code="height"/> (<spring:message code="cm"/>)</div>
					      	<div class="collapsible-body">
					      		<div class="row">
					      			<form class="col s12">
					      				<div class="input-field col s4">
								          	<input id="icon_prefix" type="text" class="validate">
								          	<label for="icon_prefix">
								          		<spring:message code="from"/>
								          	</label>
								        </div>
					      				<div class="input-field col s4">
								          	<input id="icon_prefix" type="text" class="validate">
								          	<label for="icon_prefix">
								          		<spring:message code="to"/>								          		
								          	</label>							          							          	
								        </div>	
								        <button class="waves-effect waves-light btn">
					      					<spring:message code="searchButton"/>
					      				</button>						       
					      			</form>
					      		</div>
					      	</div>
					    </li>
					    <li>
					      	<div class="collapsible-header"><i><img src="images/poids.png" height="20px"></i><spring:message code="weight"/> (<spring:message code="gram"/>)</div>
					      	<div class="collapsible-body">
					      		<div class="row">
					      			<form class="col s12">
					      				<div class="input-field col s4">
								          	<input id="icon_prefix" type="text" class="validate">
								          	<label for="icon_prefix">
								          		<spring:message code="from"/>
								          	</label>
								        </div>
					      				<div class="input-field col s4">
								          	<input id="icon_prefix" type="text" class="validate">
								          	<label for="icon_prefix">
								          		<spring:message code="to"/>								          		
								          	</label>
								        </div>	
								        <button class="waves-effect waves-light btn">
					      					<spring:message code="searchButton"/>
					      				</button>						       
					      			</form>
					      		</div>
					      	</div>
					    </li>
					   
					</ul>
	        	</div>
	        	
	        	<div class="col s9">
	        		<div class="row">
	        			<c:forEach items="${figurineAll}" var="figurine">
		        			<div class="col s4">
		        				<div class="card">	
		        					<form:form	id="descriptionID"
								      			method="POST"
								      			action="/figurine/welcome/description"
								      			modelAttribute="description">  								      	
											<div>
												<p class="center-align" style="font-weight:bold">
					        						<a href="description/figurine?idFigurine=${figurine.idFigurine}">
					        							${figurine.name}
					        							<%
					        								//request.setAttribute("FigurineName",figurineAnimation.getName());
					        							%>
					        						</a>
					        					</p>
				        					</div>
				        					<div class="card-image">
				        					
				        						<a href="description/figurine?idFigurine=${figurine.idFigurine}">
				        							<img src="images/allFigurine/${figurine.image}" alt="" height="250px">
				        						</a>
				        					
				        						<p class="center-align" style="font-weight:bold">
				        							${figurine.cost} <spring:message code="euro"/>
				        						</p>
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