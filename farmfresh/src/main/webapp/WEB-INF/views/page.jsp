<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


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
	</script>
    <!-- Icon must be changed, Ref from: https://pngtree.com/freepng/farm_733892.html -->
    <link type="image/x-icon" rel="icon" href="${images}/icon.ico">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Free Template by Free-Template.co Custoomized for Capstone project - Conestoga College" />
    <meta name="keywords" content="free bootstrap 4, free bootstrap 4 template, free website templates, free html5, free template, free website template, html5, css3, mobile first, responsive" />
    <meta name="author" content="Free-Template.co Custoomized for Capstone project - Conestoga College" />

    <link rel="stylesheet" href="${css}/style.css">

    <!-- jQuery, Custom js, and Bootstrap js -->
    <!--
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.0/jquery.waypoints.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-animateNumber/0.0.14/jquery.animateNumber.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script type="text/javascript" src="${js}/custom.js"></script>
    <script type="text/javascript" src="${js}/main.js"></script>
    <script type="text/javascript" src="${js}/google-map.js"></script> 
	-->

    <!-- To remove if remote links works properly -->   
     
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
    
    
    <!-- To remove if remote links work properly -->

    <!-- Google fonts, Bootstrap, Custom CSS -->
    <!-- 
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700|Raleway" rel="stylesheet">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" integrity="sha384-VY3F8aCQDLImi4L+tPX4XjtiJwXDwwyXNbkH7SHts0Jlo85t1R15MlXVBKLNx+dj" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-timepicker/1.10.0/jquery.timepicker.min.css" />
    <link rel="stylesheet" href="${css}/icomoon.css">
    <link rel="stylesheet" href="${css}/custom.css">
    <link rel="stylesheet" href="${css}/animate.css">
    -->
    
    <!-- To remove if remote links works properly -->
   
    <link rel="stylesheet" href="${css}/gfont-oswald.css">
    <link rel="stylesheet" href="${css}/gfont-playfair.css">
    <link rel="stylesheet" href="${css}/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/fontawesome/css/fontawesome-all.min.css">
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

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Navigation if needed -->

		<!-- Page Content -->
		<div class="content">

			<!-- Load when you clicked Home -->
			<c:if test="${userClickedHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load when you click Login -->
			<c:if test="${userClickedLogin == true}">
				<%@include file="login.jsp"%>
			</c:if>
			
			<!-- Load when you click Farmers -->
			<c:if test="${userClickedFarmers == true}">
				<%@include file="farmers.jsp"%>
			</c:if>

			<!-- Load when you click Buyers -->
			<c:if test="${userClickedBuyers == true}">
				<%@include file="buyers.jsp"%>
			</c:if>

			<!-- Load when you click OrderHistory -->
			<c:if test="${userClickedOrderHistory == true}">
				<%@include file="orderHistory.jsp"%>
			</c:if>
												
			<!-- Load when you click About -->
			<c:if test="${userClickedAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load when you click Contact -->
			<c:if test="${userClickedContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Load when you click Contact -->
			<c:if test="${userClickedAllProducts == true or userClickedCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>


		<!-- Bootstrap core JavaScript -->
		<!-- <script src="${js}/jquery.js"></script> -->
		<!-- <script src="${js}/bootstrap.bundle.min.js"></script> -->

		<!-- Custom Javascript -->
		<!-- <script src="${js}/myapp.js"></script> -->

	</div>
	
	<!-- loader SVG -->
    <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>  
</body>

</html>
