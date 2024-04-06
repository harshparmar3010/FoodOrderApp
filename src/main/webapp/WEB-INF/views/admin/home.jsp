<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/meta_tag_holder.jsp"></jsp:include>
<title>Admin Dashboard</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../include/include_holder.jsp"></jsp:include>

</head>
<body>
<jsp:include page="start_main.jsp"></jsp:include>
<div class="row">
	  <div class="col-md-3">
        <div class="card">
          <a href="/admin/city" style="text-decoration:none;color:unset;">
          <div class="card-body">
            <h5 class="card-title">Cities</h5>
            <p class="card-text">Count: <strong>${cityCount}</strong></p>
          </div>
          </a>
        </div>
      </div>
      <!-- Area Card -->
      <div class="col-md-3">
        <div class="card">
          <a href="/admin/area" style="text-decoration:none;color:unset;">
          <div class="card-body">
            <h5 class="card-title">Areas</h5>
            <p class="card-text">Count: <strong>${areaCount}</strong></p>
          </div>
          </a>
        </div>
      </div>
      <!-- Category Card -->
      <div class="col-md-3">
        <div class="card">
          <a href="/admin/category" style="text-decoration:none;color:unset;">
          <div class="card-body">
            <h5 class="card-title">Categories</h5>
            <p class="card-text">Count: <strong>${categoryCount}</strong></p>
          </div>
          </a>
        </div>
      </div>
      <!-- Sub Category Card -->
      <div class="col-md-3">
        <div class="card">
          <a href="/admin/sub_category" style="text-decoration:none;color:unset;">
          <div class="card-body">
            <h5 class="card-title">Sub Categories</h5>
            <p class="card-text">Count: <strong>${subCategoryCount}</strong></p>
          </div>
          </a>
        </div>
      </div>
</div>
<div class="row mt-2">
      <!-- Offers Card -->
      
      <div class="col-md-3">
        <div class="card">
          <a href="/admin/offers" style="text-decoration:none;color:unset;">
          <div class="card-body">
            <h5 class="card-title">Offers</h5>
            <p class="card-text">Count: <strong>${offersCount}</strong></p>
          </div>
          </a>
        </div>
      </div>
      <!-- Restaurant Card -->
      <div class="col-md-3">
        <div class="card">
          <a href="/admin/restaurant" style="text-decoration:none;color:unset;">
          <div class="card-body">
            <h5 class="card-title">Restaurant</h5>
            <p class="card-text">Count: <strong>${restaurantCount}</strong></p>
          </div>
          </a>
        </div>
      </div>

</div>
<jsp:include page="end_main.jsp"></jsp:include>

</body>
</html>