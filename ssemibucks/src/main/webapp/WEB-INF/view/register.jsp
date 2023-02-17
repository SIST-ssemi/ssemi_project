<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Register_ssemibucks</title>
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
    <style>
      body {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
      }

      .title {
        background-color: rgb(167, 193, 55);
        color: white;
        text-align: center;
        height: 125px;
      }

      .title h1 {
        line-height: 125px;
      }

      .table {
        width: 800px;
        height: 400px;
        margin-top: 50px;
      }

      th {
        width: 150px;
        text-align: center;
      }

      td {
        width: 300px;
      }

      input {
        width: 300px;
        height: 30px;
        border: 1px solid rgba(0, 0, 0, 0.1);
        border-radius: 3px;
      }

      .mybtn {
        background-color: rgb(167, 193, 55);
        border: rgb(167, 193, 55);
        color: white;
      }

      .mybtn:hover,
      .mybtn:active,
      .mybtn:focus {
        background-color: white;
        color: rgb(167, 193, 55);
        border: 1px solid rgb(167, 193, 55);
      }
    </style>
    <!-- <script>
      $(function () {
        $(".mybtn").mouseenter(function () {
          $(this).css({
            "background-color": "white",
            color: "##ffc675",
            border: "1px solid #ffc675",
          });
        });
      });
    </script> -->
  </head>
  <body>
    <div class="title"><h1>Sign Up</h1></div>
    <table class="table table-stripped" align="center">
      <tr>
        <div class="uId">
          <th style="vertical-align: middle">아이디</th>
          <td style="vertical-align: middle">
            <input type="text" placeholder="아이디 입력" />
            <button
              type="button"
              class="btn btn-sm mybtn"
              style="margin-left: 20px"
            >
              중복확인
            </button>
          </td>
        </div>
      </tr>
      <tr>
        <div class="pw">
          <th style="vertical-align: middle">비밀번호</th>
          <td style="vertical-align: middle">
            <input type="password" placeholder="비밀번호 입력" />
          </td>
        </div>
      </tr>
      <tr>
        <div class="uName">
          <th style="vertical-align: middle">이름</th>
          <td style="vertical-align: middle">
            <input type="text" placeholder="이름 입력" />
          </td>
        </div>
      </tr>
      <tr>
        <div class="hp">
          <th style="vertical-align: middle">전화번호</th>
          <td style="vertical-align: middle">
            <input
              type="text"
              placeholder="전화번호 입력 (' - ' 없이 입력해주세요.)"
            />
          </td>
        </div>
      </tr>
      <tr>
        <div class="addr">
          <th style="vertical-align: middle">주소</th>
          <td style="vertical-align: middle">
            <input type="text" placeholder="주소 입력" />
          </td>
        </div>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <button type="button" class="btn mybtn">회원가입</button>
        </td>
      </tr>
    </table>
  </body>
</html>
