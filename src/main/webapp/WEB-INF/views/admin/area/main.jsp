<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>      
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../include/meta_tag_holder.jsp"></jsp:include>
<title>Manage Area</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../start_main.jsp"></jsp:include>
<p class="text-md-left fw-bold">Area Details</p>

<a href="/admin/area/add" class="btn btn-success mb-3"><i class="fa-solid fa-plus"></i> Add Area</a>

<table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
        <tr>
            <th>No</th>
            <th>City Name</th>
            <th>Area Name</th>
            <th>Area Description</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach var="area" items="${areas}">
    		<tr>
	            <td>${area.id }</td>
	            <td>${area.city.name}</td>
	            <td>${area.name}</td>
	            <td>${area.description}</td>
	            <td>
	            <a href="/admin/area/edit?id=${area.id}" class="btn btn-primary"><i class="fa-regular fa-pen-to-square"></i></a>
	            <a id="deleteButton" href="/admin/area/delete?id=${area.id}" class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a>
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