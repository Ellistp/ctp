login = function () {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/api/ghub/security/login",
        data: $('#loginForm').serialize(),
        success: function (result) {
            console.log(result);
                alert("SUCCESS");
        },
        error : function() {
            alert("异常！");
        }
    });
}