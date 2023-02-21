<%@ page import="ssemi.ssemibucks.Controller.UserController" %>
<%@ page import="org.springframework.ui.Model" %>
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
    <link href="css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet"/>

    <script src="/js/includeHTML.js" type="text/javascript"></script>
</head>
<%
    UserController userController = new UserController();
%>

<body>
      <!-- Navbar -->
      <div include-html="/navbar"></div>
      <script>includeHTML();</script>


      <!-- Carousel Start -->
      <div class="container-fluid p-0 pb-5">
          <img class="img-fluid" src="./img/cafe.JPG" alt=""/>
          <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center"
               style="background: rgba(53, 53, 53, 0.7)">
              <div class="container">
                  <div class="row justify-content-center">
                      <div class="col-12 col-lg-8 text-center">
                          <h5 class="text-white text-uppercase mb-3 animated slideInDown">
                              Welcome To Ssemibucks
                          </h5>
                          <h3 class="display-3 text-white animated slideInDown mb-4">
                              Ssemibucks와 함께 커피 한잔의 여유를 가져보세요
                          </h3>
                          <p class="fs-5 fw-medium text-white mb-4 pb-2">
                              나의 취향이 머무는 곳. 더욱 편리하게 Ssemibucks를 만나보세요.<br>
                              함께해서 더 따뜻한 지역사회 소통 공간. 다양한 Ssemibucks 매장이
                              여러분을 기다립니다.
                          </p>

                          <% if (session.getAttribute("uId") == null) { %>

                          <a href="/user/user_login" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Login</a>
                          <a href="/user/user_register" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Sign Up</a>

                          <%
                          } else {
                          %>
                          <a href="/user/user_logout" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Log
                              out</a>

                          <%
                              }
                          %>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <!-- Carousel End -->

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
      <script src="js/main.js"></script>
   </body>
</html>