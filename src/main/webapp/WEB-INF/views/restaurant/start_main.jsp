
	<!-- Navigation Bar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light shadow position-fixed" style="width:100%;z-index:10;">
	    <div class="container-fluid">
	        <a class="navbar-brand" href="#">FOOD ORDER</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
	          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	      
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
	          <ul class="navbar-nav mr-auto">
	            
	          </ul>
	        </div>
	    </div>
	</nav>
    
	<div class="container-fluid">
    	<div class="row">
		    <!-- Side Panel -->
		    <div class="col-lg-2 d-none d-lg-block" id="sidePanel">
			    <div class="side-panel">
			        <ul class="list-group">
			            <li class="list-group-item p-3">
			            	<a href="/restaurant/${restaurant_id}" style="text-decoration:none;color:unset;">
			            		<div class="row align-items-center">
				                    <div class="col-2">
				                        <i class="fa-solid fa-display"></i>
				                    </div>
				                    <div class="col">
				                        <span>Dashboard</span>
				                    </div>
				                </div>
			            	</a>
			                
			            </li>
			            <li class="list-group-item p-3">
			            	<a href="/restaurant/product" style="text-decoration:none;color:unset;">
				                <div class="row align-items-center">
				                    <div class="col-2">
				                        <i class="fa-solid fa-bag-shopping"></i>
				                    </div>
				                    <div class="col">
				                        <span>Manage Product</span>
				                    </div>
				                    <div class="col-auto ml-auto">
				                        <i class="fa-solid fa-plus"></i>
				                    </div>
				                </div>
			                </a>
			            </li>
			            <li class="list-group-item p-3">
			            	<a href="/restaurant/offers" style="text-decoration:none;color:unset;">
				                <div class="row align-items-center">
				                    <div class="col-2">
				                        <i class="fa-solid fa-briefcase"></i>
				                    </div>
				                    <div class="col">
				                        <span>Manage Offers</span>
				                    </div>
				                    <div class="col-auto ml-auto">
				                        <i class="fa-solid fa-plus"></i>
				                    </div>
				                </div>
			                </a>
			            </li>
			            <li class="list-group-item p-3">
			            	<a href="" style="text-decoration:none;color:unset;">
				                <div class="row align-items-center">
				                    <div class="col-2">
				                        <i class="fa-solid fa-truck"></i>
				                    </div>
				                    <div class="col">
				                        <span>Manage Order</span>
				                    </div>
				                    <div class="col-auto ml-auto">
				                        <i class="fa-solid fa-plus"></i>
				                    </div>
				                </div>
			                </a>
			            </li>
			            <li class="list-group-item p-3">
			            	<a href="" style="text-decoration:none;color:unset;">
				                <div class="row align-items-center">
				                    <div class="col-2">
				                        <i class="fa-solid fa-phone"></i>
				                    </div>
				                    <div class="col">
				                        <span>Manage Complaint</span>
				                    </div>
				                    <div class="col-auto ml-auto">
				                        <i class="fa-solid fa-plus"></i>
				                    </div>
				                </div>
			                </a>
			            </li>
			            <li class="list-group-item p-3">
			            	<a id="logoutButton" href="" style="text-decoration:none;color:unset;">
				                <div class="row align-items-center">
				                    <div class="col-2">
				                        <i class="fa-solid fa-display"></i>
				                    </div>
				                    <div class="col">
				                        <span>Logout</span>
				                    </div>
				                </div>
			                </a>
			            </li>
			            
			        </ul>
			    </div>
		    </div>
		    <!-- Card in remaining space -->
		    <div class="container mt-5" style="max-width:80%;">
		        <div class="row mt-5 ml-2">
		            <div class="col">
		                <div class="card shadow">
		                    <div class="card-body" id="card_body">
		                    
		                    
	
