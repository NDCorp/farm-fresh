<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<!-- 
    More Templates Visit ==> Free-Template.co
    -->
<title>Farm Fresh - ${title}</title>
<script>
		window.menu = '${title}';
		window.contextRoot = '${contextRoot}'; 
	</script>
<!-- Icon must be changed, Ref from: https://pngtree.com/freepng/farm_733892.html -->
<link type="image/x-icon" rel="icon" href="${images}/icon.ico">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Free Template by Free-Template.co Custoomized for Capstone project - Conestoga College" />
<meta name="keywords"
	content="free bootstrap 4, free bootstrap 4 template, free website templates, free html5, free template, free website template, html5, css3, mobile first, responsive" />
<meta name="author"
	content="Free-Template.co Custoomized for Capstone project - Conestoga College" />
<link rel="stylesheet" href="${css}/style.css">


<script type="text/javascript" src="${js}/jquery.min.js"></script>
<script type="text/javascript" src="${js}/popper.min.js"></script>
<script type="text/javascript" src="${js}/bootstrap.min.js"></script>

<script type="text/javascript" src="${js}/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${js}/jquery.waypoints.min.js"></script>
<script type="text/javascript" src="${js}/owl.carousel.min.js"></script>
<script type="text/javascript" src="${js}/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="${js}/jquery.animateNumber.min.js"></script>

<script type="text/javascript" src="${js}/custom.js"></script>
<script type="text/javascript" src="${js}/main.js"></script>
<script type="text/javascript" src="${js}/google-map.js"></script>

<link rel="stylesheet" href="${css}/gfont-oswald.css">
<link rel="stylesheet" href="${css}/gfont-playfair.css">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet"
	href="${css}/fontawesome/css/fontawesome-all.min.css">
<link rel="stylesheet" href="${css}/open-iconic-bootstrap.min.css">

<link rel="stylesheet" href="${css}/owl.theme.default.min.css">
<link rel="stylesheet" href="${css}/owl.carousel.min.css">
<link rel="stylesheet" href="${css}/magnific-popup.css">
<link rel="stylesheet" href="${css}/bootstrap-datepicker.css">
<link rel="stylesheet" href="${css}/jquery.timepicker.css">

<link rel="stylesheet" href="${css}/custom.css">
<link rel="stylesheet" href="${css}/icomoon.css">
<link rel="stylesheet" href="${css}/animate.css">

</head>

<body data-spy="scroll" data-target="#ftco-navbar" data-offset="200">

	<div class="wrapper">

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>
		</nav>

		<!-- Page Content -->
		<div class="content">

			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr />
							<blockquote style="word-wrap:break-word">${errorDescription}</blockquote>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
	</div>
</body>

</html>
