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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet" />

    <script src="js/includeHTML.js" type="text/javascript"></script>
  </head>
  <style>
    .btnmodify {
      width: 600px;
      height: 100px;
    }
  </style>
  <body>
  <!-- Navbar -->
  <div include-html="navbar"></div>
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
         style="margin-top: 2rem;" />
    <h1 class="text-white fs-3 fw-bolder" style="margin-top: 0px;">ADMIN</h1>
    <p class=" text-white-50 mb-0">관리자 계정입니다</p>
  </div>
  </div>

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
