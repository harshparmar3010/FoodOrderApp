<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>     
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../include/meta_tag_holder.jsp"></jsp:include>
<title>Manage City</title>
<link href="${pageContext.request.contextPath}/css/my_styles.css" rel="stylesheet">
<jsp:include page="../../include/include_holder.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../start_main.jsp"></jsp:include>
<p class="text-md-left fw-bold">City Details</p>

<a href="/admin/city/add" class="btn btn-success mb-3"><i class="fa-solid fa-plus"></i> Add City</a>
<table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
        <tr>
	        <th>No</th>
	        <th>City Name</th>
	        <th>City Description</th>
	        <th>Action</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach var="city" items="${cities}">
	        <tr>
	            <td>${city.id}</td>
	            <td>${city.name}</td>
	            <td>${city.description}</td>
	            <td>
		            <a href="/admin/city/edit?id=${city.id}" class="btn btn-primary"><i class="fa-regular fa-pen-to-square"></i></a>
		            <a id="deleteButton" href="/admin/city/delete?id=${city.id}" class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a>
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
<script>
    function copyTableToClipboard() {
        var table = document.getElementById('example');
        var range = document.createRange();
        range.selectNode(table);
        window.getSelection().removeAllRanges();
        window.getSelection().addRange(range);
        document.execCommand('copy');
        window.getSelection().removeAllRanges();
        alert('Table copied to clipboard');
    }
</script>
</body>
</html>