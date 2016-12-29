<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="movie"/></title>
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
		<div class="container">
			<h2>
				<spring:message code="findMovie"/>
			</h2>
				
			
			<div class="row">
				<div class="col s3">
					<form:form	id="searchNameID"
		      					method="POST"
		      					action="/figurine/movie/searchName"
		      					modelAttribute="searchName">
						<div class="input-field">
							<input id="search" type="search" required/>
							<label for="search"><i class="material-icons">search</i></label>
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
				
				<a href="<spring:url value='/videoGame'/>">
					<button class="btn waves-effect waves-light green" style="width:100%;">
						<spring:message code="videoGame"/>
					</button>
				</a>
				
				
				<a href="<spring:url value='/japaneseAnimation'/>">
					<button class="btn waves-effect waves-light red" style="width:100%;">
						<spring:message code="animationJapanese"/>
					</button>
				</a>
				
				
				<a href="<spring:url value='/movie'/>">
					<button class="btn waves-effect waves-light orange" style="width:100%;">					
			  				<spring:message code="movie"/>	  			
					</button>
				</a>
				
				
				
					<ul class="collapsible" data-collapsible="accordion">
					 	<li>
							<div class="collapsible-header"><i><img src="images/euro.png" height="20px"></i><spring:message code="prize"/></div>
							<div class="collapsible-body">
								<div class="row">
					      			<form class="col s12">
					      				<form:form 	id="searchPrizeID"
							      					method="POST"
							      					action="/figurine/movie/searchPrize"
							      					modelAttribute="searchPrize">
						      				<div class="input-field col s4">
									          	<input id="icon_prefix" type="text" class="validate"/>
									          	<label for="icon_prefix">
									          		<spring:message code="from"/>
									          	</label>
									        </div>
						      				<div class="input-field col s4">
									          	<input id="icon_prefix" type="text" class="validate"/>
									          	<label for="icon_prefix">
									          		<spring:message code="to"/>
									          	</label>
									        </div>							       					      			
							      			<form:button class="waves-effect waves-light btn">
							      				<spring:message code="searchButton"/>
							      			</form:button>
						      			</form:form>
					      			</form>
					      		</div>
							</div>
					    </li>
					    <li>
					      	<div class="collapsible-header"><i><img src="images/taille.png" height="20px"></i><spring:message code="height"/> (<spring:message code="cm"/>)</div>
					      	<div class="collapsible-body">
					      		<div class="row">
					      			<form class="col s12">
					      				<form:form	id="searchHeightID"
							      					method="POST"
							      					action="/figurine/movie/searchHeight"
							      					modelAttribute="searchHeight">
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
							      			<form:button class="waves-effect waves-light btn">
							      				<spring:message code="searchButton"/>
							      			</form:button>
					      				</form:form>
					      			</form>
					      		</div>
					      	</div>
					    </li>
					    <li>
					      	<div class="collapsible-header"><i><img src="images/poids.png" height="20px"></i><spring:message code="weight"/> (<spring:message code="gram"/>)</div>
					      	<div class="collapsible-body">
					      		<div class="row">
					      			<form class="col s12">
					      				<form:form	id="searchWeightID"
							      					method="POST"
							      					action="/figurine/movie/searchWeight"
							      					modelAttribute="searchWeight">
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
							      			<form:button class="waves-effect waves-light btn">
							      				<spring:message code="searchButton"/>
							      			</form:button>
						      			</form:form>
					      			</form>
					      		</div>
					      	</div>
					    </li>					    
					</ul>
	        	</div>
	        	
	        	<div class="col s9">
	        		<div class="row">
	        			<c:forEach items="${figurineMovie}" var="figurine">
		        			<div class="col s4">
		        				<div class="card" height="auto" max-width="100%">			        													      	
										<div>
				        					<p class="center-align" style="font-weight:bold">
				        						<a href="description/figurine?idFigurine=${figurine.idFigurine}">				        							
					        						${figurine.name}		
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
		        				</div>
		        			</div>
	        			</c:forEach> 
	        		</div>
	        	</div>
        	</div>
		</div>
	</body>
	
</html>