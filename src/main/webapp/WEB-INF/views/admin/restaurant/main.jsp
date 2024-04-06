<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>     
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../include/meta_tag_holder.jsp"></jsp:include>
<title>Manage Restaurant</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../start_main.jsp"></jsp:include>
<p class="text-md-left fw-bold">Restaurant Details</p>

<a href="/admin/restaurant/add" class="btn btn-success mb-3"><i class="fa-solid fa-plus"></i> Add Restaurant</a>
<table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
        <tr>
	        <th>No</th>
	        <th>City Name</th>
	        <th>Area Name</th>
	        <th>Restaurant Name</th>
	        <th>Restaurant Address</th>
	        <th>Phone No</th>
	        <th>Email</th>
	        <th>Action</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach var="restaurant" items="${restaurantList}">
	        <tr>
	            <td>${restaurant.id}</td>
	            <td>${restaurant.city.name}</td>
	            <td>${restaurant.area.name}</td>
	            <td>${restaurant.name}</td>
	            <td>${restaurant.address}</td>
	            <td>${restaurant.contactNo}</td>
	            <td>${restaurant.email}</td>
	            <td>
	            <a href="/admin/restaurant/edit?id=${restaurant.id}" class="btn btn-primary"><i class="fa-regular fa-pen-to-square"></i></a>
	            <a id="deleteButton" href="/admin/restaurant/delete?id=${restaurant.id}" class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a>
	            
	            </td>
	        </tr>
        </c:forEach>
    </tbody>
</table>

<script type="text/javascript">
	$(document).ready(function(){
		var table = $('#example').DataTable({
			"columnDefs": [{
	            "targets": -1, // Action column index
	            "width": "100px" // Set your custom width here
	        }],
	        buttons:['copy', 'csv', 'excel', 'pdf', 'print']
	        
	    });
		table.buttons().container()
	    .appendTo('#example_wrapper .col-md-6:eq(0)');
	});
</script>
<jsp:include page="../end_main.jsp"></jsp:include>

</body>
</html>