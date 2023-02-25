<%@ page import="java.util.Vector" %>
<%@ page import="ssemi.ssemibucks.USER.UserDao" %>
<%@ page import="ssemi.ssemibucks.USER.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ssemi.ssemibucks.CART.CartDao" %>
<%@ page import="ssemi.ssemibucks.CART.Cart" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.NumberFormat" %>
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
            $("#dataTable").DataTable({
                ordering: false
            });

            $("#navbar").load("/navbar");

            $(".plus").click(function () {
                var cQTY = $(this).parent("div").find("input").val();
                $(this).parent("div").find("input").val(++cQTY);
            });

            $(".minus").click(function () {
                var cQTY = $(this).parent("div").find("input").val();
                if (cQTY > 1) {
                    $(this).parent("div").find("input").val(--cQTY);
                }
            });
        });
    </script>
</head>

<body>
<%
    String uId = request.getParameter("uId");
    CartDao dao = new CartDao();
    Vector<Cart> list = dao.selectCart(uId);

    DecimalFormat df = new DecimalFormat("###,###");
    int tot = 0;

    NumberFormat nf = NumberFormat.getCurrencyInstance();
%>

<div id="navbar"></div>

<header class="py-5" style="background-color: rgb(167, 193, 55); height: 100px;">
    <h1 class=" display-4 fw-bolder" style="line-height: 0px; text-align: center; color: white">
        CART
    </h1>
</header>

<!-- Content section-->
<div class="container-fluid py-5 col-10">
    <div class="row">
        <div class="col-12">
            <div class="card my-4">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white ps-3"><%=uId%> 's CartList</h6>
                    </div>
                </div>

                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-3">
                        <table class="table align-items-center mb-0" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    cId
                                </th>
                                <th
                                        class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
                                    category
                                </th>
                                <th
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
                                    <%= i + 1%>
                                </td>
                                <td class="align-middle text-center text-sm">
                                    <%= cart.getCategory()%>
                                </td>
                                <td style="width: 280px">
                                    <a href="/product/product_detail?pId=<%=cart.getpId() %>">
                                        <div class=" d-flex px-2 py-1">
                                            <div>
                                                <img src="<%=cart.getpImage() %> "
                                                     class="img-thumbnail avatar avatar-sm me-3 border-radius-lg"
                                                     alt="image" width="60px" height="60px">
                                            </div>
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-sm"><%=cart.getpName() %>
                                                </h6>
                                            </div>
                                        </div>
                                    </a>
                                </td>

                                <td class="align-middle text-center text-uppercase text-sm">
                                    <span><%=cart.getpOption() %></span>
                                </td>
                                <td class="align-middle text-center text-sm">
                                    <span><%=nf.format(cart.getPrice())%></span>
                                </td>

                                <form action="/cart/cart_updateAction" method="post">
                                    <input type="hidden" value="<%=cart.getcQty()%>" name="pStock">
                                    <input type="hidden" value="<%=cart.getpId()%>" name="pId">
                                    <input type="hidden" value="<%=cart.getuId()%>" name="uId">
                                    <td class="align-middle text-center text-sm" style="width: 300px;">
                                        <div class="d-flex">
                                            <button class="btn btn-outline-dark flex-shrink-0 minus" type="button"
                                                    style="margin-left: 90px; margin-right: 5px; border-style: none; width: 35px; height: 35px;">
                                                -
                                            </button>
                                            <input type="text" class="form-control text-center"
                                                   value="<%=cart.getcQty()%>" id="cQTY" name="cQTY"
                                                   style="width: 50px;" readonly>
                                            <button class="btn btn-outline-dark flex-shrink-0 plus" type="button"
                                                    style="margin-left: 5px; border-style: none; width: 35px; height: 35px;">
                                                +
                                            </button>
                                        </div>
                                        </a>
                                    </td>


                                    <td class="align-middle text-center text-sm" style="width: 300px;">
                                        <button type="submit" class="btn"><i class="bi bi-pencil"></i>
                                            update
                                        </button>
                                </form>
                                <button class="btn"
                                        onclick="location.href='/cart/cart_delete?cId=<%=cart.getcId()%>'">
                                    <i class="bi bi-trash"></i>
                                    delete
                                </button>

                                </td>

                            </tr>

                            <%
                                    tot += cart.getcQty() * cart.getPrice();
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div>
        <button type="button" class="btn btn-primary" style="float: right; margin-left: 10px;"><i
                class="bi bi-credit-card"></i> order
        </button>
    </div>
    <div class="total text-center"
         style="float: right; width: 200px; height: 35px; border: 2px solid #e2e2e2; background-color: #e2e2e2">


        <p><span><strong>Total : </strong></span><span>￦<%=df.format(tot) %></span></p>
    </div>

</div>
</body>
</html>