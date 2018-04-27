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

						<script>
							window.categoryId = '';
						</script>
						<%-- <ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>&nbsp;/&nbsp;
							<li class="active">All Products</li>
						</ol> --%>
					</c:if>

					<c:if test="${userClickedCategoryProducts == true}">

						<script>
							window.categoryId = '${category.id}';
						</script>

						<%-- <ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>&nbsp;/&nbsp;
							<li class="active">Category</li>&nbsp;/&nbsp;
							<li class="active">${category.name}</li>
						</ol> --%>
					</c:if>
				</div>

			</div>

			<div class="row">
				<div class="col-xs-12">
					<table class="table table-striped table-borderd">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty</th>
								<th></th>
							</tr>
						</thead>
						
						<c:forEach items="${products}" var="list">
							<tfoot> 
								  <tr>
								  		<td><a href="${contextRoot}/show/${list.id}/product"><img src="${images}/${list.code}.jpg" style="width:100px; height: 100px;"></a></td>
									    <td>${list.name}</td>
									    <td>${list.description}</td>
									    <td>${list.unitPrice}</td>
									    <td>${list.quantity}</td>
								  </tr>
							 </tfoot>
						</c:forEach>

					</table>
				</div>

			</div>
		</div>

	</div>

</div>