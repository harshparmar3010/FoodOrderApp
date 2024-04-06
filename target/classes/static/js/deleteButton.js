
$(document).ready(function(){
    // Add click event listener to the anchor tag
    $("#deleteButton").click(function(event) {
        // Prevent the default action of the anchor tag
        event.preventDefault();
        
        // Get the href attribute value of the anchor tag
        var href = $(this).attr("href");
        
        cuteAlert({
		  type: "question",
		  title: "Are you sure?",
		  message: "You won't be able to revert this!",
		  confirmText: "Delete",
	  	  cancelText: "Cancel",
	  	  confirmButtonColor: "#3085d6",
           cancelButtonColor: "#d33"
		}).then(() => {
			if ( e == ("confirm")){
				window.location.href = href;
			}
		  
		});
        // Show confirmation dialog using SweetAlert
        /*Swal.fire({
            title: "Are you sure?",
            text: "You won't be able to revert this!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Delete"
        }).then((result) => {
            if (result.isConfirmed) {
                // Redirect to the URL obtained from href attribute
                window.location.href = href;
            }
        });*/
    });
});