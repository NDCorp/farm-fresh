<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- SHARED NAV BAR -->
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark-custom ftco-navbar-light" id="ftco-navbar">
  <%
  	//Get username from session if exist
  	String userName = "";
  	if(session.getAttribute("username") != null)
  		userName = (String) session.getAttribute("firstname");
  %>
  
  <div class="container">
    <a class="navbar-brand" href="index.html">
      <!-- Logo must be changed, Ref from: https://pngtree.com/freepng/farm_733892.html -->
      <img src="${images}/logo_transp.png" alt="Logo">
      <span>[PlatformName]</span>
    </a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="oi oi-menu"></span> Menu
    </button>

    <div class="collapse navbar-collapse" id="ftco-nav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active"><a href="${contextRoot}/index.html" class="nav-link">Home</a></li>
        <li class="nav-item"><a href="${contextRoot}/farmers.html" class="nav-link">Farmers</a></li>
        <li class="nav-item"><a href="#section-menu" class="nav-link">Produce</a></li>
        <li class="nav-item"><a href="#section-news" class="nav-link">Featured</a></li>
        <li class="nav-item"><a href="${contextRoot}/contact.html" class="nav-link">Contact</a></li>
      </ul>
    </div>
  </div>

  <div class="container-search-user-cart">
      <i id="searchOption" class="fas fa-search" title="Search"></i>
          
      <!--<a href="buyer.html">-->
      <i id="userOption" class="fas fa-user" title="User"></i>
      <!--</a>-->
      
      <a href="buyer.html">
        <i class="fas fa-shopping-cart" title="Shopping cart"></i>
      </a>

      <div id="menuSearch">
        <form action=""  method="post" autocomplete="off">
          <input type="text" name="menuSearch" value="" placeholder="Search">
          <!--<button type="submit" name="submit">Search</button>-->
        </form>
      </div>

      <div id="userAccount">
      	<div>user name: <%=userName %></div>
      	
      	  <c:set var="uName" scope="session" value="<%=userName %>"/>
      	  <c:if test="{not empty <%=userName %>}">
	          <div class="create-user-left-side"><a href="#">User: <%=userName %></a></div>
	          <div class="create-user-left-side"><img src="images/icon.ico" class="px-1 py-1 w-50" alt="<%=userName %> picture"></div>
          </c:if>
          
          <c:choose>
          	<c:when test="${not empty uName}">
          		<div class="create-user-left-side"><a href="${contextRoot}/home" onclick="FB.logout();">Logout</a></div>
          	</c:when>
          	
          	<c:otherwise>
          		<div class="create-user-left-side"><a href="${contextRoot}/login">Login</a></div>
          	</c:otherwise>
          </c:choose>
      </div>
  </div><!-- END container-search-user-cart -->
</nav>
<!-- END nav -->
