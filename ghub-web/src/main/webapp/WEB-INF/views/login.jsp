<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
    <title>welcome to ghub!</title>
    <meta name="description" content="ghub project"/>
    <meta name="author" content="chengtianping"/>
    <meta name="keyword" content="spring mvc"/>

    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/css/bootstrap-responsive.min.css" rel="stylesheet"/>
    <link href="${ctx}/css/style.min.css" rel="stylesheet"/>
    <link href="${ctx}/css/style-responsive.min.css" rel="stylesheet"/>
    <link href="${ctx}/css/retina.css" rel="stylesheet"/>


    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"/>
    <link id="ie-style" href="${ctx}/css/ie.css" rel="stylesheet"/>

    <!--[if IE 9]>
    <link id="ie9style" href="${ctx}/css/ie9.css" rel="stylesheet">
    <![endif]-->

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/ico/apple-touch-icon-144-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/ico/apple-touch-icon-114-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/ico/apple-touch-icon-72-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" href="${ctx}/ico/apple-touch-icon-57-precomposed.png"/>
    <link rel="shortcut icon" href="${ctx}/ico/favicon.png"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>

<body>
<div class="container-fluid-full">
    <div class="row-fluid">
        <div class="row-fluid">
            <div class="login-box">
                <h2>Login to your account</h2>
                <form class="form-horizontal" id="loginForm" method="post">
                    <fieldset>
                        <input class="input-large span12" name="userName" id="userName" type="text" placeholder="type username"/>
                        <input class="input-large span12" name="passWord" id="passWord" type="password" placeholder="type password"/>

                        <div class="clearfix"></div>
                        <label class="remember" for="remember"><input type="checkbox" id="remember"/>Remember me</label>
                        <div class="clearfix"></div>
                        <button type="button" id="loginButton" class="btn btn-primary span12" onclick="javascript:login();">Login</button>
                    </fieldset>
                </form>
                    <hr/>
                    <h3>Forgot Password?</h3>
                    <p>
                        No problem, <a href="#">click here</a> to get a new password.
                    </p>
            </div>
        </div>
    </div>
</div>

<script src="${ctx}/js/jquery-3.3.1.js"/>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"/>
<script src="${ctx}/js/jquery-ui-1.10.3.custom.min.js"/>
<script src="${ctx}/js/jquery.ui.touch-punch.js"/>
<script src="${ctx}/js/modernizr.js"/>
<script src="${ctx}/js/bootstrap.min.js"/>
<script src="${ctx}/js/jquery.cookie.js"/>
<script src='${ctx}/js/fullcalendar.min.js'/>
<script src='${ctx}/js/jquery.dataTables.min.js'/>
<script src="${ctx}/js/excanvas.js"/>
<script src="${ctx}/js/jquery.flot.js"/>
<script src="${ctx}/js/jquery.flot.pie.js"/>
<script src="${ctx}/js/jquery.flot.stack.js"/>
<script src="${ctx}/js/jquery.flot.resize.min.js"/>
<script src="${ctx}/js/jquery.flot.time.js"/>
<script src="${ctx}/js/jquery.chosen.min.js"/>
<script src="${ctx}/js/jquery.uniform.min.js"/>
<script src="${ctx}/js/jquery.cleditor.min.js"/>
<script src="${ctx}/js/jquery.noty.js"/>
<script src="${ctx}/js/jquery.elfinder.min.js"/>
<script src="${ctx}/js/jquery.raty.min.js"/>
<script src="${ctx}/js/jquery.iphone.toggle.js"/>
<script src="${ctx}/js/jquery.uploadify-3.1.min.js"/>
<script src="${ctx}/js/jquery.gritter.min.js"/>
<script src="${ctx}/js/jquery.imagesloaded.js"/>
<script src="${ctx}/js/jquery.masonry.min.js"/>
<script src="${ctx}/js/jquery.knob.modified.js"/>
<script src="${ctx}/js/jquery.sparkline.min.js"/>
<script src="${ctx}/js/counter.min.js"/>
<script src="${ctx}/js/raphael.2.1.0.min.js"/>
<script src="${ctx}/js/justgage.1.0.1.min.js"/>
<script src="${ctx}/js/jquery.autosize.min.js"/>
<script src="${ctx}/js/retina.js"/>
<script src="${ctx}/js/jquery.placeholder.min.js"/>
<script src="${ctx}/js/wizard.min.js"/>
<script src="${ctx}/js/core.min.js"/>
<script src="${ctx}/js/charts.min.js"/>
<script src="${ctx}/js/custom.min.js"/>
<%--<script src="${ctx}/js/app.js"/>--%>
<script>
  function login() {
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
</script>
</body>
</html>