<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>

	<head>
		<meta http-equiv="Content-type" content="type=text/html; charset=UTF-8"/>

		<link type="text/css" href="<spring:url value='/css/materialize.css/'/>" 
				rel="Stylesheet">
		<link type="text/css" href="<spring:url value='/css/style.css/'/>" 
				rel="Stylesheet">
		<link href="<spring:url value='http://fonts.googleapis.com/icon?family=Material+Icons' />" rel="stylesheet">
		<script type="text/javascript"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="<spring:url value='/js/materialize.js' />" ></script>
		
	</head>
	
	<body ></body>
	

		
		<spring:url var="localeEn" value="">
			<spring:param name="locale" value="en"/>
		</spring:url>
		<spring:url var="localeFr" value="">
			<spring:param name="locale" value="fr"/>
		</spring:url>
		
		<header>
			<nav class="red">
				<div class="nav-wrapper container">
				 	<a href="<spring:url value='/welcome'/>" class="brand-logo black-text">
				 		<img src ='<spring:url value="/images/logo.png"/>' height="40px" width="33px"/>
				 		Madoline
					</a>   
				 	<a class="button-collapse" href="#" data-activates="nav-mobile">
				 		<i class="material-icons black-text">menu</i>
				 	</a>
				 	<ul class="right hide-on-med-and-down">
				 		<li>
				 			<a class="nav-btn waves-effect waves-light" href="<spring:url value='/welcome'/>">
				 				<spring:message code="reception"/>
							</a>
				 		</li> 
				 		
				 		<li>
				 			<a class="nav-btn waves-effect waves-light" href="<spring:url value='/figurine'/>">
				 			<spring:message code="figurine"/>
				 			</a>
				 		</li>
				 	
				 		<li>
				 			<a class="nav-btn waves-effect waves-light" href="<spring:url value='/basket'/>">
				 			<spring:message code="basket"/>
				 			</a>
				 		</li>
				 					 
						 		
						 	
						 	<c:choose>
						 		<c:when test="${currentUserConnection.connected eq null}">
						 			<li>
							 			<a class="nav-btn waves-effect waves-light" href="<spring:url value='/connection'/>">
						 					<spring:message code="connection"/>
						 				</a>
						 			</li>
					 		
						 			<li>
							 			<a class="nav-btn waves-effect waves-light" href="<spring:url value='/registration'/>">
						 					<spring:message code="registration"/>
						 				</a>
						 			</li>
						 		</c:when>
						 		
						 		<c:otherwise>
						 			<li>
							 			<a class="nav-btn waves-effect waves-light" href="<spring:url value='/disconnect'/>">
						 					<spring:message code="disconnect"/>
						 				</a>
						 			</li>
						 			<li>
						 				<spring:message code="connectedAs"/> : <span style="color:blue;">${currentUserConnection.idUser} </span>
						 			</li>						 		
						 		</c:otherwise>
						 	</c:choose>
				 		<li>
				 			<a class="nav-btn waves-effect waves-light" href="<spring:url value='/option'/>">
						 		<spring:message code="option"/>
						 	</a>
				 		</li>
				 		
				 		<li>
				 			<a class="nav-btn waves-effect waves-light" href="<spring:url value='/society'/>">
				 			<spring:message code="society"/>
				 			</a>
				 		</li>
				 				
				 	</ul>
				 	<ul class="side-nav" id="nav-mobile" >
				 		<li><a href="#">Lien1</a></li>
				 		<li><a href="#">Lien2</a></li>
				 		<li><a href="#">Lien3</a></li>
				 		<li><a href="#"><spring:message code="choiceLanguage"/></a></li>
				 	</ul>				 					 
				</div>
			</nav>
			
		</header>

		<main>
			<tiles:insertAttribute name="main-content"/>
		</main>
		
				
		<footer class="page-footer red z-depth-5">
			<div class="container">
				<div class="row">
					<div class="col l6 s12">
						<h5>
							<spring:message code="damienLouis"/>
						</h5>
					</div>
					<div class="col l4 offset-l2 s12">
						<h5 class="black-text">
							<spring:message code="link"/>
						</h5>
						<ul>
							<li><a>Facebook</a></li>
							<li><a>Twitter</a></li>
							<li><a href="<spring:url value='/society'/>"><spring:message code="society"/></a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="footer-copyright">
            	<div class="container">
	           	 2016 Copyright Henallux LouisDamien
	            	<a class="grey-text text-lighten-4 right" href="#!">
	            		<spring:message code="moreLink"/>
	            	</a>
            	</div>
          	</div>
		</footer>
	</body>
	
</html>