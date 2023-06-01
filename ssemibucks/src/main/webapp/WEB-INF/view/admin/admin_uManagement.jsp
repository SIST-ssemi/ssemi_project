<%@ page import="ssemi.ssemibucks.PRODUCT.Product" %>
<%@ page import="java.util.Vector" %>
<%@ page import="ssemi.ssemibucks.USER.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ssemi.ssemibucks.USER.UserService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Ssemibucks_UserMangement</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <script src="/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet"/>

    <title>Document</title>

    <script>
        $(function () {
            $("#dataTable").DataTable({
                ordering: false
            });
            $("#navbar").load("/navbar");
        });
    </script>
</head>

<body>

<div id="navbar"></div>

<header class="py-5" style="background-color: rgb(167, 193, 55); height: 100px;">
    <h1 class=" display-4 fw-bolder" style="line-height: 0px; text-align: center; color: white">
        User Management
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
        <h1 class="text-white fs-3 fw-bolder" style="margin-top: 0px;">ADMIN</h1>
        <p class=" text-white-50 mb-0">관리자 계정</p>
    </div>
</div>

<!-- Content section-->
<div class="container-fluid py-5 col-10">
    <div class="row">
        <div class="col-12">
            <div class="card my-4">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white text-capitalize ps-3">Users table</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-3">
                        <table class="table align-items-center mb-0" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    USERID
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    USERNAME
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    PASSWORD
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    HP
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    ADDRESS
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    EDIT
                                </th>
                            </tr>
                            </thead>

                            <tbody>

                            <%
                                List<User> list=(List<User>)request.getAttribute("userList");
                                for (int i = 0; i < list.size(); i++) {
                                    User user = list.get(i);
                            %>
                            <tr>
                                <td class="align-middle text-center text-sm">
                                    <%= user.getuId()%>
                                </td>
                                <td class="align-middle text-center text-sm">
                                    <span><%=user.getuName() %></span>
                                </td>
                                <td class="align-middle text-center text-sm">
                                    <span><%=user.getPw() %></span>
                                </td>
                                <td class="align-middle text-center text-sm">
                                    <span><%=user.getHp() %></span>
                                </td>
                                <td class="align-middle text-center text-sm">
                                    <span><%=user.getAddr() %></span>
                                </td>
                                <td class="align-middle text-center text-sm" style="width: 300px;">
                                    <button class="btn"
                                            onclick="location.href='/admin/admin_userKickoutAction?uId=<%=user.getuId()%>'">
                                        <i class="bi bi-trash"></i>
                                        delete
                                    </button>
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
</body>
</html>