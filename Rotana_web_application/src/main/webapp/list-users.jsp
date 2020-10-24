<%@ page import="edu.miu.cs.controller.user.UserController" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.miu.cs.domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head><%----%>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>Rotana || Users</title>
    <meta content="Responsive admin theme build on top of Bootstrap 4" name="description"/>
    <meta content="Fabrice Nduwayo" name="author"/>
    <link rel="shortcut icon" href="resources/assets/images/favicon.ico">

    <link href="resources/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="resources/assets/css/metismenu.min.css" rel="stylesheet" type="text/css">
    <link href="resources/assets/css/icons.css" rel="stylesheet" type="text/css">
    <link href="resources/assets/css/style.css" rel="stylesheet" type="text/css">

</head>

<body>
<%
    Object object = session.getAttribute("admin");
    if (object == null) {
        response.sendRedirect("/admin-login");
    }
%>
<div class="header-bg">
    <header id="topnav">
        <div class="topbar-main">
            <div class="container-fluid">
                <div>
                    <a href="/admin-dashboard" class="logo">
                        <span class="logo-light">
                            <i class="mdi mdi-camera-control"></i> Rotana
                        </span>
                    </a>
                </div>
                <div class="menu-extras topbar-custom navbar p-0">
                    <ul class="navbar-right ml-auto list-inline float-right mb-0">
                        <li class="dropdown notification-list list-inline-item d-none d-md-inline-block">
                            <a class="nav-link waves-effect" href="/admin-dashboard" id="btn-fullscreen">
                                <i class="mdi mdi-arrow-expand-all noti-icon"></i>
                            </a>
                        </li>
                        <li class="dropdown notification-list list-inline-item">
                            <div class="dropdown notification-list nav-pro-img">
                                <a class="dropdown-toggle nav-link arrow-none nav-user" data-toggle="dropdown"
                                   href="javascript:void(0)" role="button" aria-haspopup="false" aria-expanded="false">
                                    <img src="resources/assets/images/users/user-4.jpg" alt="user"
                                         class="rounded-circle">
                                </a>
                                <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                                    <a class="dropdown-item text-danger" href="/admin-logout"><i
                                            class="mdi mdi-power text-danger"></i> Logout</a>
                                </div>
                            </div>
                        </li>
                        <li class="menu-item dropdown notification-list list-inline-item">
                            <a class="navbar-toggle nav-link">
                                <div class="lines">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="navbar-custom">
            <div class="container-fluid">
                <div id="navigation">
                    <ul class="navigation-menu">
                        <li class="has-submenu">
                            <a href="/admin-dashboard"><i class="icon-accelerator"></i> Dashboard</a>
                        </li>
                        <li class="has-submenu">
                            <a href="/users"><i class="icon-profile"></i> Users</a>
                        </li>
                        <li class="has-submenu">
                            <a href="/advertisements"><i class="icon-paper-pen"></i> Advertisements</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
</div>

<div class="wrapper">
    <div class="container-fluid">
        <div class="page-title-box">
            <div class="row align-items-center">
                <div class="col-sm-6">
                    <h4 class="page-title">Manage users</h4>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-right">
                        <li class="breadcrumb-item"><a href="/admin-dashboard">Rotana</a></li>
                        <li class="breadcrumb-item"><a href="javascript:void(0);">Users</a></li>
                    </ol>
                </div>
            </div>
        </div>

        <div class="row hidden" id="form_container">
            <div class="col-12">
                <div class="card m-b-30">
                    <div class="card-body">
                        <form action="users" method="post" id="save_user">
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="firstName">First Name <span class="text-danger">*</span></label>
                                        <input type="text" name="firstName" id="firstName" class="form-control"
                                               placeholder="Enter first name" required/>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="lastName">Last Name <span class="text-danger">*</span></label>
                                        <input type="text" name="lastName" id="lastName" class="form-control"
                                               placeholder="Enter last name" required/>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="email">Email <span class="text-danger">*</span></label>
                                        <input type="text" name="email" id="email" class="form-control"
                                               placeholder="Enter last name" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="gender">Gender <span class="text-danger">*</span></label>
                                        <select name="gender" id="gender" class="form-control">
                                            <option disabled selected>--select gender--</option>
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                            <option value="Other">Other</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="password">Password <span class="text-danger">*</span></label>
                                        <input type="password" name="password" id="password" class="form-control"
                                               placeholder="Enter password" required/>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="confirmPassword">Confirm password <span class="text-danger">*</span></label>
                                        <input type="password" name="confirmPassword" id="confirmPassword" class="form-control"
                                               placeholder="Enter confirm password" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col pull-right">
                                    <button type="submit" class="btn btn-primary ">
                                        <i class="fa fa-save"></i>
                                        SUBMIT
                                    </button>
                                    <button type="submit" class="btn btn-secondary" id="hide_form">
                                        <i class="fa fa-stop"></i>
                                        CANCEL
                                    </button>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row" id="view_container">
            <div class="col-12">
                <div class="card m-b-30">
                    <div class="card-body">
                        <h5 class="card-header">
                            List of users
                            <button class="btn btn-primary" id="show_form">
                                <i class="fa fa-plus-circle"></i>
                                New User
                            </button>
                        </h5>
                        <hr class="hr-line">
                        <div class="table-responsive">
                            <table class="table table-striped mb-0" id="records_table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Gender</th>
                                    <th>Email</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    List<User> users = (List<User>) request.getAttribute("users");
                                    for (User user : users) {
                                %>
                                <tr>
                                    <th><%=user.getId()%></th>
                                    <td><%=user.getFirstName()%></td>
                                    <td><%=user.getLastName()%></td>
                                    <td><%=user.getGender()%></td>
                                    <td><%=user.getEmail()%></td>
                                    <td id="user_data_<%=user.getId()%>">
                                        <%if(user.isActive()){%>
                                            <a href="javascript:void(0)" class="btn btn-success btn-sm"
                                               title="Active" onclick="changeStatus(<%=user.getId()%>)">
                                                <i class="fa fa-check"></i>
                                            </a>
                                        <%}else{%>
                                            <a href="javascript:void(0)" class="btn btn-danger btn-sm"
                                               title="Inactive" onclick="changeStatus(<%=user.getId()%>)">
                                                <i class="fa fa-times"></i>
                                            </a>
                                        <%}%>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<footer class="footer">
    © 2020 Rotana <span class="d-none d-sm-inline-block"></span>.
</footer>
<script src="resources/assets/js/jquery.min.js"></script>
<script src="resources/assets/js/bootstrap.bundle.min.js"></script>
<script src="resources/assets/js/jquery.slimscroll.js"></script>
<script src="resources/assets/js/waves.min.js"></script>
<script src="resources/assets/js/app.js"></script>
<script src="resources/assets/js/custom.js"></script>
</body>
</html>