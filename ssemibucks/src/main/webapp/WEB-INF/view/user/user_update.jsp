<%@ page import="ssemi.ssemibucks.USER.UserDao" %>
<%@ page import="ssemi.ssemibucks.USER.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Ssemibucks_UpdateUser</title>
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        body {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        .title {
            background-color: rgb(167, 193, 55);
            color: white;
            text-align: center;
            height: 125px;
        }

        .title h1 {
            line-height: 125px;
        }

        .table {
            width: 800px;
            height: 400px;
            margin-top: 50px;
        }

        th {
            width: 150px;
            text-align: center;
        }

        td {
            width: 300px;
        }

        input {
            width: 300px;
            height: 30px;
            border: 1px solid rgba(0, 0, 0, 0.1);
            border-radius: 3px;
        }

        .mybtn {
            background-color: rgb(167, 193, 55);
            border: rgb(167, 193, 55);
            color: white;
            margin: 10px;
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
    String uId = request.getParameter("uId");
    UserDao userDao = new UserDao();
    User user = userDao.selectUser(uId);
%>
<body>
<div class="title"><h1>Update User</h1></div>
<form action="/user/user_updateAction" METHOD="post">
    <table class="table table-stripped" align="center">
        <tr>
            <form id>
                <div class="uId">
                    <th style="vertical-align: middle">UserID</th>
                    <td style="vertical-align: middle">
                        <input type="text" style="color: rgba(0,0,0,0.3)" name="uId" id="uId" placeholder="Enter UserID"
                               required="required" value="<%=user.getuId()%>" readonly/>
                    </td>
                </div>
            </form>
        </tr>
        <tr>
            <div class="pw">
                <th style="vertical-align: middle">Password</th>
                <td style="vertical-align: middle">
                    <input type="password" name="pw" placeholder="Enter Password" value="<%=user.getPw()%>"
                           required="required"/>
                </td>
            </div>
        </tr>
        <tr>
            <div class="uName">
                <th style="vertical-align: middle">UserName</th>
                <td style="vertical-align: middle">
                    <input type="text" name="uName" style="color: rgba(0,0,0,0.3)" placeholder="Enter UserName"
                           value="<%=user.getuName()%>" required="required" readonly/>
                </td>
            </div>
        </tr>
        <tr>
            <div class="hp">
                <th style="vertical-align: middle">HP</th>
                <td style="vertical-align: middle">
                    <input
                            type="text" name="hp"
                            placeholder="Enter HP (without ' - ')" required="required" value="<%=user.getHp()%>"
                    />
                </td>
            </div>
        </tr>
        <tr>
            <div class="addr">
                <th style="vertical-align: middle">Address</th>
                <td style="vertical-align: middle">
                    <input type="text" name="addr" placeholder="Enter Address" value="<%=user.getAddr()%>"
                           required="required"/>
                </td>
            </div>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit" id="update" class="btn mybtn">Update</button>
                <button type="button" class="btn mybtn" onclick="history.back()">Cancel</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
