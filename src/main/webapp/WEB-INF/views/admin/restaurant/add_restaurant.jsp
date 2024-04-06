<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../include/meta_tag_holder.jsp"></jsp:include>
<title><c:if test="${ action eq 'add' }">
Add Restaurant
</c:if> <c:if test="${ action eq 'edit' }">
Edit Restaurant
</c:if></title>
<link href="${pageContext.request.contextPath}/css/my_styles.css"
	rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../start_main.jsp"></jsp:include>
	<p class="text-md-left fw-bold">
		<c:if test="${ action eq 'add' }">Add Restaurant</c:if>
		<c:if test="${ action eq 'edit' }">Edit Restaurant</c:if>
	</p>

	<form method="post"
		<c:if test="${ action eq 'add' }">action="/admin/restaurant/add"</c:if>
		<c:if test="${ action eq 'edit' }">action="/admin/restaurant/edit"</c:if>>
		<c:if test="${ action eq 'edit' }">
			<input type="hidden" name="id" value="${restaurant.id}" />
			<input type="hidden" name="password" value="${restaurant.password}" />
		</c:if>

		<div class="form-group mb-3">
			<label class="fw-bold" style="color: #636469;"
				for="restaurantName">Restaurant Name</label>
			<div class="input-group">
   				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-utensils"></i></span>
				<input type="text"
					class="form-control" name="name" placeholder="Restaurant Name"
					required data-error="You should enter restaurant name."
					<c:if test="${ action eq 'edit' }">value="${restaurant.name}"</c:if>>
				<div class="invalid-feedback"></div>
   			</div> 
		</div>
		<div class="row mb-3">
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;" for="email">Email</label>
				<div class="input-group">
	   				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-at"></i></span>
					<input type="email" name="email" class="form-control"
						id="input-email" placeholder="Email" required data-email
						data-email-error="Bruh, that email address is invalid."
						<c:if test="${ action eq 'edit' }">value="${restaurant.email}"</c:if> />
					<div class="invalid-feedback"></div>
	   			</div> 
				<small id="emailHelpBlock" class="form-text text-muted">
				  example@example.com
				</small>
			</div>
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;"
					for="contactNo">Contact No</label>
				<div class="input-group">
	   				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-address-book"></i></span>
					<input type="tel"
						class="form-control" name="contactNo" placeholder="Contact No"
						data-contactValidation required
						data-contactValidation-error="Only Input 10 digit indian mobile number."
						<c:if test="${ action eq 'edit' }">value="${restaurant.contactNo}"</c:if>>
					<div class="invalid-feedback"></div>
	   			</div> 
				
			</div>
		</div>
		<div class="form-group mb-3">
			<label class="fw-bold" style="color: #636469;" for="address">Address</label>
			<div class="input-group">
   				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-audio-description"></i></span>
				<textarea rows="3" cols="20" class="form-control" name="address"
					placeholder="Address" required
					data-error="You should enter address."><c:if
						test="${ action eq 'edit' }">${restaurant.address}</c:if></textarea>
				<div class="invalid-feedback"></div>
   			</div> 
		</div>
		<div class="row mb-3">
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;" for="city">City</label>
				<div class="input-group">
  					<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-city"></i></span>
                        
					<select class="form-control" name="cityId" id="city" required
						data-error="You should select city.">
						<option value="">Select City</option>
						<c:forEach var="city" items="${cityList}">
							<option value="${city.id}"
								<c:if test="${action eq 'edit' && city.id eq restaurant.city.id }">selected</c:if>>${city.name}</option>
						</c:forEach>
					</select>
					<div class="invalid-feedback"></div>
      			</div>
			</div>
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;" for="area">Area</label>
				<div class="input-group">
    				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-warehouse"></i></span>
					<select class="form-control" name="areaId" id="area" required
						data-error="You should select area">
						<option value="">Select Area</option>
						<c:if test="${action eq 'edit'}">
							<c:forEach var="area" items="${areaList}">
								<option value="${area.id}"
									<c:if test="${action eq 'edit' && area.id eq restaurant.area.id }">selected</c:if>>${area.name}</option>
							</c:forEach>
						</c:if>
					</select>
					<div class="invalid-feedback"></div>
				</div>
			</div>
		</div>
		<c:if test="${ action eq 'add' }">
			<div class="row mb-3">
				<div class="col form-group">
					<label class="fw-bold" style="color: #636469;"
						for="password">Password</label>
					<div class="input-group">
        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-lock"></i></span>
						<input  type="password"
							name="password" class="form-control" id="passwordField1"
							placeholder="Password" required data-passwordValidation
							data-passwordValidation-error="Invalid Password Format." />
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
					<label class="fw-bold" style="color: #636469;"
						for="confirm-password">Confirm Password</label>
					<div class="input-group">
	       				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-lock"></i></span>
						<input 
							type="password" id="passwordField2"  class="form-control"
							placeholder="Password" required required
							data-match="#input-password"
							data-match-error="Whoops, these don't match" />
						<button class="btn btn-outline-secondary" type="button" id="togglePassword2">
	                            <i class="fas fa-eye"></i>
	                        </button>
						<div class="invalid-feedback"></div>
					</div>
				</div>
			</div>
			
		</c:if>

		<button type="submit" class="btn btn-primary float-end">
			<c:if test="${ action eq 'add' }"><i class="fa-solid fa-floppy-disk"></i> Save</c:if>
			<c:if test="${ action eq 'edit' }"><i class="fa-solid fa-square-pen"></i> Update</c:if>
		</button>
	</form>
	<jsp:include page="../end_main.jsp"></jsp:include>
	<script
		src="${pageContext.request.contextPath}/js/custom.validation.js"></script>
	
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
        });
    </script>
    <script src="${pageContext.request.contextPath}/js/togglePassword.js"></script>
</body>
</html>