<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/meta_tag_holder.jsp"></jsp:include>
<title>Restaurant Dashboard</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../include/include_holder.jsp"></jsp:include>

</head>
<body>
<jsp:include page="start_main.jsp"></jsp:include>
<div class="row">
      <!-- Offers Card -->
      
      <div class="col-md-3">
        <div class="card">
          <a href="/restaurant/offers" style="text-decoration:none;color:unset;">
          <div class="card-body">
            <h5 class="card-title">Offers</h5>
            <p class="card-text">Count: <strong>${offersCount}</strong></p>
          </div>
          </a>
        </div>
      </div>
      <!-- Products Card -->
      <div class="col-md-3">
        <div class="card">
          <a href="/restaurant/product" style="text-decoration:none;color:unset;">
          <div class="card-body">
            <h5 class="card-title">Products</h5>
            <p class="card-text">Count: <strong>${productsCount}</strong></p>
          </div>
          </a>
        </div>
      </div>

</div>
<jsp:include page="end_main.jsp"></jsp:include>

</body>
</html>