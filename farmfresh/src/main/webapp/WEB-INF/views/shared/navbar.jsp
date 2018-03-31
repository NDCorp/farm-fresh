
<!-- SHARED NAV BAR -->
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark-custom ftco-navbar-light" id="ftco-navbar">
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
      <a href="${contextRoot}/buyers.html">
        <i class="fas fa-user" title="User"></i>
      </a>
      <a href="${contextRoot}/buyers.html">
        <i class="fas fa-shopping-cart" title="Shopping cart"></i>
      </a>

      <div id="menuSearch">
        <form asp-controller="" asp-action=""  method="post" autocomplete="off">
          <input type="text" name="menuSearch" value="" placeholder="Search">
          <!--<button type="submit" name="submit">Search</button>-->
        </form>
      </div>
  </div><!-- END container-search-user-cart -->
</nav>
<!-- END nav -->
