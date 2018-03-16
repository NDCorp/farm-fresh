<div class="container">

	<div class="row">

		<!-- would be to display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- to display actuals products -->
		<div class="col-md-9">
			<!-- Added bredcrum component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickedAllProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>&nbsp;/&nbsp; 
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickedCategoryProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>&nbsp;/&nbsp;
							<li class="active">Category</li>&nbsp;/&nbsp;
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>

			</div>
		</div>

	</div>

</div>