<%@ page import="ssemi.ssemibucks.USER.User" %>
<%@ page import="ssemi.ssemibucks.USER.UserDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Ssemibucks_MyPage</title>

    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet"/>

    <script src="/js/includeHTML.js" type="text/javascript"></script>
</head>
<%
    String uId = (String) session.getAttribute("uId");
    UserDao dao = new UserDao();
    User user = dao.selectUser(uId);
%>
<body>
<!-- Navbar -->
<div include-html="/navbar"></div>
<script>includeHTML();</script>

<header class="py-5" style="background-color: rgb(167, 193, 55); height: 100px;">
    <h1 class=" display-4 fw-bolder" style="line-height: 0px; text-align: center; color: white">
    </h1>
</header>

<div class="py-0">
    <div class="text-center " style="
          background-image: linear-gradient(
              rgba(0, 0, 0, 0.3),
              rgba(0, 0, 0, 0.3)
            ),
            url(https://images.unsplash.com/photo-1580933073521-dc49ac0d4e6a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869&q=80);
        ">
        <img class="rounded-circle mt-sm-4" src="/img/user.JPG" alt="..." width="120px" height="120px"
             style="margin-top: 2rem;"/>
        <h1 class="text-white fs-3 fw-bolder" style="margin-top: 0px;"><%=user.getuId()%>
        </h1>
        <p class=" text-white-50 mb-0"><%=user.getuName()%>님, 환영합니다</p>
    </div>
</div>
<!-- Content section-->
<div class="container my-5">
    <!-- <div class="row justify-content-center"> -->
    <div class="col-lg text-xl-center">
        <h1>My Information</h1>
        <hr/>
        <form action="user_delete" method="post">
            <table class="table table-stripped" align="center">
                <tr>
                    <div class="uId">
                        <th style="vertical-align: middle">아이디</th>
                        <td style="vertical-align: middle"><%=user.getuId()%>
                        </td>
                    </div>
                </tr>
                <tr>
                    <div class="pw">
                        <th style="vertical-align: middle">비밀번호</th>
                        <td style="vertical-align: middle"><%=user.getPw()%>
                        </td>
                    </div>
                </tr>
                <tr>
                    <div class="uName">
                        <th style="vertical-align: middle">이름</th>
                        <td style="vertical-align: middle"><%=user.getuName()%>
                        </td>
                    </div>
                </tr>
                <tr>
                    <div class="hp">
                        <th style="vertical-align: middle">전화번호</th>
                        <td style="vertical-align: middle"><%=user.getHp()%>
                        </td>
                    </div>
                </tr>
                <tr>
                    <div class="addr">
                        <th style="vertical-align: middle">주소</th>
                        <td style="vertical-align: middle"><%=user.getAddr()%>
                        </td>
                    </div>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button
                                type="button"
                                class="btn btn-primary"
                                onclick="location.href='/user/user_update?uId=<%=user.getuId()%>'"
                        >
                            정보수정
                        </button>
                        <button
                                type="button"
                                class="btn btn-primary"
                                onclick="location.href='/user/user_deleteAction?uId=<%=user.getuId()%>'"
<%--                                onclick="location.href='/user/user_delete?uId=<%=user.getuId()%>'"--%>
                        >
                            회원탈퇴
                        </button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!-- </div> -->
</div>

<!-- Bootstrap core JS-->
</body>
</html>
