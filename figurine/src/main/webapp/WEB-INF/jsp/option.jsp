<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>


<html>

	<head>
		<title><spring:message code="option"/></title>
	</head>
	
	<body>
	
	<div class="container"> 
		<spring:url var="localeEn" value="">
			<spring:param name="locale" value="en"/>
		</spring:url>
		<spring:url var="localeFr" value="">
			<spring:param name="locale" value="fr"/>
		</spring:url>
	</div>	
	
	<div class="whiteCard card container" style="width:400px;">
	  	<div class="row">
	   	<div class="col s12"> 
	   		<ul class="collection">
	     		<li class="collection-item"><a href="${localeFr}"><img class="responsive-img " src="<spring:url value='/images/francais.png' />" height="30px" width="30px"><span class="right languageMessage"><spring:message code="changeLanguageFR"/></span></a></li>
	     		<li class="collection-item"><a href="${localeEn}"><img class="responsive-img " src="<spring:url value='/images/anglais.png'  />" height="30px" width="30px"><span class="right languageMessage" ><spring:message code="changeLanguageEN"/></span></a></li>     
	    	</ul>
	   	</div>
	  	</div>     
	</div>
	
	
		
	</body>
	
</html>