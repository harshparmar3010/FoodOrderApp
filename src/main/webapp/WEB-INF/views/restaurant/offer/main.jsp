<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ page import="com.task.FoodOrder.UtilsFunction"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../include/meta_tag_holder.jsp"></jsp:include>
<title>Manage Offers</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../start_main.jsp"></jsp:include>
<p class="text-md-left fw-bold">Offers Details</p>

<a href="/restaurant/offers/add" class="btn btn-success mb-3"><i class="fa-solid fa-plus"></i> Add Offers</a>
<table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
        <tr>
            <th>No</th>
            <th>Category Name</th>
            <th>SubCategory Name</th>
            <th>Offers Name</th>
            <th>Offers Description</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Discount(%)</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach var="offers" items="${offersList}">
    		<tr>
	            <td>${offers.id}</td>
	            <td>${offers.category.name}</td>
	            <td>${offers.subCategory.name}</td>
	            <td>${offers.name}</td>
	            <td>${offers.description}</td>
	            
	            <td><fmt:formatDate
							value="${UtilsFunction.convertLocalDateTimeToDate(offers.startDateTime)}"
							pattern="dd/MM/yyyy HH:mm" /></td>
				<td><fmt:formatDate
						value="${UtilsFunction.convertLocalDateTimeToDate(offers.endDateTime)}"
						pattern="dd/MM/yyyy HH:mm" /></td>
	            <td>${offers.discount}</td>
	            <td>
	            <a href="/restaurant/offers/edit?id=${offers.id}" class="btn btn-primary"><i class="fa-regular fa-pen-to-square"></i></a>
	            <a id="deleteButton" href="/restaurant/offers/delete?id=${offers.id}" class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a>
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