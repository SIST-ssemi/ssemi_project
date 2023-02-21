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

        .mybtn {
            background-color: rgb(167, 193, 55);
            border: rgb(167, 193, 55);
            color: white;
            margin-left: 20px;
        }

        .mybtn:hover,
        .mybtn:active,
        .mybtn:focus {
            background-color: white;
            color: rgb(167, 193, 55);
            border: 1px solid rgb(167, 193, 55);
        }
    </style>
</head>
<%
    String msg = request.getParameter("msg");
%>
<body>
<div class="content">
    <div class="header" style="padding: 35px 50px">
        <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
    </div>
    <div class="body" style="padding: 40px 50px">
        <form action="/user/loginAction" method="post">
            <div class="form-group">
                <label for="username"><span class="glyphicon glyphicon-user"></span> UserID</label>
                <input name="uId" type="text" class="form-control" id="username" placeholder="Enter userID"/>
            </div>
            <div class="form-group">
                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>
                    Password</label>
                <input name="pw" type="password" class="form-control" id="psw" placeholder="Enter password"/>
            </div>
            <button type="submit" class="btn btn-success btn-block"
                    style="background-color: rgb(167, 193, 55); border: rgb(167, 193, 55)">
                <span style="height: 30px; font-size: 1.2em">Login</span>
            </button>
        </form>
    </div>
    <div class="footer">
        <p style="margin-left: 50px">
            Not a member? <a href="/user/register">Sign Up</a>
        </p>
    </div>
    <div style="float: right">
        <button type="button" class="btn mybtn" onclick="history.back()" style="margin-right: 50px">Back</button>
    </div>
</div>
</body>

</html>