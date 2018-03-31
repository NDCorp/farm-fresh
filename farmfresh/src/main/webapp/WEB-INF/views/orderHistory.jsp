<!-- Content -->	
<section class="ftco-section"> 
    <div class="container">
        <div class="row ftco-custom-gutters mb-4">
            <!-- User name -->
            <div class="col-md-12">
                <p id="lnkMyProducts" class="col-md-6"><a href="${contextRoot}/buyers.html">Joseph Kasumba</a></p> 
                <p id="lnkMyProducts" class="col-md-6 px-4"><a href="${contextRoot}/orderHistory.html">Order History</a></p> 
            </div>

            <!-- List of orders -->
            <!-- Loop to see all orders made by the buyer -->
            <div class="col-md-12 my-4">
                <table class="table table-striped cart-items-table">
                    <thead>
                        <tr>
                            <th scope="col">Number</th>
                            <th scope="col">Qty</th>
                            <th scope="col">Total Price</th>
                            <th scope="col">Status</th>
                            <th scope="col">Ordered on</th>
                            <th scope="col">Options</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>123456</td>
                            <td>7</td>
                            <td>300.99</td>
                            <td>Closed</td>
                            <td>2018/03/29</td>
                            <td>
                                <a href="#" target="_blank" class="btnTable" data-toggle="modal" data-target="#orderDetailsModal">
                                    <i class="fas fa-info-circle" title="Details"></i>
                                </a>
                                <a href="#" target="_blank" class="btnTable" data-toggle="modal" data-target="#reOrderModal">
                                    <i class="fas fa-registered" title="Re-order"></i>
                                    <!--<i class="fas fa-redo-alt" title="Re-order"></i>-->
                                </a>
                                <a href="#" target="_blank" class="btnTable" data-toggle="modal" data-target="#evaluationModal">
                                    <i class="fas fa-pen-square" title="Evaluate"></i>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>123456</td>
                            <td>7</td>
                            <td>300.99</td>
                            <td>Closed</td>
                            <td>2018/03/29</td>
                            <td>
                                <a href="#" target="_blank" class="btnTable" data-toggle="modal" data-target="#orderDetailsModal">
                                    <i class="fas fa-info-circle" title="Details"></i>
                                </a>
                                <a href="#" target="_blank" class="btnTable" data-toggle="modal" data-target="#reOrderModal">
                                    <i class="fas fa-registered" title="Re-order"></i>
                                    <!--<i class="fas fa-redo-alt" title="Re-order"></i>-->
                                </a>
                                <a href="#" target="_blank" class="btnTable" data-toggle="modal" data-target="#evaluationModal">
                                    <i class="fas fa-pen-square" title="Evaluate"></i>
                                </a>
                           </td>
                       </tr>
                   </tbody>           
               </table>
           </div>

       </div>  
   </div>
</section>
<!-- ********** END content ********** -->


<!-- **************** Modals ******************** -->
<!-- Modal orderDetails -->
<div class="modal fade" id="orderDetailsModal" tabindex="-1" role="dialog" aria-labelledby="orderDetailsModal" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12 p-2">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <small>CLOSE </small><span aria-hidden="true">&times;</span>
                        </button>
                        <h1 class="mb-4">Order Details</h1> 

                        <div class="col-md-12">
                            Details for order number:
                            <a href="#"><strong>[OrderID]</strong></a>
                        </div>

                        <!-- List of details for the order selected -->
                        <!-- Loop to see all details about a specific order -->
                        <div class="col-md-12 my-4">
                            <table class="table table-striped cart-items-table">
                                <thead>
                                    <tr>
                                        <th scope="col">Item</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Qty of items</th>
                                        <th scope="col">U. Price</th>
                                        <th scope="col">Total price</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Note</th> 
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>456</td>
                                        <td>Oranges</td>
                                        <td>5</td>
                                        <td>$ 0.99</td>
                                        <td>$ 3.50</td>
                                        <td>Closed</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>456</td>
                                        <td>Oranges</td>
                                        <td>5</td>
                                        <td>$ 0.99</td>
                                        <td>$ 3.50</td>
                                        <td>Closed</td>
                                        <td></td>
                                    </tr>
                                </tbody>           
                            </table>
                        </div><!-- END table --> 

                        <div class="row">
                            <div class="col-md-12 mx-4 my-2 px-4 py-2">
                                <button class="btn btn-primary" type="button">Print</button>
                            </div>
                        </div><!-- END Print -->

                    </div>                       
                </div>
            </div>
        </div>
    </div>
</div><!-- END Modal orderDetails -->

<!-- Modal Re-order -->
<div class="modal fade" id="reOrderModal" tabindex="-1" role="dialog" aria-labelledby="reOrderModal" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12 p-2">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <small>CLOSE </small><span aria-hidden="true">&times;</span>
                        </button>
                        <h1 class="mb-4">Re-order</h1> 

                        <div class="col-md-12">
                            Confirm if you really want to replace this order:
                            <a href="#"><strong>[OrderID]</strong></a>
                        </div>

                        <!-- List of details for the order selected -->
                        <!-- Loop to see all details about a specific order -->
                        <div class="col-md-12 my-4">
                                <table class="table table-striped cart-items-table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Item</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Qty of items</th>
                                            <th scope="col">U. Price</th>
                                            <th scope="col">Total price</th>
                                            <th scope="col">Status</th>
                                            <th scope="col">Note</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>456</td>
                                            <td>Oranges</td>
                                            <td>5</td>
                                            <td>$ 0.99</td>
                                            <td>$ 3.50</td>
                                            <td>Closed</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>456</td>
                                            <td>Oranges</td>
                                            <td>5</td>
                                            <td>$ 0.99</td>
                                            <td>$ 3.50</td>
                                            <td>Closed</td>
                                            <td></td>
                                        </tr>
                                    </tbody>           
                                </table>
                            </div><!-- END table --> 
                        
                            <div class="row">
                                <div class="col-md-12 mx-4 my-2 px-4 py-2">
                                    <button class="btn btn-primary" type="button">Confirm re-order</button>
                                </div>
                            </div><!-- END Print -->
                    </div>                       
                </div>
            </div>
        </div>
    </div>
</div><!-- END Modal Re-order -->
    
<!-- Modal evaluations: to give feedback, evaluation for one specific order -->
<!-- *** Another page must list all existing evaluations with option to publish or unpublish Only for admin.
    Plus a button to create a new evaluation. This button will redirect to order history select an order
    to evaluate. Then the modal will open to write a new for this order evaluation form for this order -->
    <div class="modal fade" id="evaluationModal" tabindex="-1" role="dialog" aria-labelledby="evaluationModal" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12 p-2">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <small>CLOSE </small><span aria-hidden="true">&times;</span>
                            </button>
                            <h1 class="mb-4">Evaluations</h1> 


                            
                        </div>                       
                    </div>
                </div>
            </div>
        </div>
    </div><!-- END evaluations -->
    
<!-- **************** END Modals ******************** -->
