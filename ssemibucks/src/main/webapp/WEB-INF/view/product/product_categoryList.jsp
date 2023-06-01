<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content=""/>
    <meta name="author" content=""/>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet"/>

    <script src="/js/includeHTML.js" type="text/javascript"></script>

    <title>Document</title>

</head>

<body>

<!-- Navbar -->
<div include-html="/navbar"></div>
<script>includeHTML();</script>

<!-- Header-->
<header class="py-5" style="background-color: rgb(167, 193, 55); height: 200px;">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center">
            <h1 class="display-4 fw-bolder" style="line-height: 0px; color: white">${category}
            </h1>
        </div>
    </div>
</header>

<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5" style="border: 2px solid white;">
        <button class="btn" onclick="location.href='javascript:history.back();'" style="margin-bottom: 20px;"><i
                class="bi bi-arrow-left-circle"></i> back
        </button>

        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
             style="border: 2px solid white; margin-top: 80px;">
            <c:if test="${products.size() != 0 }">
            <c:forEach var="product" items="${products }">
            <div class="col mb-5">
                <div class="card h-100" id="product" style="cursor: pointer;">
                    <!-- Product image-->
                    <img class="card-img-top"
                         src="${product.getPImage() }"
                         alt="..."
                         onclick="location.href='/product/product_detail?pId=${product.getPId() }'"/>
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">${product.getPName() }
                            </h5>
                        </div>
                    </div>

                    <!-- Product actions-->
                    <form action="/cart/cart_insertAction" method="post">
                        <input type="hidden" name="pId" value="${product.getPId() }">
                        <input type="hidden" name="cQTY" value=1>
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center">
                                <button type="submit" class="btn btn-outline-dark mt-auto">Add to cart</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            </c:forEach>
            </c:if>

        </div>
    </div>
    </div>
</section>

</body>

</html>