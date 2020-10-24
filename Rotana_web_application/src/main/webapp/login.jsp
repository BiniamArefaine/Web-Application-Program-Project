
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <title>Welcome Page</title>
    <link rel="stylesheet" href="resources/css/main.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/color.css">
    <link rel="stylesheet" href="resources/css/responsive.css">
</head>
<body>
<div class="theme-layout">
    <div class="container-fluid pdng0">
        <div class="row merged">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                <div class="land-featurearea">
                    <%--                    <img src="resources/images/image.png" alt="">--%>
                    <div class="land-meta">
                        <h1>ROTANA:: </h1><hr />
                        <h1>
                            Discover the World. <br >Meet new Friends. And Let's Have Fun.
                        </h1>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                <div class="login-reg-bg">
                    <div class="log-reg-area sign">
                        <h2 class="log-title">Login</h2>
                        <form method="post" action="login">
                            <div class="form-group">
                                <input type="text" id="input" name="username" required="required"/>
                                <label class="control-label" for="input">Username</label><i class="mtrl-select"></i>
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" required="required"/>
                                <label class="control-label" for="input">Password</label><i class="mtrl-select"></i>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" checked="checked" name="remember_me"/><i class="check-box"></i>Always Remember Me.
                                </label>
                            </div>
                            <a href="#" title="" class="forgot-pwd">Forgot Password?</a>
                            <div class="submit-btns">
                                <button class="mtr-btn signin" type="submit"><span>Login</span></button>
                                <a href='list-users.jsp'><button class="mtr-btn" type="button"><span>Register</span></button></a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script data-cfasync="false" src="resources/js/email-decode.min.js"></script>
<script src="resources/js/main.min.js"></script>
<script src="resources/js/script.js"></script>
</body>
</html>
