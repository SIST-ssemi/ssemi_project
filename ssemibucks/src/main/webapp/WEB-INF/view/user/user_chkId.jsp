<%@ page import="ssemi.ssemibucks.USER.UserDao" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ssemibucks_chkId</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
    <style>
        table {
            margin: 20px;
            border-style: none;
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
<script>
    $(function () {
        var chkId = opener.$("#uId").val();
        $("#chkId").val(chkId);
    })
</script>
<%
    UserDao dao = new UserDao();
%>
<body>
<form action="/user/user_chkIdAction" method="post">
    <table class="table" style="width: 100%; height: 100%; border-style: none">
        <tr style="border-style: none">
            <td align="center" style="border-style: none">
                <h3 style="color: rgb(167, 193, 55); font-weight: bold">Press Check button</h3>
                <br><br>
                <input type="text" name="chkId" id="chkId" style="width: 100px" readonly>
                <button type="submit" class="btn btn-sm mybtn">Check</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>