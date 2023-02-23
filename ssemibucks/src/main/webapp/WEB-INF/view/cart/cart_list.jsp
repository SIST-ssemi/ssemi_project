<%@ page import="java.util.Vector" %>
<%@ page import="ssemi.ssemibucks.USER.UserDao" %>
<%@ page import="ssemi.ssemibucks.USER.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ssemi.ssemibucks.CART.CartDao" %>
<%@ page import="ssemi.ssemibucks.CART.Cart" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Ssemibucks_Cart</title>
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

            var cQTY = parseInt($("#cQTY").val());

            $("#plus").click(function () {
                cQTY += 1;

                $("#cQTY").attr("value", cQTY)
            });

            $("#minus").click(function () {
                cQTY -= 1;

                if (cQTY < 0) {
                    alert("수량을 다시 설정해주세요");
                    cQTY = 0;
                }
                $("#cQTY").attr("value", cQTY)
            });
        });
    </script>

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
<%
    String uId=request.getParameter("uId");
    CartDao dao = new CartDao();
    Vector<Cart> list = dao.selectCart(uId);
%>

<div id="navbar"></div>

<header class="py-5" style="background-color: rgb(167, 193, 55); height: 100px;">
    <h1 class=" display-4 fw-bolder" style="line-height: 0px; text-align: center; color: white">
        CART
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
        <h1 class="text-white fs-3 fw-bolder" style="margin-top: 0px;">uId</h1>
        <p class=" text-white-50 mb-0">uName님의 장바구니</p>
    </div>
</div>

<!-- Content section-->
<div class="container-fluid py-5 col-10">
    <div class="row">
        <div class="col-12">
            <div class="card my-4">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white text-capitalize ps-3">Cart table</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-3">
                        <table class="table align-items-center mb-0" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    category
                                </th>
                                <th colspan="2"
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    product
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    pOption
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    price
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    cQTY
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    EDIT
                                </th>
                            </tr>
                            </thead>

                            <tbody>

                            <%
                                for (int i = 0; i < list.size(); i++) {
                                    Cart cart = list.get(i);
                            %>
                            <tr>
                                <td class="align-middle text-center text-sm">
                                    <%= cart.getCategory()%>
                                </td>
                                <td>
                                <a href="/product/product_detail?pId=<%=cart.getpId() %>">
                                    <div class=" d-flex px-2 py-1">
                                        <div>
                                            <img src="<%=cart.getpImage() %>" class="img-thumbnail avatar avatar-sm me-3 border-radius-lg "
                                                 alt="image" width="60px" height="60px">
                                        </div>
                                        <div class="d-flex flex-column justify-content-center">
                                            <h6 class="mb-0 text-sm"><%=cart.getpName() %></h6>
                                        </div>
                                    </div>
                                </a>
                                </td>
                                <td class="align-middle text-center text-uppercase text-sm">
                                    <span><%=cart.getpOption() %></span>
                                </td>
                                <td class="align-middle text-center text-sm">
                                    <span><%=cart.getPrice() %></span>
                                </td>
                                <td class="align-middle text-center text-sm">
                                    <button class="btn btn-outline-dark flex-shrink-0" type="button" style="margin-right: 5px; border-style: none; width: 35px; height: 35px;"
                                            id="minus">-</button>
                                    <%=cart.getcQty()%>
                                    <button class="btn btn-outline-dark flex-shrink-0" type="button" style="margin-left: 5px; border-style: none; width: 35px; height: 35px;" id="plus">+</button>

                                </td>
                                <td class="align-middle text-center text-sm">
                                    <button class="btn"
                                            onclick="location.href='#'">
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