<%@ page import="ssemi.ssemibucks.PRODUCT.ProductDao" %>
<%@ page import="ssemi.ssemibucks.PRODUCT.Product" %>
<%@ page import="java.util.Vector" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="" />
    <meta name="author" content="" />

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet" />

    <script src="/js/includeHTML.js" type="text/javascript"></script>

    <title>Document</title>

</head>

<body>
    <%
        ProductDao dao = new ProductDao();
        Vector<Product> list = dao.selectAllProduct();
    %>

    <!-- Navbar -->
    <div include-html="/navbar"></div>
    <script>includeHTML();</script>

    <!-- Header-->
    <header class="py-5" style="background-color: rgb(167, 193, 55); height: 200px;">
        <div class="container px-4 px-lg-5 my-5">
            <div class="text-center">
                <h1 class="display-4 fw-bolder" style="line-height: 0px; color: white">All Menu</h1>
            </div>
        </div>
    </header>

    <!-- Section-->
    <section class="py-5">
        <div class="container px-4 px-lg-5 mt-5" style="border: 2px solid white;" >
            <button class="btn" style="float: right;" data-bs-toggle="modal"
                    data-bs-target="#staticBackdrop"><i class="bi bi-plus-circle"></i>
                add</button>

            <!-- 추가 modal -->
            <!-- Modal -->
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false"
                 tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">add</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            상품을 추가하시겠습니까?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary"
                                    onclick="location.href='/product/product_insert';">Add</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"  style="border: 2px solid white; margin-top: 80px;">
                <%
                    for(int i =0; i <list.size(); i++) {
                        Product product = list.get(i);
                %>
                        <div class="col mb-5">
                            <div class="card h-100" id="product" onclick="location.href='/product/product_detail?pId=<%= product.getpId()%>';" style="cursor: pointer;">
                                <!-- Product image-->
                                <img class="card-img-top"
                                     src="<%=product.getpImage() %>"
                                     alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder"><%=product.getpName() %></h5>
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                <%
                    }
                %>

                </div>
            </div>
        </div>
    </section>

</body>

</html>