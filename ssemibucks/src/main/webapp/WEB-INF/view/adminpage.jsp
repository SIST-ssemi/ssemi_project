<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Ssemibucks_AdminPage</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/css/styles_mypage.css" rel="stylesheet" />
  </head>
  <style>
    .btnmodify {
      width: 600px;
      height: 100px;
    }
  </style>
  <body>
    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0">
      <a
        href="index"
        class="navbar-brand d-flex align-items-center px-4 px-lg-5"
      >
        <h2 class="m-0 text-primary">Ssemibucks</h2>
      </a>
      <button
        type="button"
        class="navbar-toggler me-4"
        data-bs-toggle="collapse"
        data-bs-target="#navbarCollapse"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto p-4 p-lg-0">
          <a href="index" class="nav-item nav-link active">Home</a>
          <a href="mypage" class="nav-item nav-link">My Page</a>
          <div class="nav-item dropdown">
            <a
              href="#"
              class="nav-link dropdown-toggle"
              data-bs-toggle="dropdown"
              >MENU</a
            >
            <div class="dropdown-menu fade-up m-0">
              <a href="#" class="dropdown-item">All menu</a>
              <a href="#" class="dropdown-item">Coffee</a>
              <a href="#" class="dropdown-item">Non-Coffee</a>
              <a href="#" class="dropdown-item">Desserts</a>
            </div>
          </div>
        </div>
        <a href="#" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block"
          >Cart<i class="fas fa-shopping-cart ms-3"></i
        ></a>
      </div>
    </nav>
    <!-- Navbar End -->
    <!-- Header - set the background image for the header in the line below-->
    <header class="py-5 bg-image-full">
      <div
        class="text-center my-5"
        style="
          background-image: linear-gradient(
              rgba(0, 0, 0, 0.3),
              rgba(0, 0, 0, 0.3)
            ),
            url(https://images.unsplash.com/photo-1580933073521-dc49ac0d4e6a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869&q=80);
        "
      >
        <img
          class="img-fluid rounded-circle mb-4"
          src="/img/user.JPG"
          alt="..."
          width="120px"
          height="120px"
        />
        <i class="fas fa-user"></i>
        <h1 class="text-white fs-3 fw-bolder">ADMIN</h1>
        <p class="text-white-50 mb-0">관리자 계정입니다</p>
      </div>
    </header>
    <!-- Content section-->
    <div class="container my-5">
      <div class="row justify-content-center">
        <table class="table table-stripped" align="center">
          <tr align="center">
            <td style="vertical-align: middle">
              <button
                type="button"
                class="btn mybtn btnmodify"
                onclick="location.href='#'"
              >
                회원목록조회
              </button>
            </td>
          </tr>
          <tr align="center">
            <td style="vertical-align: middle">
              <button
                type="button"
                class="btn mybtn btnmodify"
                onclick="location.href='#'"
              >
                회원강제탈퇴
              </button>
            </td>
          </tr>
          <tr align="center">
            <td style="vertical-align: middle">
              <button
                type="button"
                class="btn mybtn btnmodify"
                onclick="location.href='#'"
              >
                재고관리
              </button>
            </td>
          </tr>
        </table>
      </div>
    </div>

    <!-- Bootstrap core JS-->
  </body>
</html>
