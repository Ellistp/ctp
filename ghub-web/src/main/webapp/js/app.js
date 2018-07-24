login = function () {
    $.ajax({
        type: "POST",
        dataType: "json",
        contentType : 'application/json;charset=UTF-8',
        url: "http://localhost:8777/api/ghub/security/login",
        data: JSON.stringify({
            "userName":$("#userName").val(),
            "passWord":$("#passWord").val()
        }),
        success: function (result) {
            if(result.errorMsg != null){
                alert(result.errorMsg);
            }else {
                alert("登录成功!");
            }
        },
        error : function() {
            alert("登录失败!");
        }
    });
}