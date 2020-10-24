<%----%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
    <style>

        .form-group {

            display: block;


            border: solid 3px #b1dfbb;


        }

        .postion {
            width: 400px;
            marrgin: auto;
            border: solid 2px #0a98dc;
            position: center;

        }



    </style>
    <link href="userprofile.jsp">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <img id="loading" src="https://www.google.com/search?q=wait+loading+gif&tbm=isch&source=iu&ictx=1&fir=QIOAHrHmlwTnfM%253A%252C-M9VS2y-he5F1M%252C_&vet=1&usg=AI4_-kSFjT9tupoJ4XATYB3a5Y653Zu4MA&sa=X&ved=2ahUKEwi_2s3GrOjkAhVLh-AKHSC0BBsQ9QEwCHoECAcQFA#imgrc=MPbFAq7cnYfHrM:&vet=1">
</head>
<body>
<div class="right">
    <form action="userprofile" class="postion">
        <div>
            <label>First Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="FirstName" name="fname" required>

        </div>
        <div>
            <label>Last Name</label>
            <input type="text" class="form-control" id="exampleInputEmail11" aria-describedby="emailHelp"
                   placeholder="LastName" name="laname" required>

        </div>
        <div>
            <label>Email</label>
            <input type="email" class="form-control" id="exampleInputEmail111" aria-describedby="emailHelp"
                   placeholder="---@gmail" name="Email" required>

        </div>
        <div>
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pass"
                   required>
        </div>

        <div>
            <label for="exampleInputPassword1">Repeat</label>
            <input type="password" class="form-control" id="exampleInputPassword11" placeholder="Password"
                   name="repass">
        </div>

        <button type="submit" class="btn btn-primary" id="submituser">Submit</button>
    </form>
</div>
</body>
</html>
