
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
        .tableuser{

            position: center;

        }
        .odd{
            background-color: #b1dfbb;
            color: black;

        }
        .even{

            background-color: #1b1e21;
             color: #b1dfbb;
        }

    </style>
</head>
<body>
<form action="/usermanagment" method="post">
<div class="tableuser">
<table>
<tr>
    <td>FirstName</td>
    <td>LastName</td>
    <td>Email</td>
    <td>Gender</td>
    <td>Status</td>
</tr>
    <c:foreach var="user" item="${userlist}" varstatus="counter">

    <tr <c:if test="$counter.count % 2==0">class="even"</c:if></tr>
     <tr <c:if test="$counter.count % 2!=0">class="odd"</c:if></tr>
      <td>${user.FirstName}</td>
       <td>${user.LastName}</td>
        <td>${user.Email}</td>
          <td>${user.Gender}
           mail<input type="Radio" name="mail">
              femail <input type="radio" name="femail">
          </td
        <td>${user.Status}
            Active<input type="radio" name="active">
            deactive <input type="radio" name="active">
        </td>
    </c:foreach>
</table>
    <button type="submit" class="btn btn-primary" id="submituser">Save</button>
</div>


</form>

</body>


</html>
<%----%>