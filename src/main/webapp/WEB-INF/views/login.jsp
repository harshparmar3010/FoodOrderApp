<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<!DOCTYPE html>
<html>
<head>
<jsp:include page="include/meta_tag_holder.jsp"></jsp:include>
<title>Login</title>
<jsp:include page="include/include_holder.jsp"></jsp:include>
<style>
	*{
		font-family: "Open Sans", sans-serif;
	}
    body {
        background-image: url('images/back_img.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .card {
        width: 400px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        border-radius:10px;
        position:fixed;
    }
</style>
</head>
<body>

    <div class="card rounded-3">
    
        <div class="card-body">
        	
            <img src="images/logo.png" height="80px" width="80px" class="mx-auto d-block" alt="Logo">
            
            <form action="/login" method="post">
                <div class="form-group mb-3">
                	<label class="fw-bold" style="color:#636469;" for="email">Email</label>
                	<div class="input-group">
        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-at"></i></span>
        				
	                    <input type="email" class="form-control py-2" name="email" placeholder="Email" required data-email data-email-error="Bruh, that email address is invalid." />
	                    <div class="invalid-feedback"></div>
        			</div>
                </div>
                <div class="form-group mb-3">
                    <label class="fw-bold" style="color:#636469;" for="password">Password</label>
                    <div class="input-group">
        				<span class="input-group-text" id="inputGroupPrepend"><i class="fa-solid fa-lock"></i></span>
        				<input id="passwordField1" type="password" class="form-control py-2" name="password" placeholder="Password" required data-passwordValidation 
                            data-passwordValidation-error="Invalid Password format." />
                        <button class="btn btn-outline-secondary" type="button" id="togglePassword1">
	                            <i class="fas fa-eye"></i>
	                        </button>
	                    <div class="invalid-feedback"></div>
	                    <small id="passwordHelpBlock" class="form-text text-muted">
						  Password Minimum 8 and maximum 20, one uppercase, lowercase, number and one special character.
						</small>
        			</div>
                </div>
                
                <div class="d-grid gap-2">
                	<button type="submit" class="btn btn-primary btn-block p-2 shadow fw-bold mb-3"><i class="fa-solid fa-arrow-right-to-bracket"></i> Login</button>
                </div>
                
            </form>
            
            <p class="mb-3 text-center">Don't have an account? <a href="/registration"><i class="fa-solid fa-user-plus"></i> Register here</a></p>
        </div>
        
    </div>
    <script src="${pageContext.request.contextPath}/js/custom.validation.js"></script>
    <script src="${pageContext.request.contextPath}/js/togglePassword.js"></script>
    <script>
        $(document).ready(function() {
            const urlParams = new URLSearchParams(window.location.search);
            const error = urlParams.get('error');
            if (error === '1') {
            	cuteAlert({
            	      type: "error",
            	      title: "Invalid Credentials",
            	      message: "Email or Password does not match.",
            	      buttonText: "Okay"
            	 })
            }
        });
    </script>
</body>
</html>