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
Add Area
</c:if>
<c:if test="${ action eq 'edit' }">
Edit Area
</c:if>
</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../start_main.jsp"></jsp:include>
<p class="text-md-left fw-bold">
<c:if test="${ action eq 'add' }">
Add Area
</c:if>
<c:if test="${ action eq 'edit' }">
Edit Area
</c:if>
</p>

<form method="post" 
<c:if test="${ action eq 'add' }">
action="/admin/area/add"
</c:if>
<c:if test="${ action eq 'edit' }">
action="/admin/area/edit"
</c:if>
>
<c:if test="${ action eq 'edit' }">
<input type="hidden" name="id" value="${area.id}"/>
</c:if>
<div class="form-group mb-3">
	<label class="fw-bold" style="color:#636469;" for="city">City Name</label>
	<div class="input-group">
		<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-city"></i></span>
		<select class="form-control" name="city_id" required data-error="You should select city.">
		    <option value="">Select City</option>
		    <c:forEach var="city" items="${cities}">
		    	<option value="${city.id}" <c:if test="${ action eq 'edit' && city.id eq area.city.id}">selected</c:if> >${city.name}</option>
		    </c:forEach>
		</select>
	</div>
</div>
<div class="form-group mb-3">
	<label class="fw-bold" style="color:#636469;" for="areaName">Area Name</label>
	<div class="input-group">
		<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-warehouse"></i></span>
		<input type="text" class="form-control" name="name" placeholder="Area Name" value="<c:if test="${ action eq 'edit' }">${area.name}</c:if>" data-textRequired required data-textRequired-error="Area name must contain only letters, numbers, underscores, hyphens, and spaces. It cannot start or end with a space."/>
	</div>
</div>
<div class="form-group mb-3">
    <label class="fw-bold" style="color:#636469;" for="areaDescription">Area Description</label>
    <div class="input-group">
		<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-i-cursor"></i></span>
	    <textarea name="description" class="form-control" rows="3" placeholder="Area description" data-textDescriptionRequired required
					data-textDescriptionRequired-error="Area description must contain only letters, numbers, spaces, underscores, periods, commas, exclamation marks, question marks, and hyphens."><c:if test="${ action eq 'edit' }">${area.description}</c:if></textarea>
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