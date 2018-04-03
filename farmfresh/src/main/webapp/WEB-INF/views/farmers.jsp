
<!-- Julia's and Joseph's work. -->
<section class="ftco-section" id="section-gallery">
  <!--CreateProduce & CreatePackage buttons-->		  
  <div class="container">
    <div class="row ftco-custom-gutters mb-4">
      <div class="col-md-12">
        <p id="lnkMyProducts" class="col-md-6 d-inline-block"><a href="farmers.html">My Produce</a></p> 
      
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
          <a href="#" target="_blank" class="btnCreateProduce btn ftco-animate" data-toggle="modal" data-target="#createPackageModal">Create a new Package</a>
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
      <div class="col-md-3 mx-1 my-4 d-inline-block product">	
        <img class="mx-1 my-3 productPhoto" src="${images}/menu_1.jpg" alt="[ALT_PRODUCE_PIC]">		
        <hr class="line"/>
        <div class="productForm">
          <h3>
            Apple Green
            <span class="d-block my-2">$ 22.5</span>
          </h3>
          <p class="px-1 py-3">Yet bed any for travelling assistance indulgence unpleasing. 
            Not thoughts all exercise blessing. Indulgence way everything
            joy alteration boisterous the attachment. Party we years to order 
            allow asked of.
          </p>			
  
          <div class="mx-1 my-3">
            <a href="#editProduct" >Edit Product</a> || 
            <a href="#deleteProduct">Delete Product</a>  
          </div>

        </div>
      </div><!-- END Procude 1 -->

      <div class="col-md-3 mx-1 my-4 d-inline-block product">	
        <img class="mx-1 my-3 productPhoto" src="${images}/menu_1.jpg" alt="[ALT_PRODUCE_PIC]">		
        <hr class="line"/>
        <div class="productForm">
          <h3>
            Apple Green
            <span class="d-block my-2">$ 22.5</span>
          </h3>
          <p class="px-1 py-3">Yet bed any for travelling assistance indulgence unpleasing. 
            Not thoughts all exercise blessing. Indulgence way everything
            joy alteration boisterous the attachment. Party we years to order 
            allow asked of.
          </p>			
  
          <div class="mx-1 my-3">
            <a href="#editProduct" >Edit Product</a> || 
            <a href="#deleteProduct">Delete Product</a>  
          </div>

        </div>
      </div><!-- END Procude 2 -->

      <div class="col-md-3 mx-1 my-4 d-inline-block product">	
          <img class="mx-1 my-3 productPhoto" src="${images}/menu_1.jpg" alt="[ALT_PRODUCE_PIC]">		
          <hr class="line"/>
          <div class="productForm">
            <h3>
              Apple Green
              <span class="d-block my-2">$ 22.5</span>
            </h3>
            <p class="px-1 py-3">Yet bed any for travelling assistance indulgence unpleasing. 
              Not thoughts all exercise blessing. Indulgence way everything
              joy alteration boisterous the attachment. Party we years to order 
              allow asked of.
            </p>			
    
            <div class="mx-1 my-3">
              <a href="#editProduct" >Edit Product</a> || 
              <a href="#deleteProduct">Delete Product</a>  
            </div>

          </div>
        </div><!-- END Procude 3 -->
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
            <form asp-controller="" asp-action="#" method="post">                 
                <div class="row">
                    <div class="col-md-12 form-group">
                        <label for="m_prodpicture">Upload your produce's pictures here (PNG, JPG)</label>
                        <!-- *** Need a JS or .Net method to resize pictures -->
                        <input type="file" class="form-control" id="m_prodpicture" accept="image/png, image/jpeg, image/jpg" multiple></input>
                    </div>
                </div>		

                <!-- Only for produce -->
                <fieldset class="my-2">
                  <legend>Produce Type</legend>
                  <div class="row">
                    <div class="col-md-6 form-group">
                      <!-- Build list -->
                      <label for="prodCat">[Load Produce Categories]:</label>
                      <select name="select-pcat" id="prodCat" class="form-control" required>
                        <option value=""></option>
                        <option value="">Vegetables</option>
                        <option value="">Fruits</option>
                        <option value="">Meat</option>
                      </select>
                    </div>
                
                    <div class="col-md-6 form-group">
                      <!-- Build list -->
                      <label for="prodType">[Load Type relative to the Category]:</label>
                      <select name="select-ptype" id="prodType" class="form-control" required>
                          <option value=""></option>
                          <option value="">Tomatoes</option>
                          <option value="">Apples</option>
                          <option value="">Oranges</option>
                        </select>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12 form-group">
                      <!-- Build list -->
                      <label for="prodProdType">[Load Produce Production Type]:</label>
                      <select name="select-pptype" id="prodProdType" class="form-control" >
                          <option value=""></option>
                          <option value="">OGM</option>
                          <option value="">Natural</option>
                        </select>
                    </div>
                  </div>
                </fieldset>

                <!-- Generic fields: for produce and packs -->
                <fieldset class="my-2">
                  <legend>Produce</legend>
                  <div class="row">
                    <div class="col-md-12 form-group">
                      <label for="prodName">Name of a product:</label>
                      <input type="text" id="prodName" class="form-control" required>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 form-group">
                      <label for="prodQty">Quantity:</label>
                      <input type="number" id="prodQty" class="form-control" required>
                    </div>
                  
                    <div class="col-md-6 form-group">
                      <label for="prodPrice">Price:</label>
                      <input type="number" id="prodPrice" class="form-control text-right" required>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12 form-group">
                      <label for="m_fproddesc">Description</label>
                      <textarea class="form-control" id="m_fproddesc" cols="40" rows="4"></textarea>
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
</div>
<!-- createProduceModal: MODAL FORM -->  