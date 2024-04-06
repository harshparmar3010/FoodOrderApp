$('#togglePassword1').click(function() {
    var passwordField = $('#passwordField1');
    var fieldType = passwordField.attr('type');
    if (fieldType === 'password') {
        passwordField.attr('type', 'text');
        $('#togglePassword1 i').removeClass('fa-eye').addClass('fa-eye-slash');
    } else {
        passwordField.attr('type', 'password');
        $('#togglePassword1 i').removeClass('fa-eye-slash').addClass('fa-eye');
    }
});


$('#togglePassword2').click(function() {
    var passwordField = $('#passwordField2');
    var fieldType = passwordField.attr('type');
    if (fieldType === 'password') {
        passwordField.attr('type', 'text');
        $('#togglePassword2 i').removeClass('fa-eye').addClass('fa-eye-slash');
    } else {
        passwordField.attr('type', 'password');
        $('#togglePassword2 i').removeClass('fa-eye-slash').addClass('fa-eye');
    }
});