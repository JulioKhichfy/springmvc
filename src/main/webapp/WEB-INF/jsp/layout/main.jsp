<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />


<link href='<spring:url value="/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>' rel="stylesheet" />


<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet" />

<!-- Custom fonts for this template -->

<link href='<spring:url value="/resources/css/simple-line-icons/css/simple-line-icons.css"/>' rel="stylesheet" />
<!-- Plugin CSS -->
<link href='<spring:url value="/resources/css/font-awesome/css/font-awesome.css"/>' rel="stylesheet" />
<link href='<spring:url value="/resources/css/device-mockups/device-mockups.css"/>' rel="stylesheet" />
<link href='<spring:url value="/resources/css/custom.css"/>' rel="stylesheet" />
<link href='<spring:url value="/resources/css/new-age.min.css"/>' rel="stylesheet" />
<link href='<spring:url value="/resources/css/julio.css"/>' rel="stylesheet" />
<link href='<spring:url value="/resources/css/lightbox.css"/>' rel="stylesheet" />

</head>

<body id="page-top">
<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />

	<div>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>

<script type="text/javascript" src='<spring:url value="/webjars/jquery/3.3.1/dist/jquery.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/webjars/jquery.easing/1.4.1/jquery.easing.min.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/webjars/bootstrap/4.1.1/js/bootstrap.min.js"/>'></script>	

<script type="text/javascript" src='<spring:url value="/resources/js/new-age.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/lightbox.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/custom.js"/>'></script>
	
	

	
	
	<script>
		lightbox.option({
		
			'fitImagesInViewport' : true
			
		})
	</script>	
</body>
</html>