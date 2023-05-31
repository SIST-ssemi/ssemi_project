<%@ page import="ssemi.ssemibucks.USER.UserDao" %>
<%@ page import="org.springframework.ui.context.support.UiApplicationContextUtils" %>
<%@ page import="ssemi.ssemibucks.USER.User" %>
<%@ page import="ssemi.ssemibucks.USER.UserService" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<%
    String uId = request.getParameter("uId");
    UserService service = new UserService();
//    User user = userDao.findByUser(uId);
//    String realpw = user.getPw();
%>
<script>
    var a = prompt("비밀번호를 입력해주세요.");
    if (a === "q") {
        <%service.deleteUser(uId);%>
        // alert("정상적으로 탈퇴되었습니다.");
        location.href = "/user/user_signout";
    } else {
        alert("비밀번호가 일치하지 않습니다.");
        history.back();
    }
</script>

</body>
</html>