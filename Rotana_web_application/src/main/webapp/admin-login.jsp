
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>Rotana || Login</title>
    <meta content="Responsive admin theme build on top of Bootstrap 4" name="description" />
    <meta content="Fabrice Nduwayo" name="author" />
    <link rel="shortcut icon" href="resources/assets/images/mum.png">

    <link href="resources/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="resources/assets/css/metismenu.min.css" rel="stylesheet" type="text/css">
    <link href="resources/assets/css/icons.css" rel="stylesheet" type="text/css">
    <link href="resources/assets/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="accountbg"></div>
<div class="home-btn d-none d-sm-block">
    <a href="/admin-login" class="text-white"><i class="fas fa-home h2"></i></a>
</div>
<div class="wrapper-page">
    <div class="card card-pages shadow-none">

        <div class="card-body">
            <div class="text-center m-t-0 m-b-15">
                <a href="/admin-login" class="logo logo-admin"><img src="resources/assets/images/mum.png" alt="" height="24"></a>
            </div>
            <h5 class="font-18 text-center">Sign in to continue to Rotana.</h5>

            <form class="form-horizontal m-t-30" action="admin-login" method="post">
                <div class="form-group">
                    <div class="col-12">
                        <label for="username">Username</label>
                        <input class="form-control" type="text" name="username" required placeholder="Username" id="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-12">
                        <label for="password">Password</label>
                        <input class="form-control" type="password" name="password" required placeholder="Password" id="password"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-12">
                        <div class="checkbox checkbox-primary">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="customCheck1">
                                <label class="custom-control-label" for="customCheck1"> Remember me</label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group text-center m-t-20">
                    <div class="col-12">
                        <button class="btn btn-primary btn-block btn-lg waves-effect waves-light" type="submit">Log In</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
<script src="resources/assets/js/jquery.min.js"></script>
<script src="resources/assets/js/bootstrap.bundle.min.js"></script>
<script src="resources/assets/js/metismenu.min.js"></script>
<script src="resources/assets/js/jquery.slimscroll.js"></script>
<script src="resources/assets/js/waves.min.js"></script>
<script src="resources/assets/js/app.js"></script>
</body>
</html>
