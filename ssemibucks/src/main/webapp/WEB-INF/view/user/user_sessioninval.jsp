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
    session.invalidate();

    response.sendRedirect("/index");
%>
</body>
</html>