<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Julia's and Joseph's work. -->
<section class="ftco-section" id="section-gallery">
	<div>${requestScope.message}</div>
	
  <!--CreateProduce & CreatePackage buttons-->		  
  <div class="container">
    <div class="row ftco-custom-gutters mb-4">
      <div class="col-md-12">
        <p id="lnkMyProducts" class="col-md-6 d-inline-block">
        	<a href="farmers.html">
	        	<c:if test="${not empty uName}">
	        		${uName} Produce
	        	</c:if>
	        	<c:if test="${empty uName}">
	        		Produce
	        	</c:if>
        	</a>
        </p> 
      
        <div class="dropdown col-md-5 d-inline-block text-right">
          <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort By
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
            <li><a class="variableforSorting" href="sortingByName">Name</a></li>
            <li><a class="variableforSorting" href="sortingByDate">Date</a></li>
            <li><a class="variableforSorting" href="sortingByPrice">Price</a></li>       
          </ul>
        </div>
      </div>
    </div>

    <div class="row ftco-custom-gutters">
      <!-- Button -->
      <div class="col-md-8 d-inline-block mx-1">
        <p class="col-md-4 d-inline-block mx-1">
          <a href="#" target="_blank" class="btnCreateProduce btn ftco-animate" data-toggle="modal" data-target="#createProduceModal">Create a new Produce</a>
        </p>

        <p class="col-md-4 d-inline-block mx-1">
          <a href="#" target="_blank" class="btnCreateProduce btn ftco-animate" 
          		data-toggle="modal" data-target="#createPackageModal">Create a new Package</a>
        </p>   
        <p class="col-md-3 d-inline-block mx-1">
			<a href="#" target="_blank" class="btnCreateProduce btn ftco-animate"
				data-toggle="modal" data-target="#editInfoModal">Edit Information</a>
		</p>         
      </div>
      <!-- Search -->
      <div id="farmerSearchOfProducts" class="col-md-3 d-inline-block m-1 text-right">
        <form data-ng-controller="" action="" method="post" autocomplete="on">
          <input type="text" name="farmerSearch" id="farmerSearch" placeholder="Search" />				
        </form>                 
      </div>
    </div>

    <!--link to MyProducts-->  
    <div class="row ftco-custom-gutters mx-2">     
      <!-- Add Div: data-ng-controller="" action="ManageProduct" -->
      <div class="col-md-12 text-center">
      
      	  <c:if test="${empty produces}">
      	  	<h4>You don't have any produce in the system. Please create some produce.</h4>
      	  </c:if>
      	  
	      <c:forEach items="${produces}" var="produce">
		      <div class="col-md-3 mx-1 my-4 d-inline-block product">	
		         <img class="mx-1 my-3 productPhoto" src="${images}/menu_1.jpg" alt="[ALT_PRODUCE_PIC]">		
		         <!--
		        <c:forEach items="${pictures}" var="picture">
		        	<img class="mx-1 my-3 productPhoto" src="${pictPathDir}/${picture.picture}" alt="${picture.alternateText}">	
		        	
		        </c:forEach>
		        -->
		        <hr class="line"/>
		        <div class="productForm">
		          <h3>
		            ${produce.name}
		            <span class="d-block my-2">$ ${produce.unitPrice}</span>
		          </h3>
		          <p class="px-1 py-3">
		          	${produce.description}
		          </p>			
		  
		          <div class="mx-1 my-3">
		            <a href="#editProduct" >Edit Product</a> || 
		            <a href="#deleteProduct">Delete Product</a>  
		          </div>
		
		        </div>
		      </div><!-- END Procude 1 -->
		  </c:forEach>
		  
	      
      </div>
    </div>
  </div>
</section>
<!-- END section --> 


<!-- createProduceModal: MODAL FORM -->
<div class="modal fade" id="createProduceModal" tabindex="-1" role="dialog" aria-labelledby="createProduceModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-body p-0">
        <div class="row">

          <div class="col-lg-12 p-5">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <small>CLOSE </small><span aria-hidden="true">&times;</span>
            </button>
            <h1 class="mb-4">Create a new Produce</h1>  
            <form id="CreateProduceForm" action="createproduce" method="post" enctype="multipart/form-data">                 
                <div class="row">
                    <div class="col-md-12 form-group">
                        <label for="m_prodpicture">Upload your produce's pictures here (PNG, JPG)</label>
                        <!-- *** Need a JS or .Net method to resize pictures -->
                        <input type="file" class="form-control" name="m_prodpicture" id="m_prodpicture" accept="image/png, image/jpeg, image/jpg" multiple></input>
                    </div>
                </div>		

                <!-- Only for produce -->
                <fieldset class="my-2">
                  <legend>Produce Type</legend>
                  <div class="row">
                    <div class="col-md-6 form-group">
                      <!-- Build list -->
                      <label for="prodCat">Categories:</label>
                      <select name="select-pcat" id="prodCat" class="form-control" required>
                      	<option value=""></option>
                        <c:forEach items="${categories}" var="category">
                        	<option value="${category.id}">${category.name}</option>
                        </c:forEach>
                      </select>
                    </div>
                
                    <div class="col-md-6 form-group">
                      <!-- Build list -->
                      <label for="prodType">Produce Type:</label>
                      <select name="select-ptype" id="prodType" class="form-control" required>
                      	  <option value=""></option>
                          <c:forEach items="${produceTypes}" var="produceType">
                        	<option value="${produceType.id}">${produceType.name}</option>
                          </c:forEach>
                      </select>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12 form-group">
                      <!-- Build list -->
                      <label for="prodProdType">Production Type:</label>
                      <select name="select-pptype" id="prodProdType" class="form-control" >
                          <option value=""></option>
                          <c:forEach items="${productionTypes}" var="productionType">
                        	<option value="${productionType.id}">${productionType.name}</option>
                          </c:forEach>
                        </select>
                    </div>
                  </div>
                </fieldset>

                <!-- Generic fields: for produce and packs -->
                <fieldset class="my-2">
                  <legend>Produce</legend>
                  <div class="row">
                    <div class="col-md-12 form-group">
                      <label for="prodName">Name:</label>
                      <input type="text" name="prodName" id="prodName" class="form-control" required>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 form-group">
                      <label for="prodQty">Quantity:</label>
                      <input type="number" step="0.01" name="prodQty" id="prodQty" class="form-control" required>
                    </div>
                  
                    <div class="col-md-6 form-group">
                      <label for="prodPrice">Price:</label>
                      <input type="number" step="0.01" name="prodPrice" id="prodPrice" class="form-control text-right" required>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12 form-group">
                      <label for="m_fproddesc">Description</label>
                      <textarea class="form-control" name="m_fproddesc" id="m_fproddesc" cols="40" rows="4"></textarea>
                    </div>
                  </div>
                </fieldset>
        
                <!-- Submit or reset -->
                <div class="row">
                  <div class="col-md-3 form-group">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Create">
                  </div>
                </div>
            </form>             
          </div>   

        </div>
      </div>
    </div>
  </div>
</div><!-- END createProduceModal: MODAL FORM -->  

<!-- createPackModal: MODAL FORM -->
<div class="modal fade" id="createPackageModal" tabindex="-1"
	role="dialog" aria-labelledby="createPackageModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body p-0">

				<div class="col-lg-12 p-5">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<small>CLOSE </small><span aria-hidden="true">&times;</span>
					</button>
					<h1 class="mb-4">Create a new Package</h1>
					<form id="createPackForm" action="createpack" method="post">
						<div class="row">
							<div class="col-md-12 form-group">
								<label class="" for="m_prodpicture">Upload your
									package's pictures here (PNG, JPG)</label>
								<!-- *** Need a JS or .Net method to resize pictures -->
								<input type="file" class="form-control" id="m_prodpicture"
									accept="image/png, image/jpeg, image/jpg" multiple>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="prodName">Name of a package:</label> <input
									type="text" id="prodName" class="form-control" required>
							</div>
						</div>

						<label for="m_items">[Your products]:</label>
						<div class="row">
							<div class="col-md-4 form-group ">
								<select name="items" id="m_items" class="dr_itemToPack" multiple
									size="4">
									<option value="item1">Item1</option>
									<option value="item2">Item2</option>
									<option value="item3">Item3</option>
									<option value="item3">Item4</option>
								</select>
							</div>
							<div class="col-md-4 form-group ">
								<button id="btnAddtoPack"
									class="btn btn-primary btn-lg btn-block">Add to Pack</button>
							</div>

							<div class="col-md-4 form-group">

								<select name="items" id="m_itemsInAPack" class="dr_itemToPack"
									multiple size="4">
									<option value="item1"></option>
									<option value="item2"></option>
									<option value="item3"></option>
									<option value="item3"></option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<label for="packQty">Quantity:</label> <input type="number"
									id="packQty" class="form-control" required>
							</div>

							<div class="col-md-6 form-group">
								<label for="prodPrice">Price:</label> <input type="number"
									id="prodPrice" class="form-control text-right" required>
							</div>
						</div>
						<div class="row">
							<label for="chboxProm">Promotion:</label> <input type="checkbox"
								id="chboxProm" class="checkbox style-2 pull-right"
								checked="checked" />
						</div>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="m_fdescription">Description</label>
								<textarea class="form-control" id="m_fdescription" cols="40"
									rows="5"></textarea>
							</div>
						</div>

						<!--Submit or reset -->
						<div class="row">
							<div class="col-md-3 form-group">
								<input type="submit" class="btn btn-primary btn-lg btn-block"
									value="Create">
							</div>
							<div class="col-md-3 form-group">
								<input type="reset" class="btn btn-primary btn-lg btn-block"
									value="Reset">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div><!-- END createPackModal: MODAL FORM -->

<!--Edit Account Info: MODAL FORM  -->
<div class="modal fade" id="editInfoModal" tabindex="-1" role="dialog" aria-labelledby="editInfoModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body p-0">

				<div class="col-lg-12 p-5">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<small>CLOSE </small><span aria-hidden="true">&times;</span>
					</button>
					<h1 class="mb-4">Edit Account Information</h1>
					<legend>Farmer</legend>
					<form asp-controller="" asp-action="#" method="post">
						<div class="row">
							<div class="col-md-12 form-group">
								<label class="" for="m_farmerpicture">Upload your
									pictures here (PNG, JPG)</label>
								<!-- *** Need a JS or .Net method to resize pictures -->
								<input type="file" class="form-control" id="m_farmerpicture"
									accept="image/png, image/jpeg, image/jpg">
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<input type="text" class="form-control" value="Yuliia"
									placeholder="First Name" id="m_fname" required>
							</div>
							<div class="col-md-6 form-group">
								<input type="text" class="form-control" value="Murziak"
									placeholder="Last Name" id="m_lname" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<input type="text" class="form-control" value=""
									placeholder="Middle Name" id="m_mname">
							</div>
						</div>
						<!-- Email and Phone -->
						<div class="row">
							<div class="col-md-6 form-group">
								<label for="m_email">Email</label> <input type="email"
									class="form-control" id="m_email" value="murzia4ka@gmail.com"
									required>
							</div>
							<div class="col-md-6 form-group">
								<label for="m_phone">Phone</label> <input type="text"
									class="form-control" value="+1(519)-722-7914" id="m_phone">
							</div>
						</div>
						<legend>Specific Information</legend>
						<div class="row">
							<div class="col-md-4 form-group">
								<!-- Build list -->
								<label for="farmerPosition">Position:</label> <select
									name="select-farmerPosition" id="farmerPosition"
									class="form-control" size="2" required>
									<option value="">Manager</option>
									<option value="" selected>Administrator</option>

								</select>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 form-group">
								<label for="m_website">Web Site URL:</label> <input type="url"
									class="form-control" id="m_website">
							</div>
						</div>
						<legend>Farm</legend>
						<div class="row">
							<div class="col-md-12 form-group">
								<label class="" for="m_farmpicture">Upload your pictures
									here (PNG, JPG)</label>
								<!-- *** Need a JS or .Net method to resize pictures -->
								<input type="file" class="form-control" id="m_farmpicture"
									multiple accept="image/png, image/jpeg, image/jpg">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="m_fname">Farm Name</label> <input type="text"
									class="form-control" value="Happy Farm" id="m_fname">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="m_fheadline">Head Line</label> <input type="text"
									class="form-control" id="m_fheadline">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="m_fdescription">Description</label>
								<textarea class="form-control" id="m_fdescription" cols="40"
									rows="5">Farm farm farm</textarea>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4 form-group">
								<input type="submit" class="btn btn-primary btn-lg btn-block"
									id="btnSave" value="Save">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div><!-- END Edit Account Info: MODAL FORM  -->
