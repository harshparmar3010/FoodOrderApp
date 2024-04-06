<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="include/meta_tag_holder.jsp"></jsp:include>
<title>
Registration
</title>
<jsp:include page="include/include_holder.jsp"></jsp:include>
<style>
        *{
			font-family: "Open Sans", sans-serif;
		}
	    body {
	        background-image: url('images/back_img.jpg');
	        background-size: cover;
	        background-repeat: no-repeat;
	        height: 100vh;
	        display: flex;
	        justify-content: center;
	        align-items: center;
	    }
        .card {
            width: 600px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
    <div class="bg-image">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Register</h5>
                <form role="form" method="post" action="/registration">
                    <div class="form-group mb-3">
                        <label class="fw-bold" style="color:#636469;" for="restaurantName">Restaurant Name</label>
                        <div class="input-group">
	        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-utensils"></i></span>
	                        <input type="text" class="form-control" name="name" placeholder="Restaurant Name" required data-error="You should enter restaurant name.">
	                        <div class="invalid-feedback"></div>
	        			</div>
                    </div>
                    <div class="row mb-3">
                        <div class="col form-group">
                            <label class="fw-bold" style="color:#636469;" for="email">Email</label>
                            <div class="input-group">
		        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-at"></i></span>
		        				<input type="email" name="email" class="form-control" id="input-email" placeholder="Email" required data-email data-email-error="Bruh, that email address is invalid." />
	                            <div class="invalid-feedback"></div>
	                            
		        			</div>
		        			<small id="emailHelpBlock" class="form-text text-muted">
							example@example.com
							</small>
                            
                        </div>
                        <div class="col form-group">
                            <label class="fw-bold" style="color:#636469;" for="contactNo">Contact No</label>
                            <div class="input-group">
		        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-address-book"></i></span>
	                            <input type="tel" class="form-control" name="contactNo" placeholder="Contact No" data-contactValidation required data-contactValidation-error="Only Input 10 digit indian mobile number.">
	                            <div class="invalid-feedback"></div>
		        			</div>
                        </div>
                    </div>
                    <div class="form-group mb-3">
                        <label class="fw-bold" style="color:#636469;" for="address">Address</label>
                         <div class="input-group">
	        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-audio-description"></i></span>
	                        <textarea rows="3" cols="20"  class="form-control" name="address" placeholder="Address" required data-error="You should enter address."></textarea>
	                        <div class="invalid-feedback"></div>
	        			</div>
                    </div>
                    <div class="row mb-3">
                        <div class="col form-group">
                            <label class="fw-bold" style="color:#636469;" for="city">City</label>
                            <div class="input-group">
	        					<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-city"></i></span>
	                            <select class="form-control" name="cityId" id="city" required data-error="You should select city.">
	                                <option value="">Select City</option>
	                                <c:forEach var="city" items="${cityList}">
						                <option value="${city.id}">${city.name}</option>
						            </c:forEach>
	                            </select>
	                            <div class="invalid-feedback"></div>
		        			</div>
                        </div>
                        <div class="col form-group">
                            <label class="fw-bold" style="color:#636469;" for="area">Area</label>
                            <div class="input-group">
	        					<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-warehouse"></i></span>
	                            <select class="form-control" name="areaId" id="area" required data-error="You should select area">
	                                <option value="">Select Area</option>
	                            </select>
	                            <div class="invalid-feedback"></div>
		        			</div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col form-group">
                        	<label class="fw-bold" style="color:#636469;" for="password">Password</label>
                        	 <div class="input-group">
		        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-lock"></i></span>
	                            <input id="passwordField1"  type="password" name="password" class="form-control" placeholder="Password" required data-passwordValidation 
	                            data-passwordValidation-error="Invalid Password" />
	                            <button class="btn btn-outline-secondary" type="button" id="togglePassword1">
			                         <i class="fas fa-eye"></i>
			                    </button>
	                            <div class="invalid-feedback"></div>
	                            
		        			</div>
                            
                            <small id="passwordHelpBlock" class="form-text text-muted">
							  Password Minimum 8 and maximum 20, one uppercase, lowercase, number and one special character.
							</small>
                        </div>
                        <div class="col form-group">
                            <label class="fw-bold" style="color:#636469;" for="confirm-password">Confirm Password</label>
                        	 <div class="input-group">
		        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-lock"></i></span>
	                            <input id="passwordField2"  type="password" class="form-control" placeholder="Confirm Password" required required data-match="#input-password" data-match-error="Whoops, these don't match" />
	                            <button class="btn btn-outline-secondary" type="button" id="togglePassword2">
			                            <i class="fas fa-eye"></i>
			                    </button>
	                            <div class="invalid-feedback"></div>
	                            
		        			</div>
                        </div>
                        
                   	</div>
                   	<div class="d-grid gap-2">
                   		<button type="submit" class="btn btn-primary btn-block p-2 shadow fw-bold mb-3"><i class="fa-solid fa-user-plus"></i> Register</button>
                   	</div>
                    
                </form>
                <p class="text-center mb-3">Already registered? <a href="/login"><i class="fa-solid fa-arrow-right-to-bracket"></i> Login</a></p>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function(){
            $('#city').change(function(){
            	$('#area').empty();
                $("#area").append(`<option value="">Select Area</option>`);
                var cityId = $(this).val();
                $.ajax({
                    url: '${pageContext.request.contextPath}/getAreas',
                    type: 'POST',
                    data: {cityId: cityId},
                    success: function(data){
                        $.each(data, function(index, area){
                            $('#area').append($('<option>').text(area.name).attr('value', area.id));
                        });
                    }
                });
            });
            var cityId = $('#city').val();
            if(cityId!="")
            {
            	$.ajax({
                    url: '${pageContext.request.contextPath}/getAreas',
                    type: 'POST',
                    data: {cityId: cityId},
                    success: function(data){
                        $.each(data, function(index, area){
                            $('#area').append($('<option>').text(area.name).attr('value', area.id));
                        });
                    }
                });
            }
            
        });
    </script>
    <script src="${pageContext.request.contextPath}/js/custom.validation.js"></script>
    <script src="${pageContext.request.contextPath}/js/togglePassword.js"></script>
    <script>
        $(document).ready(function() {
            const urlParams = new URLSearchParams(window.location.search);
            const error = urlParams.get('error');
            const email = urlParams.get('email');
            const contact = urlParams.get('contact');
            if (error === 'DataIntegrityViolationException') {
            	if(email){
            		cuteAlert({
	              	      type: "info",
	              	      title: "Validation",
	              	      message: "Email already exist.",
	              	      buttonText: "Okay"
	              	 })
            	}
            	if(contact){
            		cuteAlert({
	              	      type: "info",
	              	      title: "Validation",
	              	      message: "Contact Number already exist.",
	              	      buttonText: "Okay"
	              	 })
            	}
            	
            }
        });
    </script>
</body>
</html>