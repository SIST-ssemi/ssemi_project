<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>LogIn_ssemibuck</title>
    <style>
        .header,
        h4,
        .close {
            background-color: rgb(167, 193, 55);;
            color: white !important;
            text-align: center;
            font-size: 30px;
        }

        .footer {
            background-color: #f9f9f9;
        }
    </style>
</head>

<body>

    <div class="content">
        <div class="header" style="padding: 35px 50px">
            <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="body" style="padding: 40px 50px">
            <form action="loginAction" method="post">
            <div class="form-group">
                <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                <input name="uId" type="text" class="form-control" id="usrname" placeholder="Enter email"/>
            </div>
            <div class="form-group">
                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>
                    Password</label>
                <input name="pw" type="text" class="form-control" id="psw" placeholder="Enter password"/>
            </div>
            <button type="submit" class="btn btn-success btn-block"
                    style="background-color: rgb(167, 193, 55); border: rgb(167, 193, 55)">
                <span style="height: 30px; font-size: 1.2em">Login</span>
            </button>
            </form>
        </div>
        <div class="footer">
            <p style="margin-left: 50px">
                Not a member? <a href="register">Sign Up</a>
            </p>
        </div>
    </div>

</body>

</html>