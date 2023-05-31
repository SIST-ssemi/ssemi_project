<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta charset="utf-8"/>
    <title>Ssemibucks</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="keywords"/>
    <meta content="" name="description"/>

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon"/>

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500&family=Roboto:wght@500;700;900&display=swap"
            rel="stylesheet"/>

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet"/>
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet"/>
    <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet"/>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<%
    String uId = (String) session.getAttribute("uId");
%>

<body>
<!-- Navbar Start -->
<nav class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0">
    <a href="/index" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
        <h2 class="m-0 text-primary">Ssemibucks</h2>
    </a>
    <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto p-4 p-lg-0">
            <a href="/index" class="nav-item nav-link active">Home</a>
            <a href="https://github.com/SIST-ssemi/ssemi_project" class="nav-item nav-link">About</a>

            <% if (session.getAttribute("uId") == null) { %>
            <a href="/user/user_login" class="nav-item nav-link"> My Page </a>
            <%
            } else if (session.getAttribute("uId").equals("admin")) { %>
            <a href="/admin/admin_adminpage" class="nav-item nav-link">Admin Page</a>
            <%
            } else {
            %>
            <a href="/user/user_mypage" class="nav-item nav-link">My Page</a>
            <%
                }
            %>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">MENU</a>
                <div class="dropdown-menu fade-up m-0">
                    <a href="/product/product_list" class="dropdown-item">All menu</a>
                    <a href="/product/product_categoryList?category=coffee" class="dropdown-item">Coffee</a>
                    <a href="/product/product_categoryList?category=non-coffee" class="dropdown-item">Non-Coffee</a>
                    <a href="/product/product_categoryList?category=dessert" class="dropdown-item">Dessert</a>
                </div>
            </div>
        </div>
        <% if (session.getAttribute("uId") == null) { %>
        <a href="/user/user_login" class="btn btn-light-g py-4 px-lg-5 d-none d-lg-block"
           style="border-radius: 0px; font-size: 14pt;">Cart<i
                class="fas fa-shopping-cart ms-3"></i></a>
        <%
        } else if (session.getAttribute("uId").equals("admin")) { %>
        <div></div>
        <%
        } else {
        %>
        <a href="/cart/cart_list?uId=<%=uId%>" class="btn btn-light-g py-4 px-lg-5 d-none d-lg-block"
           style="border-radius: 0px; font-size: 14pt;">Cart<i
                class="fas fa-shopping-cart ms-3"></i></a>
        <%
            }
        %>
    </div>
</nav>
<!-- Navbar End -->

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/counterup/counterup.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/isotope/isotope.pkgd.min.js"></script>
<script src="lib/lightbox/js/lightbox.min.js"></script>

<!-- Template Javascript -->
<script src="/js/main.js"></script>
</body>

</html>