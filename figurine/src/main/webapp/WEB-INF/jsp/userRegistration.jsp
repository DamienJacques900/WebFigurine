<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="registration"/></title>
	</head>
	
	<body>
		<div class="section no-pad-bot">
		    <div class="container">
		        <h1 class="header center rbwd-red-text text-base thin-text">
		        	<spring:message code="registrationValidate"/>
		        </h1>
		        <h2 class="header center light thin-text">
		        	<spring:message code="figurineSite"/>
		        </h2>
		    </div>
		    
		    <div class="container">		
			
				<p>
					<spring:message code="registrationSentence"/>
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
					    <li>
							<div class="collapsible-header"><i><img src="images/marque.png" height="20px"></i><spring:message code="brand"/></div>
							<div class="collapsible-body">
								<form:form>
									<ul>
										<li>
										  	<input type="checkbox" id="marque1"/>
										  	<label for="marque1">Marque1</label>
										</li>
										<li>
										  	<input type="checkbox" id="marque2"/>
										  	<label for="marque2">Marque2</label>
										</li>
										<li>
										  	<input type="checkbox" id="marque3"/>
										  	<label for="marque3">Marque3</label>
										</li>
										<li>
										  	<input type="checkbox" id="marque4"/>
										  	<label for="marque4">Marque4</label>
										</li>
										<li> 
										  	<input type="checkbox" id="marque5"/>
										  	<label for="marque5">Marque5</label>
										</li>
										<li>
										  	<input type="checkbox" id="marque6"/>
										  	<label for="marque6">Marque6</label>
										</li>
									</ul>
									<button class="waves-effect waves-light btn">
						      			<spring:message code="searchButton"/>
						      		</button>
					      		</form:form>
							</div>
					    </li>
					</ul>
	        	</div>
	        	
	        	<div class="col s9">
	        		<div class="row">
	        			<div class="col s4">
	        				<div class="card">
	        					<form:form>
		        					<div>
		        						<h4 class="center-align">
		        							<spring:message code="figurineName"/>
		        						</h4>
		        					</div>
		        					<div class="card-image">
		        						<img src="images/animé.jpg" alt="" height="200px">
		        					</div>
		        					<p><spring:message code="description"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="size"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="weight"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="brand"/> : <spring:message code="long"/></p>	
		        					<div>
		        						<h5 class="center-align"><spring:message code="prize"/> : 50 <spring:message code="euro"/></h5>
		        					</div>
		        					<p class="range-field">
								      <input type="range" id="test5" min="1" max="10" />
								    </p>
		        					<button class="btn waves-effect waves-light">
		        						<spring:message code="addBasketButton"/>
		        					</button>
	        					</form:form>
	        				</div>
	        			</div>
	        			<div class="col s4">
	        				<div class="card">	 
	        					<form:form>       					
		        					<div>
		        						<h4 class="center-align">
		        							<spring:message code="figurineName"/>
		        						</h4>
		        					</div>
		        					<div class="card-image">
		        						<img src="images/original.png" alt="" height="200px">
		        					</div>
		        					<p><spring:message code="description"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="size"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="weight"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="brand"/> : <spring:message code="long"/></p>	
		        					<div>
		        						<h5 class="center-align"><spring:message code="prize"/> : 50 <spring:message code="euro"/></h5>
		        					</div>
		        					<button class="btn waves-effect waves-light">
		        						<spring:message code="addBasketButton"/>
		        					</button>
	        					</form:form>
	        				</div>
	        			</div>
	        			<div class="col s4">
	        				<div class="card">
	        					<form:form>
		        					<div>
		        						<h4 class="center-align">
		        							<spring:message code="figurineName"/>
		        						</h4>
		        					</div>
		        					<div class="card-image">
		        						<img src="images/jeuxvidéo.jpeg" alt="" height="200px">
		        					</div>
		        					<p><spring:message code="description"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="size"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="weight"/> : <spring:message code="long"/></p>	
		        					<p><spring:message code="brand"/> : <spring:message code="long"/></p>	
		        					<div>
		        						<h5 class="center-align"><spring:message code="prize"/> : 50 <spring:message code="euro"/></h5>
		        					</div>
		        					<button class="btn waves-effect waves-light">
		        						<spring:message code="addBasketButton"/>
		        					</button>
	        					</form:form>
	        				</div>
	        			</div>
	        		</div>
	        	</div>
        	</div>
		</div>
	</body>
	
</html>