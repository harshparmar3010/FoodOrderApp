<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>       
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../include/meta_tag_holder.jsp"></jsp:include>
<title>
<c:if test="${ action eq 'add' }">
Add Sub Category
</c:if>
<c:if test="${ action eq 'edit' }">
Edit Sub Category
</c:if>
</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../start_main.jsp"></jsp:include>
<p class="text-md-left fw-bold">
<c:if test="${ action eq 'add' }">
Add Sub Category
</c:if>
<c:if test="${ action eq 'edit' }">
Edit Sub Category
</c:if>
</p>

<form method="post" 
<c:if test="${ action eq 'add' }">
action="/admin/sub_category/add"
</c:if>
<c:if test="${ action eq 'edit' }">
action="/admin/sub_category/edit"
</c:if>
>
<c:if test="${ action eq 'edit' }">
<input type="hidden" name="id" value="${sub_category.id}"/>
</c:if>
<div class="form-group mb-3">
	<label class="fw-bold" style="color:#636469;" for="category">Category Name</label>
	<select class="form-control" name="category_id" required data-error="You should select category.">
	    <option value="">Select Category</option>
	    <c:forEach var="category" items="${categories}">
	    	<option value="${category.id}" <c:if test="${ action eq 'edit' && category.id eq sub_category.category.id}">selected</c:if> >${category.name}</option>
	    </c:forEach>
	</select>
</div>
<div class="form-group mb-3">
	<label class="fw-bold" style="color:#636469;" for="subCategoryName">Sub Category Name</label>
	<input type="text" class="form-control" name="name" placeholder="Sub Category Name" value="<c:if test="${ action eq 'edit' }">${sub_category.name}</c:if>" data-textRequired required data-textRequired-error="Sub Category name must contain only letters, numbers, underscores, hyphens, and spaces. It cannot start or end with a space.">
</div>
<div class="form-group mb-3">
    <label class="fw-bold" style="color:#636469;" for="subCategoryDescription">Sub Category Description</label>
    <textarea name="description" class="form-control" rows="3" placeholder="Sub Category description" data-textDescriptionRequired required
				data-textDescriptionRequired-error="SubCategory description must contain only letters, numbers, spaces, underscores, periods, commas, exclamation marks, question marks, and hyphens."><c:if test="${ action eq 'edit' }">${sub_category.description}</c:if></textarea>
</div>
<button type="submit" class="btn btn-primary float-end">
<c:if test="${ action eq 'add' }">
<i class="fa-solid fa-floppy-disk"></i> Save
</c:if>
<c:if test="${ action eq 'edit' }">
<i class="fa-solid fa-square-pen"></i> Update
</c:if>
</button>
</form>
<jsp:include page="../end_main.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/custom.validation.js"></script>
</body>
</html>