document.getElementById("logoutButton").addEventListener("click", function(event) {
    event.preventDefault(); // Prevent default action of the link
    cuteAlert({
	  type: "question",
	  title: "Are you sure?",
	  message: "You won't be able to revert this!",
	  confirmText: "Yes, logout!",
  	  cancelText: "Cancel"
	}).then((e)=>{
		console.log(e);
	    if ( e == ("confirm")){
			window.location.href = "/logout";
	  }
  	});
    /*Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, logout!"
    }).then((result) => {
        if (result.isConfirmed) {
            // Redirect to logout page
            window.location.href = "/logout";
        }
    });*/
});