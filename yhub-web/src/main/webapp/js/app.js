$(function () {
    $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
    $(window).resize(function () {
        $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
    })
});

loginForm = function () {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/api/user/login",
        data: {
            "username":$("#username").val(),
            "password":$("#password").val()
        },
        success: function () {
            alert("登录成功!");
        },
        error : function() {
            alert("登录失败!");
        }
    });
}