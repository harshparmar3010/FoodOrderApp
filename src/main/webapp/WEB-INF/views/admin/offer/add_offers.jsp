<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../include/meta_tag_holder.jsp"></jsp:include>
<title><c:if test="${ action eq 'add' }">
Add Offers
</c:if> <c:if test="${ action eq 'edit' }">
Edit Offers
</c:if></title>
<link href="${pageContext.request.contextPath}/css/my_styles.css"
	rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../start_main.jsp"></jsp:include>
	<p class="text-md-left fw-bold">
		<c:if test="${ action eq 'add' }">Add Offers</c:if>
		<c:if test="${ action eq 'edit' }">Edit Offers</c:if>
	</p>

	<form method="post"
		<c:if test="${ action eq 'add' }">action="/admin/offers/add"</c:if>
		<c:if test="${ action eq 'edit' }">action="/admin/offers/edit"</c:if>>
		
		<c:if test="${ action eq 'edit' }">
			<input type="hidden" name="id" value="${offers.id}" />
		</c:if>
		
		<div class="row mb-3">
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;" for="restaurant">Restaurant</label>
				<div class="input-group">
					<span class="input-group-text" id="inputGroupPrepend">
						<i class="fa-solid fa-spoon"></i>
						</span>
					<select class="form-control" name="restaurantId" id="restaurant" required
						data-error="You should select Restaurant">
						<option value="">Select Restaurant</option>
						<c:forEach var="restaurant" items="${restaurantList}">
							<option value="${restaurant.id}"
								<c:if test="${action eq 'edit' && restaurant.id eq offers.restaurant.id }">selected</c:if>>${restaurant.name}</option>
						</c:forEach>
					</select>
					<div class="invalid-feedback"></div>
				</div>
			</div>
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;" for="category">Category</label>
				<div class="input-group">
					<span class="input-group-text" id="inputGroupPrepend">
						<i class="fa-solid fa-mug-saucer"></i>
						</span>
					<select class="form-control" name="categoryId" id="category" required
						data-error="You should select Category">
						<option value="">Select Category</option>
						<c:forEach var="category" items="${categoryList}">
							<option value="${category.id}"
								<c:if test="${action eq 'edit' && category.id eq offers.category.id }">selected</c:if>>${category.name}</option>
						</c:forEach>
					</select>
					<div class="invalid-feedback"></div>
				</div>
			</div>
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;" for="area">Sub Category</label>
				<div class="input-group">
					<span class="input-group-text" id="inputGroupPrepend">
						<i class="fa-solid fa-utensils"></i>
						</span>
					<select class="form-control" name="subCategoryId" id="subCategory" required
						data-error="You should select SubCategory">
						<option value="">Select SubCategory</option>
						<c:if test="${action eq 'edit'}">
							<c:forEach var="subCategory" items="${subCategoryList}">
								<option value="${subCategory.id}"
									<c:if test="${action eq 'edit' && subCategory.id eq offers.subCategory.id }">selected</c:if>>${subCategory.name}</option>
							</c:forEach>
						</c:if>
					</select>
					<div class="invalid-feedback"></div>
				</div>
			</div>
		</div>
		<div class="form-group mb-3">
			<label class="fw-bold" style="color: #636469;"
				for="offerName">Offer Name</label>
			<div class="input-group">
				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-lightbulb"></i></span>
				<input type="text"
					class="form-control" name="name" placeholder="Offer Name"
					data-textRequired required data-textRequired-error="Offer name must contain only letters, numbers, underscores, hyphens, and spaces. It cannot start or end with a space."
					<c:if test="${ action eq 'edit' }">value="${offers.name}"</c:if>>
				<div class="invalid-feedback"></div>
			</div>
		</div>
		
		<div class="form-group mb-3">
			<label class="fw-bold" style="color: #636469;" for="discription">Offer Description</label>
			<div class="input-group">
				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-i-cursor"></i></span>
				<textarea rows="3" cols="20" class="form-control" name="description"
					placeholder="Offer Description" data-textDescriptionRequired required
					data-textDescriptionRequired-error="Offer description must contain only letters, numbers, spaces, underscores, periods, commas, exclamation marks, question marks, and hyphens."><c:if
						test="${ action eq 'edit' }">${offers.description}</c:if></textarea>
				<div class="invalid-feedback"></div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;" for="startDateTime">Start Date</label>
				<div class="input-group">
					<span class="input-group-text" id="inputGroupPrepend"><i class="fa-regular fa-calendar"></i></span>
					<input class="form-control" type="datetime-local" name="startDateTime" <c:if test="${action eq 'edit'}">value="${offers.startDateTime}"</c:if> data-startDateValidation required data-startDateValidation-error="Please select start datetime before." />
					<div class="invalid-feedback"></div>
				</div>
			</div>
			<div class="col form-group">
				<label class="fw-bold" style="color: #636469;" for="endDateTime">End Date</label>
				<div class="input-group">
					<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-calendar"></i></span>
					<input class="form-control" type="datetime-local" name="endDateTime" <c:if test="${action eq 'edit'}">value="${offers.endDateTime}"</c:if> data-endDateValidation required data-endDateValidation-error="End datetime is not before start datetime." data-startEndDateDurationValidation data-startEndDateDurationValidation-error="Max duration 30day not excided."/>
					<div class="invalid-feedback"></div>
				</div>
			</div>
		</div>
		<div class="form-group mb-3">
			<label class="fw-bold" style="color: #636469;"
				for="discount">Discount(%)</label>
			<div class="input-group">
				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-percent"></i></span>
				<input type="text"
					class="form-control" name="discount" placeholder="Discount" data-numberonly
					required data-numberonly-error="Discount valid in number only."
					<c:if test="${ action eq 'edit' }">value="${offers.discount}"</c:if>>
				<div class="invalid-feedback"></div>
			</div>
		</div>
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
            $('#category').change(function(){
            	$('#subCategory').empty();
                $("#subCategory").append(`<option value="">Select SubCategory</option>`);
                var categoryId = $(this).val();
                $.ajax({
                    url: '${pageContext.request.contextPath}/getSubCategory',
                    type: 'POST',
                    data: {categoryId: categoryId},
                    success: function(data){
                        $.each(data, function(index, subCategory){
                            $('#subCategory').append($('<option>').text(subCategory.name).attr('value', subCategory.id));
                        });
                    }
                });
            });
        });
    </script>
</body>
</html>