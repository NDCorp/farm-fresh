<!-- SHARED COVER -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="ftco-cover" style="background-image: url(${images}/bg_3.jpg);" id="section-home">
  <div class="container">   
    <div class="row align-items-center justify-content-center text-center ftco-vh-100">
      <div class="col-md-12">
        <h1 class="ftco-heading ftco-animate mb-3">Welcome To [PlatformName]</h1>
        <h2 class="h5 ftco-subheading mb-5 ftco-animate">[PlatformDescription]
          <!--<a href="#" target="_blank">[PlatformName]</a>-->
        </h2>

        <!-- Call hidden modals located in the bottom of this page -->
        <p class="d-inline-block">
          <a href="#section-home" class="btn btn-outline-white btn-lg ftco-animate">Shop online</a>
        </p>   
        <p class="d-inline-block">
	        <c:set var="uName" scope="session" value='<%=(String) session.getAttribute("username") %>'/>
			<c:choose>
				<c:when test="${not empty uName}">
					<a href="${contextRoot}/logout" class="btn btn-outline-white btn-lg ftco-animate" onclick="FB.logout();">Log out</a>
				</c:when>
				
				<c:otherwise>
					<a href="${contextRoot}/login" class="btn btn-outline-white btn-lg ftco-animate">Log in</a>
				</c:otherwise>
			</c:choose>
          
            <!-- <a href="${contextRoot}/login" class="btn btn-outline-white btn-lg ftco-animate">Log in</a> -->
        </p>

      </div>
    </div>
  </div>
</section>
<!-- END Home Cover section -->