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
Add City
</c:if>
<c:if test="${ action eq 'edit' }">
Edit City
</c:if>
</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../start_main.jsp"></jsp:include>
<p class="text-md-left fw-bold">
<c:if test="${ action eq 'add' }">
Add City
</c:if>
<c:if test="${ action eq 'edit' }">
Edit City
</c:if>
</p>

<form method="post" 
<c:if test="${ action eq 'add' }">
action="/admin/city/add"
</c:if>
<c:if test="${ action eq 'edit' }">
action="/admin/city/edit"
</c:if>>
<c:if test="${ action eq 'edit' }">
<input type="hidden" name="id" value="${city.id}" required>
</c:if>
<div class="form-group mb-3">
    <label class="fw-bold" style="color:#636469;" for="cityName">City Name</label>
    <div class="input-group">
		<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-city"></i></span>
	    <input type="text" class="form-control" name="name" placeholder="City Name" value="<c:if test="${ action eq 'edit' }">${city.name}</c:if>" data-textRequired required data-textRequired-error="City name must contain only letters, numbers, underscores, hyphens, and spaces. It cannot start or end with a space.">
	</div>
</div>
<div class="form-group mb-3">
    <label class="fw-bold" style="color:#636469;" for="cityDescription">City Description</label>
    <div class="input-group">
		<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-i-cursor"></i></span>
	    <textarea name="description" class="form-control"  rows="3" placeholder="City Description" data-textDescriptionRequired required
				data-textDescriptionRequired-error="City description must contain only letters, numbers, spaces, underscores, periods, commas, exclamation marks, question marks, and hyphens."><c:if test="${ action eq 'edit' }">${city.description}</c:if></textarea>
	</div>
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