<!-- Content -->
<section class="ftco-section"> 
    <div class="container">
        <div class="row ftco-custom-gutters mb-4">
            <!-- User name -->
            <div class="col-md-12">
                <p id="lnkMyProducts" class="col-md-6 d-inline-block"><a href="${contextRoot}/buyers.html">Joseph Kasumba</a></p> 
            </div>
            
            <!-- Button Options -->
            <div class="col-md-12">
                <p class="col-md-4 d-inline-block mx-1">
                    <a href="#" target="_blank" class="btnCreateProduce btn ftco-animate" data-toggle="modal" data-target="#editUserInfoModal">Edit user information</a>
                </p>

                <p class="col-md-4 d-inline-block mx-1">
                    <a href="#" target="_blank" class="btnCreateProduce btn ftco-animate" data-toggle="modal" data-target="#changePasswordModal">Change Password</a>
                </p> 
    
                <p class="col-md-4 d-inline-block mx-1">
                    <a href="${contextRoot}/orderHistory.html" class="btnCreateProduce btn ftco-animate">Order history</a>
                    <!--<a href="#" target="_blank" class="btnCreateProduce btn ftco-animate" data-toggle="modal" data-target="#orderHistoryModal">Order history</a>-->
                </p>    
                
                <p class="col-md-4 d-inline-block mx-1">
                    <a href="evaluations.html" class="btnCreateProduce btn ftco-animate">Evaluations</a>
                    <!--<a href="#" target="_blank" class="btnCreateProduce btn ftco-animate" data-toggle="modal" data-target="#evaluationsModal">Evaluations</a>-->
                </p> 
            </div>            

            <!-- List of items in cart -->
            <!-- Loop to see all items currently in cart -->
            <div class="col-md-12 my-4">
                <table class="table table-striped cart-items-table">
                    <thead>
                        <tr>
                            <th scope="col">Items</th>
                            <th scope="col">Qty</th>
                            <th scope="col">Unit Price</th>
                            <th scope="col">Total</th>
                            <th scope="col">Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Oranges</td>
                            <td>9</td>
                            <td>2.99</td>
                            <td>26.91</td>
                            <td>
                                <a href="#" class="btnTable">
                                    <i class="fas fa-trash-alt" title="Remove"></i>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>Oranges</td>
                            <td>9</td>
                            <td>2.99</td>
                            <td>26.91</td>
                            <td>
                                <a href="#" class="btnTable">
                                    <i class="fas fa-trash-alt" title="Remove"></i>
                                </a>
                            </td>
                        </tr>
                    </tbody>           
                </table>
            </div>

            <!-- Order options -->
            <div class="col-md-12">
                <form asp-controller="" asp-action="#" method="post">                 
                    <!-- Specific information -->
                    <div class="col-md-7 d-inline-block">
                        <div class="col-md-12 my-2">
                            <div class="col-md-5 d-inline-block px-4 form-group">
                                <input type="radio" id="shippingOptionDel" name="shippingOption">
                                <label for="shippingOptionDel">Shipping</label>
                            </div>
                            <div class="col-md-6 d-inline-block px-4 form-group">
                                <input type="radio" id="shippingOptionPickup" name="shippingOption">
                                <label for="shippingOptionPickup">Pick up</label>
                            </div>  
                        </div>
                        <div class="col-md-12 my-2 px-4 py-3 default-address">
                            <h5 class="col-md-12 text-center">Default shipping address</h5>
                            <div class="col-md-12 mx-1 my-1 text-center">
                                1171 Davis Drive Newmarket Ontario L3Y 7B4 Canada
                            </div>
                        </div>
                        
                        <div class="col-md-12 my-4 px-4">
                            <div class="col-md-12 form-group">
                                <input type="checkbox" id="another_address" value="another-address">
                                <label for="another_address">Use another address for shipping</label>
                            </div>  
                            <!-- Another Address -->
                            <div class="col-md-12 mx-3 a-address-fields">
                                <!-- Note: Use Google maps API, Autocomplete for Addresses and Search:
                                    https://developers.google.com/maps/documentation/javascript/places-autocomplete#address_forms
                                    https://developers.google.com/maps/documentation/javascript/examples/places-autocomplete-addressform
                                -->
                                <div class="row">
                                    <div class="col-md-12 form-group" id="anotherlocationField">
                                        <input type="text" id="autocompleteAnother" placeholder="Enter your address"
                                            onFocus="geolocate()" class="form-control"></input>
                                    </div>
                                </div>
                            
                                <div class="row">
                                    <div class="col-md-2 form-group">
                                        <input type="text" class="field form-control" id="appart_number_Another" placeholder="Appart" disabled="true"></input>
                                    </div>
                                    <div class="col-md-2 form-group">
                                        <input type="number" class="field form-control" id="street_number_Another" placeholder="Number" disabled="true" required></input>
                                    </div>
                                    <div class="col-md-8 form-group">
                                        <input class="field form-control" id="route_Another" disabled="true" placeholder="Street name" required></input></td>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <input type="number" class="field form-control" id="locality_Another" placeholder="City" disabled="true" required></input>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <input class="field form-control" id="administrative_area_level_1_Another" placeholder="Province" disabled="true" required></input></td>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3 form-group">
                                        <input type="number" class="field form-control" id="postal_code_Another" placeholder="Postal code" disabled="true" required></input>
                                    </div>
                                    <div class="col-md-9 form-group">
                                        <input class="field form-control" id="country" disabled="true" placeholder="Country_Another" required></input></td>
                                    </div>
                                </div><!-- END Another Address -->                           
                            </div>
                        </div>
                    </div><!-- END Specific information -->
                

                    <!-- Total price and Checkout -->
                    <div class="col-md-4 px-4 d-inline-block align-top">
                        <div class="col-md-12">
                            <div class="col-sm-4 d-inline-block">
                                Subtotal
                            </div>
                            <div class="col-sm-4 d-inline-block">
                                $ 300.99
                            </div>                            
                        </div>
                        <div class="col-md-12">
                            <input type="button" class="btn btn-primary btn-lg btn-block" id="checkout" value="Checkout">
                        </div> 
                    </div><!-- End Total price and Checkout -->
                   </form>
               </div>

           </div>
       </div>
</section>


   <!-- **************** Modals ******************** -->
<!-- Modal editUserInfoModal -->
<div class="modal fade" id="editUserInfoModal" tabindex="-1" role="dialog" aria-labelledby="editUserInfoModal" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12 p-5">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <small>CLOSE </small><span aria-hidden="true">&times;</span>
                        </button>
                        <h1 class="mb-4">Edit user information</h1> 
                        <form asp-controller="" asp-action="#" method="post">  
                            <fieldset class="my-2">
                                <legend>General Information</legend>
                                <!-- Address -->
                                <!-- Note: Use Google maps API, Autocomplete for Addresses and Search:
                                    https://developers.google.com/maps/documentation/javascript/places-autocomplete#address_forms
                                    https://developers.google.com/maps/documentation/javascript/examples/places-autocomplete-addressform
                                -->
                                <div class="row">
                                    <div class="col-md-12 form-group" id="locationField">
                                        <input type="text" id="autocomplete" placeholder="Enter your address"
                                            onFocus="geolocate()" class="form-control"></input>
                                    </div>
                                </div>
                            
                                <div class="row">
                                    <div class="col-md-2 form-group">
                                        <input type="text" class="field form-control" id="appart_number" placeholder="Appart" disabled="true"></input>
                                    </div>
                                    <div class="col-md-2 form-group">
                                        <input type="number" class="field form-control" id="street_number" placeholder="Number" disabled="true" required></input>
                                    </div>
                                    <div class="col-md-8 form-group">
                                        <input class="field form-control" id="route" disabled="true" placeholder="Street name" required></input></td>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <input type="number" class="field form-control" id="locality" placeholder="City" disabled="true" required></input>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <input class="field form-control" id="administrative_area_level_1" placeholder="Province" disabled="true" required></input></td>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3 form-group">
                                        <input type="number" class="field form-control" id="postal_code" placeholder="Postal code" disabled="true" required></input>
                                    </div>
                                    <div class="col-md-9 form-group">
                                        <input class="field form-control" id="country" disabled="true" placeholder="Country" required></input></td>
                                    </div>
                                </div><!-- END Farmer Address -->
        
                                <!-- Name -->
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label for="m_bfname">First Name</label>
                                        <input type="text" class="form-control" id="m_bfname" required>
                                    </div>
                                    <div class="col-md-6 form-group">
                                        <label for="m_blname">Last Name</label>
                                        <input type="text" class="form-control" id="m_blname" required>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label for="m_bmname">Middle Name</label>
                                        <input type="text" class="form-control" id="m_bmname">
                                    </div>
                                </div>
                                <!-- Email -->
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label for="m_bemail">Email</label>
                                        <input type="email" class="form-control" id="m_bemail" required>
                                    </div>
                                </div>
                                <!-- Phone -->
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <label for="m_bphone">Phone</label>
                                        <input type="text" class="form-control" id="m_bphone">
                                    </div>
                                </div>
                                <!-- Add Picture -->
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label for="m_upicture">Upload Your Picture (PNG, JPG)</label>
                                        <input type="file" class="form-control" id="m_upicture" accept="image/png, image/jpeg, image/jpg"></input>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 d-inline-block mx-auto form-group" id="m_upicture_img">
                                        <img src="//:0" alt="Uploaded picture">
                                    </div>
                                </div>
                            </fieldset>
            
                            <!-- Specific fields for Farmer or Buyer -->
                            <!--
                            <fieldset class="my-2 form-farm-fields">
                                <legend>Specific Information</legend>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label for="m_position">Position Name</label>
                                        <input type="text" class="form-control" id="m_position"></input>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        <label for="m_website">Web Site URL</label>
                                        <input type="url" class="form-control" id="m_website"></input>
                                    </div>
                                </div>
                            </fieldset>
                            -->

                            <!-- Submit or reset -->
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Save">
                                </div>
                                <div class="col-md-6 form-group">
                                    <input type="reset" class="btn btn-primary btn-lg btn-block" value="Reset">
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- END editUserInfoModal -->

<!-- Modal changePasswordModal: May not be useful for buyer because of oAUTH facebook -->
<div class="modal fade" id="changePasswordModal" tabindex="-1" role="dialog" aria-labelledby="changePasswordModal" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12 p-5">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <small>CLOSE </small><span aria-hidden="true">&times;</span>
                        </button>
                        <h1 class="mb-4">Change password</h1> 
                        <form asp-controller="" asp-action="#" method="post">  
                            <!-- Authentication -->               
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label for="m_uemail">Email</label>
                                    <input type="email" class="form-control" id="m_uemail" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="m_old_upassword">Current password</label>
                                    <input type="password" class="form-control" id="m_old_upassword" required>
                                </div>
                            </div>

                            <!-- New Password -->
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label for="m_new_upassword">New password</label>
                                    <input type="email" class="form-control" id="m_new_upassword" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="m_rnew_upassword">Retype new password</label>
                                    <input type="password" class="form-control" id="m_rnew_upassword" required>
                                </div>
                                <div></div>
                            </div>

                            <!-- Submit or reset -->
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Save">
                                </div>
                                <div class="col-md-6 form-group">
                                    <input type="reset" class="btn btn-primary btn-lg btn-block" value="Reset">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- END changePasswordModal -->

<!-- **************** END Modals ******************** -->
